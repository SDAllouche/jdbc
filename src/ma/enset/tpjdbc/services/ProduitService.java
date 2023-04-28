package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.dao.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public interface ProduitService {

    void addProduit(Produit p) throws SQLException;
    void deleteProduit(Produit p) throws SQLException;

    void updateProduit(Produit p) throws SQLException;
    List<Produit> getProduits(String str) throws SQLException;

    List<Produit> getAllProduits() throws SQLException;

}
