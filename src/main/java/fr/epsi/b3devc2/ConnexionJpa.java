package fr.epsi.b3devc2;

import fr.epsi.b3devc2.entity.Livre_Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class ConnexionJpa {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            Livre_Entity livre = em.find(Livre_Entity.class, 1);
            if(livre != null) {
                System.out.println(livre.getId()+ " " + livre.getTitre()+ " " + livre.getAuteur());
            }
            em.getTransaction().commit();
        }

    }
}
