package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {
	@PersistenceContext
	private EntityManager entityManager;


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(com.example.demo.DemoApplication.class, args);

		Product product1 = new Product(100,"Iphone 7",3100,2,new Date(),null);
		Product product2 = new Product(101,"Iphone 8",3400,4,new Date(),null);

		com.example.demo.DemoApplication app = context.getBean(com.example.demo.DemoApplication.class);

		//app.saveProduct(product1);
		//app.saveProduct(product2);
		//app.findProduct(100);
		//app.updateProduct(100);
		//app.deleteProduct(101);

		Student student1= new Student("Kaan","Kartal",new Date());
		Student student2 = new Student("Kardelen","Kartal",new Date());
		Student student3 = new Student("Tülay","Kartal",new Date());

		app.addStudent(student1);
		app.addStudent(student2);
		app.addStudent(student3);






	}

	@Transactional
	public void saveProduct(Product product) {
		entityManager.persist(product);
		System.out.println("Product saved successfully: " + product);
	}

	public Product findProduct(int id){
		Product product = entityManager.find(Product.class,id);
		System.out.println("Ürün Adı : " + product.getName());
		return product;
	}

	@Transactional
	public void updateProduct(int id){
		Product product = findProduct(id);
		product.setUnitPrice(3250);
		product.setUpdateDate(new Date());
		entityManager.merge(product);
	}

	@Transactional
	public void deleteProduct(int id){
		Product product = findProduct(id);
		entityManager.remove(product);
	}

	@Transactional
	public void addStudent(Student student){
		entityManager.persist(student);
	}

}
