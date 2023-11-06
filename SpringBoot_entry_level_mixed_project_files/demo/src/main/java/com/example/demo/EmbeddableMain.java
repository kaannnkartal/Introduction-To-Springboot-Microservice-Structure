package com.example.demo;

import com.example.demo.model.Contact;
import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class EmbeddableMain {
    @PersistenceContext
    private EntityManager entityManager;


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmbeddableMain.class, args);

        EmbeddableMain app = context.getBean(EmbeddableMain.class);


        User user1 = new User("Kaan","123",new Contact("05555555","y@gmail.com","x.com"),null);

        app.addUser(user1);


    }


    @Transactional
    public void addUser(User user){
        entityManager.persist(user);
    }


}
