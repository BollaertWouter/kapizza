package be.kapture.web;

import be.kapture.models.Product;
import be.kapture.models.Sizing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Double.valueOf;

public class Scraper {
	private static Logger logger = Logger.getLogger(Scraper.class.getName());

	public static List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.takeaway.com/be/pizza-talia-mortsel").get();

			System.out.printf("Title: %s\n", doc.title());

			Elements items = doc.getElementsByClass("meal-container");

			for (Element item : items) {
				String itemName = item.getElementsByClass("meal-name").text();

				String productName = getProductName(itemName);
				Sizing productSize = getProductSize(itemName);
				Double productPrice = convertPriceToDouble(item.getElementsByClass("meal__price").text());

				products.add(new Product(productName, productPrice, productSize));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return products;
	}

	static Double convertPriceToDouble(String price) {
		String priceWithoutSymbol = price.replace("€", "");
		String priceWithDotDecimal = priceWithoutSymbol.replace(",", ".");

		try {
			return valueOf(priceWithDotDecimal);
		} catch (NumberFormatException e) {
			logger.log(Level.WARNING, "Failed to convert String (" + price + ") to double");
		}

		return -1.0;
	}

	static String getProductName(String product) {
		for (Sizing size : Sizing.values()) {
			if (product.contains(size.getSize())) {
				return product.replace(size.getSize(), "").trim();
			}

			if (size.getVolume() != null && product.contains(size.getVolume())) {
				return product.replace(size.getVolume(), "").trim();
			}
		}

		return product;
	}

	static Sizing getProductSize(String product) {
		for (Sizing size : Sizing.values()) {
			if (product.contains(size.getSize())) {
				return size;
			}

			if (size.getVolume() != null && product.contains(size.getVolume())) {
				return size;
			}
		}

		return null;
	}
}
