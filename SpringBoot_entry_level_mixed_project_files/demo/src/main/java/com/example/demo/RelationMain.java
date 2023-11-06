package com.example.demo;

import com.example.demo.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class RelationMain {
    @PersistenceContext
    private EntityManager entityManager;


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RelationMain.class, args);

        RelationMain app = context.getBean(RelationMain.class);

        /*Customer customer = new Customer("Kaan","Kartal",new Date());
        Address address = new Address("Fığla Mah","Alanya",07000);
        customer.setAddress(address);
        app.addCustomer(customer,address);
        System.out.println(app.findCustomer().getFirstName()); */ // one to one bitti.


        // Smdi OneToMany iliskisine bakacağız : Seller, Product. Bir ürünü sadece bir satıcı satabilir olarak bakıcaz.


        Seller seller = new Seller("Kaan","Kartal");

        Product product = new Product("IPhone 7",3100,3,new Date(),null);

        Product product1 = new Product("IPhone 8",3300,6,new Date(),null);


        // Eğer burası olmaz ise product tablosunda seller id null kalıyor.
        product.setSeller(seller);
        product1.setSeller(seller);

        seller.setProducts(Arrays.asList(product,product1));

        app.addSeller(seller);


        //String x = app.findSeller(product.getProductId()).getSellerFirstName();

        //System.out.println(x);







    }


    @Transactional
    public void addCustomer(Customer customer, Address address){
        entityManager.persist(customer);
    }

    @Transactional
    public Customer  findCustomer(){
        Customer customer = entityManager.find(Address.class,1).getCustomer();
        return customer;
    }

    @Transactional
    public void addSeller(Seller seller){
        entityManager.persist(seller);
    }

    @Transactional
    public void addProduct(Product product){
        entityManager.persist(product);

    }

    @Transactional
    public void addSellerAndProducts(Seller seller, List<Product> products) {
        entityManager.persist(seller);
        for (Product product : products) {
            entityManager.persist(product);
        }
    }

    public Seller findSeller(int  productId){
        Product p = entityManager.find(Product.class,productId);
        return p.getSeller();
    }




}
