package fr.epsi.b3devc2.entity;
import jakarta.persistence.EntityManager;
public class LivreService {
    private EntityManager entityManager;
    public LivreService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public  Livre_Entity findById(int id) {
        try {
            return entityManager.find(Livre_Entity.class, id);
        }catch(Exception e) {
            return null;
        }
    }

}
