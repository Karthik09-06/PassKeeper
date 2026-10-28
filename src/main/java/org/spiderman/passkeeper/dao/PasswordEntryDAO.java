package org.spiderman.passkeeper.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.spiderman.passkeeper.entity.PasswordEntry;
import org.spiderman.passkeeper.util.HibernateUtil;

import java.util.List;

public class PasswordEntryDAO {

    public void save(PasswordEntry passwordEntry) {
        EntityManager entityManager = HibernateUtil
                .getEntityManagerFactory()
                .createEntityManager();

        EntityTransaction transaction = entityManager
                .getTransaction();

        try {
            transaction.begin();
            entityManager.persist(passwordEntry);
            transaction.commit();
        } catch (Exception e) {

            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    public List<PasswordEntry> findAll() {

        EntityManager entityManager = HibernateUtil
                .getEntityManagerFactory()
                .createEntityManager();

        EntityTransaction transaction = entityManager
                .getTransaction();

        try {
            return entityManager
                    .createQuery(
                            "select p from PasswordEntry p order by p.id",
                            PasswordEntry.class
                    ).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    public PasswordEntry findById(long id) {

        EntityManager entityManager = HibernateUtil
                .getEntityManagerFactory()
                .createEntityManager();

        try {
            return entityManager.find(PasswordEntry.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    public boolean update(PasswordEntry passwordEntry) {
        EntityManager entityManager = HibernateUtil
                .getEntityManagerFactory()
                .createEntityManager();

        EntityTransaction transaction = entityManager
                .getTransaction();

        try {
            transaction.begin();
            entityManager.merge(passwordEntry);
            transaction.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    public void delete(Long id) {
        EntityManager entityManager = HibernateUtil
                .getEntityManagerFactory()
                .createEntityManager();

        EntityTransaction transaction = entityManager
                .getTransaction();


        try {
            transaction.begin();

            PasswordEntry entry = entityManager
                    .find(PasswordEntry.class, id);

            if (entry != null) {
                entityManager.remove(entry);
            }

            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }
}
