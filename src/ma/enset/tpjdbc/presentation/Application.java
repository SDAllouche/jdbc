package ma.enset.tpjdbc.presentation;

import ma.enset.tpjdbc.dao.ProduitImpl;
import ma.enset.tpjdbc.dao.entities.Produit;
import ma.enset.tpjdbc.services.ProduitService;
import ma.enset.tpjdbc.services.ProduitServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        ProduitService produitService=new ProduitServiceImpl(new ProduitImpl());
        List<Produit> produits= produitService.getProduits("A");
        for (Produit p:produits){
            System.out.println(p.getId()+" | "+p.getNom()+" | "+p.getDescription()+" | "+p.getPrix()+" | "+p.getQuantite());
        }
    }
}
