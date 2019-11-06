package be.kapture.api;

import be.kapture.models.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static be.kapture.orm.HibernateUtils.getSessionFactory;

public class WebService {
	public static void main(String[] args) {
		Product pizza = new Product("Pizza Calzone", 15.30);

		Transaction transaction = null;

		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(pizza);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}


		try (Session session = getSessionFactory().openSession()) {
			List<Product> products = session.createQuery("from Product", Product.class).list();
			products.forEach(p -> System.out.println(p.getName()));
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}
}
