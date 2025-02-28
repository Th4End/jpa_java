package fr.epsi.b3devc2.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @OneToMany(mappedBy = "client")
    private List<Emprunt_Entity> emprunts;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Emprunt_Entity> getEmprunts() {
        return emprunts;
    }
}
