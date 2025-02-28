package fr.epsi.b3devc2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "DATE_DEBUT")
    private String Date_debut;
    @Column(name = "DATE_FIN")
    private String Date_fin;
    @Column(name = "DELAI")
    private int Delai;
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private Client_Entity client;
    @ManyToMany
    @JoinTable(name = "COMPO", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
    private List<Livre_Entity> livres;
    public String getDate_debut() {
        return Date_debut;
    }
    public void setDate_debut(String date_debut) {
        Date_debut = date_debut;
    }
    public String getDate_fin() {
        return Date_fin;
    }
    public void setDate_fin(String date_fin) {
        Date_fin = date_fin;
    }
    public int getDelai() {
        return Delai;
    }
    public void setDelai(int delai) {
        Delai = delai;
    }
    public Client_Entity getClient() {
        return client;
    }
    public void setClient(Client_Entity client) {
        this.client = client;
    }
    public int getId() {
        return id;
    }
    public List<Livre_Entity> getLivres() {
        return livres;
    }
    public void setLivres(List<Livre_Entity> livres) {
        this.livres = livres;
    }


}

