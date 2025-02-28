package fr.epsi.b3devc2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LIVRE")
public class Livre_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "TITRE")
    private String titre;
    @Column(name = "AUTEUR")
    private String auteur;
    @ManyToMany(mappedBy = "livres")
    private List<Emprunt_Entity> emprunt;
    public Livre_Entity() {}
    public Livre_Entity(int id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
