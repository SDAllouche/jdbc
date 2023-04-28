package ma.enset.tpjdbc.dao;

import ma.enset.tpjdbc.dao.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public interface ProduitDao extends Dao<Produit>{

    List<Produit> find(String str) throws SQLException;
}
