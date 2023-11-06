package com.example.demo2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JPQLApplication {
    @PersistenceContext
    private EntityManager entityManager;


    public static void main(String[] args) {





    }


}
