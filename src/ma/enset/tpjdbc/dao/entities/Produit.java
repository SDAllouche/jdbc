package ma.enset.tpjdbc.dao.entities;

import java.io.Serializable;

public class Produit implements Serializable {

    private int id;
    private String nom, description;
    private Float prix;
    private int quantite;

    public Produit() {
    }

    public Produit(String nom, String description, Float prix, int quantite) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
