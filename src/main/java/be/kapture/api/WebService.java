package be.kapture.api;

import be.kapture.models.Product;
import be.kapture.web.Scraper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static be.kapture.orm.HibernateUtils.getSessionFactory;
import static be.kapture.orm.HibernateUtils.shutdown;

public class WebService {
	public static void main(String[] args) {
		Transaction transaction = fetchProducts();

		try (Session session = getSessionFactory().openSession()) {
			List<Product> products = session.createQuery("from Product", Product.class).list();
			products.forEach(p -> System.out.println(p.getName()));
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}

		shutdown();
	}

	private static Transaction fetchProducts() {
		List<Product> fetchedProducts = Scraper.getProducts();

		Transaction transaction = null;

		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			for(Product product : fetchedProducts) {
				session.save(product);
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return transaction;
	}
}
