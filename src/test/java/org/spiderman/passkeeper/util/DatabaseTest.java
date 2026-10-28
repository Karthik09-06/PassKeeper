package org.spiderman.passkeeper.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.Test;
import org.spiderman.passkeeper.entity.PasswordEntry;

import java.util.Random;

public class DatabaseTest {

    @Test
    public void shouldConnectToDatabase() {
        EntityManager entityManager = HibernateUtil
                .getEntityManagerFactory()
                .createEntityManager();

        EntityTransaction transaction = entityManager
                .getTransaction();

        try {

            transaction.begin();

            Random random = new Random();
            Long id = random.nextLong();

            PasswordEntry entry = new PasswordEntry(
                    "google",
                    "karthiksg664@gmail.com",
                    "KakashiHatake664");

            entityManager.persist(entry);

            transaction.commit();
            System.out.println("Successful");

        } catch (Exception e) {

            if (transaction.isActive()){
                transaction.rollback();
            }

            System.out.println("Failed");
            e.printStackTrace();
            throw new RuntimeException(e);

        } finally {

            entityManager.close();

        }
    }
}
