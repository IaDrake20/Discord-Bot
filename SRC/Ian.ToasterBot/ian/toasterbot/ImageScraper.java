package ian.toasterbot;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ImageScraper {

    static String input = "toast";

        //input = toast;
        //The url of the website
        private static final String webSiteURL = "https://www.google.com/search?q="+input;
        
        //The path of the folder that you want to save the images to
        private static String folderPath = "H:\\Image Scraper";
        static Integer lastPage = 0;
        static Integer LP = 0;
        
        public static void main(String[] args) throws UnknownHostException {

            final ImageScraper scraper = new ImageScraper();
            String htmlContent;
            
            try {
                htmlContent = scraper.getContent();
            
            final String extractedTitle = scraper.extractTitle(htmlContent);
            final String extractedImage = scraper.extractImage();
            System.out.println(extractedTitle);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter the folder path: ");
            final String path = in.nextLine();
            folderPath = path;
        
            System.out.print("Please enter the ammount of pages to be scraped: ");
            final Integer lp = in.nextInt();
            LP = lp;
        
            // start downloading loop
            for (int i = 1; i <= LP; i++) {
                try {
        
                    //Connect to the website and get the html – take a look at "page/" This is how the pages are seperated
                    Document doc = Jsoup.connect(webSiteURL + "page/" + i).get();
        
                    //Get all elements with img tag ,
                    Elements img = doc.getElementsByTag("img");
        
                    for (Element el : img) {
        
                        //for each element get the srs url
                        String src = el.absUrl("src");
        
                        System.out.println("Image Found!");
                        System.out.println("src attribute is : " + src);
        
                        getImages(src);
                    }
        
                } catch (IOException ex) {
                    System.err.println("There was an error: " + ex);
                }
            }
        }
        
        private static void getImages(String src) throws IOException {
        
        int indexname = src.lastIndexOf("/");
        
        if (indexname == src.length()) {
        src = src.substring(1, indexname);
        }
        
        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname, src.length());
        
        System.out.println(name);
        
        //Open a URL Stream
        URL url = new URL(src);
        InputStream in = url.openStream();
        
        OutputStream out = new BufferedOutputStream(new FileOutputStream(folderPath + name));
        
        for (int b; (b = in.read()) != -1;) {
        out.write(b);
        }
        out.close();
        in.close();
        }
        
    public static void scrape(){
        System.out.println("WIP");
    }

    private String getContent() throws IOException {
        final OkHttpClient client = new OkHttpClient.Builder().build();
        final String urlToScrape = "https://www.google.com/search?q="+input;
        final Request request = new Request.Builder().url(urlToScrape).build();
        final Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private String extractTitle(String content) {
        final Pattern titleRegExp = Pattern.compile("<title>(.*?)</title>", Pattern.DOTALL);
        final Matcher matcher = titleRegExp.matcher(content);
        matcher.find();
        return matcher.group(1);
    }

    private String extractImage(){
        //final Matcher matcher = image
        
        return "Method not finished";
    }

    public static void setInput(String in) {
        input = in;
    }

    public static String getInput(){
        return input;
    }
}