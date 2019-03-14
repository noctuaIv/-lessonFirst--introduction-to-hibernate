package edu.voytovych;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import models.Product;
import models.ProductCategory;


public class Main {

	public static void main(String[] args) {
		/*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Object> products = null;
		
		try {
			session.beginTransaction();
			
			//Query query = session.createQuery("SELECT * FROM product");
			
			Product product = new Product();
			
			//session.update(product);
			//session.delete(product);
			
			int []mas = {1,2,3,4,5,6};
			Criteria criteria1 = session.createCriteria(Product.class, "p"); // select * from product p;
			criteria1.add(Restrictions.eq("title", "Ocean")); // [select * from product where title = "Ocean"]
			criteria1.add(Restrictions.eq("person", "1")); // [select * from product where title = "Ocean" and person = "1"]
			criteria1.add(Restrictions.eq("id", mas)); // [select * from product where title = "Ocean" and person = "1" and id in (1,2,3,4,5,6)]
			criteria1.add(Restrictions.between("id", 5, 20));
			criteria1.add(Restrictions.like("id", "10")); // where price like %gggg%
			criteria1.add(Restrictions.or(Restrictions.not(Restrictions.in("id", mas))));
			criteria1.add(Restrictions.sqlRestriction("date > 2015-01-01")); // можна вставляти звичайний sql
			criteria1.addOrder(Order.desc("id")); // отримаємо відсортовані дані по спаданню
			
			criteria1.setMaxResults(1); //задаємо максимальну кількість повернутого результату
			
			Criteria criteria2 = session.createCriteria(ProductCategory.class, "productCategory");
			criteria2.createCriteria("productCategory.product", "product");
			criteria2.add(Restrictions.eq("ProductCategory.title","cat"));
			criteria2.setProjection(Projections.distinct(Projections.property("product")));
			criteria2.list();
			
			session.save(product);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		
		for(java.util.Iterator<Object> iterator = products.iterator(); iterator.hasNext();){
			Product product = (Product) iterator.next();
			System.out.println(product.toString());
		}*/
		
		
		// приклад валідації
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		Product product = new Product();
		Set<ConstraintViolation<Product>> constrs = validator.validate(product);
		
		for (ConstraintViolation<Product> constraintViolation : constrs) {
			constraintViolation.getInvalidValue();
			constraintViolation.getMessage();
			constraintViolation.getPropertyPath();
		}
		
	}

}















