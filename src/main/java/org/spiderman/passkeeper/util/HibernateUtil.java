package org.spiderman.passkeeper.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.
            createEntityManagerFactory("PassKeeperPU");

    private HibernateUtil() {
        // Prevents Object Creation
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }

    public static void shutdown() {
        if (ENTITY_MANAGER_FACTORY.isOpen()) {
            ENTITY_MANAGER_FACTORY.close();
        }
    }
}
