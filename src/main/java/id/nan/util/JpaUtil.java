package id.nan.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Utility class for managing JPA EntityManager instances.
 * This class provides centralized access to EntityManager creation and management.
 * It follows the singleton pattern for EntityManagerFactory to ensure efficient resource usage.
 *
 * Kelas utilitas untuk mengelola instance JPA EntityManager.
 * Kelas ini menyediakan akses terpusat untuk pembuatan dan pengelolaan EntityManager.
 * Menggunakan pola singleton untuk EntityManagerFactory untuk memastikan penggunaan sumber daya yang efisien.
 */
public class JpaUtil {
    /// To make it easier to use JPA, we created a utility class:

    // Single instance of EntityManagerFactory to be reused across the application
    // Instance tunggal EntityManagerFactory yang akan digunakan di seluruh aplikasi
    private static EntityManagerFactory entityManagerFactory;
    private static final String PERSISTENCE_UNIT_NAME = "repository-patren-java";

    /**
     * Private method to initialize the EntityManagerFactory.
     * Creates a new EntityManagerFactory using the configured persistence unit.
     *
     * Method private untuk menginisialisasi EntityManagerFactory.
     * Membuat EntityManagerFactory baru menggunakan unit persistence yang telah dikonfigurasi.
     */
    private static void getEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    /**
     * Get an EntityManager instance from the factory.
     * Creates a new EntityManagerFactory if it hasn't been initialized.
     * @return A new EntityManager instance
     *
     * Mendapatkan instance EntityManager dari factory.
     * Membuat EntityManagerFactory baru jika belum diinisialisasi.
     * @return Instance EntityManager baru
     */
    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            getEntityManagerFactory();
        }
        return entityManagerFactory.createEntityManager();
    }

    /**
     * Closes the EntityManagerFactory and releases all resources.
     * Should be called when the application is shutting down.
     *
     * Menutup EntityManagerFactory dan membebaskan semua sumber daya.
     * Harus dipanggil ketika aplikasi akan dimatikan.
     */
    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            entityManagerFactory = null;
        }
    }
}
