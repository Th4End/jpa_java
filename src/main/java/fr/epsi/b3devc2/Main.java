package fr.epsi.b3devc2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();

        System.out.println("Connexion à la BDD OK");

        em.close();
        emf.close();
    }
}