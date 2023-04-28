package ma.enset.tpjdbc.dao;

import ma.enset.tpjdbc.dao.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        ProduitDao produitDao=new ProduitImpl();

        /*Produit produit=new Produit();
        produit.setNom("Laptop");
        produit.setDiscreption("HP");
        produit.setPrix(5000F);
        produit.setQuantite(4);
        produitDao.save(produit);*/

        Produit produit=produitDao.findOne(1);
        produit.setPrix(6000F);
        produit.setDescription("Samsung");
        produitDao.update(produit);

        List<Produit> produits=produitDao.findAll();
        for (Produit p:produits){
            System.out.println(p.getId()+" | "+p.getNom()+" | "+p.getDescription()+" | "+p.getPrix()+" | "+p.getQuantite());
        }

    }
}
