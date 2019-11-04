package be.kapture.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraper {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://www.takeaway.com/be/pizza-talia-mortsel").get();

			System.out.printf("Title: %s\n", doc.title());

			Elements items = doc.getElementsByClass("meal-container");

			for(Element item : items) {
				System.out.print(item.getElementsByClass("meal-name").text() + " ");
				System.out.println(item.getElementsByClass("meal__price").text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
