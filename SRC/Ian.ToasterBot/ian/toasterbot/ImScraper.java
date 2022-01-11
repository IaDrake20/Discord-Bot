package ian.toasterbot;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class ImScraper {

    private static final String link = "https://www.google.com/search?q=";
    private static String text = "";
    private static String imageUrl = "";

    public static void setHtml(String search){

        text = search;      
    }

    public static String scrape(){
        System.out.println("Scraping for images of "+text+" at "+link+text);
        Document document = Jsoup.parse(link+text);
        Elements images = document.select("img");
        
        for (Element image : images) {
            System.out.println("Iteration");
            String imageUrl = image.attr("data-original");
            if(imageUrl != null){
                System.out.println("Leaving for loop");
                break;
            }
        }
        return imageUrl;
    }
}
