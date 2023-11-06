package com.example.demo;

import com.example.demo.model.Contact;
import com.example.demo.model.Personel;
import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class ElementCollectionMain {
    @PersistenceContext
    private EntityManager entityManager;


    public static <List> void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ElementCollectionMain.class, args);

        ElementCollectionMain app = context.getBean(ElementCollectionMain.class);


        Personel personel = new Personel("Kaan","Kartal",new Date());

        personel.getPhoneNumbers().add("0888888");




        app.addPersonel(personel);



    }

    @Transactional
    public void addPersonel(Personel personel){
        entityManager.persist(personel);

    }



}
