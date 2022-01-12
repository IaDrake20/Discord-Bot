package ian.toasterbot;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class ImScraper {

    private static String text = "";
    private static String imageUrl = "";
    private static String link = "https://www.google.com/search?q="+text+"&tbm=isch&sxsrf=AOaemvJvHPZgaO1CT2liDgkRarOOlVQeyg:1641917135681&source=hp&biw=1920&bih=927&ei=z6rdYeLRJvLLytMP2pGLqAo&iflsig=ALs-wAMAAAAAYd24394FZFKkyYuGTc6pTnfFwJ9rVHtQ&oq=&gs_lcp=CgNpbWcQARgAMgoIIxDvAxDqAhAnMgoIIxDvAxDqAhAnMgoIIxDvAxDqAhAnMgoIIxDvAxDqAhAnMgoIIxDvAxDqAhAnMgoIIxDvAxDqAhAnMgoIIxDvAxDqAhAnMgoIIxDvAxDqAhAnUABYAGCyCGgBcAB4AIABAIgBAJIBAJgBAKoBC2d3cy13aXotaW1nsAEI&sclient=img";


    public static void setHtml(String search){

        text = search;      
    }

    public static String scrape(){
        System.out.println("Scraping for images of "+text+" at "+link);
        Document document = Jsoup.parse(link);
        Elements images = document.select("img");

        System.out.println("above for loop");
        
        /*
        for (Element image : images) {
            System.out.println("Iteration");
            String imageUrl = image.attr("data-original");
            if(imageUrl != null){
                System.out.println("Leaving for loop");
                break;
            }
        }
        */

        

        for (Element image : images) {
            imageUrl = image.attr("data-original");
            System.out.println(imageUrl);
        }
        return imageUrl;//"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/ToastedWhiteBread.jpg/220px-ToastedWhiteBread.jpg";
    }
}
