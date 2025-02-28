package fr.epsi.b3devc2;

import fr.epsi.b3devc2.entity.Client_Entity;
import fr.epsi.b3devc2.entity.Emprunt_Entity;
import fr.epsi.b3devc2.entity.Livre_Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
             EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            Emprunt_Entity emprunt = getEmpruntById(em, 1);
            if (emprunt != null) {
                System.out.println("Emprunt id : " + emprunt.getId() + " Date début : " + emprunt.getDate_debut() +
                        " Date fin : " + emprunt.getDate_fin() + " Délai : " + emprunt.getDelai());

                for (Livre_Entity livre : emprunt.getLivres()) {
                    System.out.println("Livre associé : " + livre.getTitre() + " par " + livre.getAuteur());
                }
            } else {
                System.out.println("Aucun emprunt trouvé avec l'ID spécifié.");
            }Client_Entity client = em.find(Client_Entity.class, 1);
            if (client != null) {
                for (Emprunt_Entity emprunts : client.getEmprunts()) {
                    System.out.println("Emprunt ID : " + emprunts.getId() + ", Date début : " + emprunts.getDate_debut() +
                            ", Date fin : " + emprunts.getDate_fin() + ", Délai : " + emprunts.getDelai());
                }
            } else {
                System.out.println("Aucun client trouvé avec l'ID spécifié.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Emprunt_Entity getEmpruntById(EntityManager em, int id) {
        return em.find(Emprunt_Entity.class, id);
    }
}
