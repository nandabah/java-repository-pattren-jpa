package id.nan.repository.Impl;

import id.nan.model.Course;
import id.nan.model.Teacher;
import id.nan.model.User;
import id.nan.repository.UserRepository;
import id.nan.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

/**
 * Implementation of UserRepository interface for managing User entities in the
 * database
 * Implementasi dari interface UserRepository untuk mengelola entitas User dalam
 * database
 */
public class UserRepositoryImpl implements UserRepository {
    // Entity manager for handling persistence operations
    // Entity manager untuk menangani operasi persistensi
    private EntityManager entityManager;

    // Transaction manager for handling database transactions
    // Transaction manager untuk menangani transaksi database
    private EntityTransaction entityTransaction;

    @Override
    public User InsertUser(User user, Teacher teacher) {
        // Get entity manager instance from JpaUtil
        // Mendapatkan instance entity manager dari JpaUtil
        entityManager = JpaUtil.getEntityManager();

        Course course = new Course(null, "Java", teacher, null);

        // Get transaction instance from entity manager
        // Mendapatkan instance transaction dari entity manager
        entityTransaction = entityManager.getTransaction();

        // Start the transaction
        // Memulai transaksi
        entityTransaction.begin();

        // Save user object to database
        // Menyimpan objek user ke database
        entityManager.persist(user);

        // Commit the transaction to make changes permanent
        // Melakukan commit transaksi untuk menyimpan perubahan secara permanen
        entityTransaction.commit();

        return user;
    }
}
