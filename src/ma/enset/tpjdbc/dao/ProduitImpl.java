package ma.enset.tpjdbc.dao;

import ma.enset.tpjdbc.dao.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitImpl implements ProduitDao{
    @Override
    public List<Produit> findAll() throws SQLException {
        Connection connection=SingletonConnexionDB.getConnection();
        PreparedStatement statement=connection.prepareStatement("select * from produit");
        ResultSet resultSet=statement.executeQuery();
        List<Produit> produits=new ArrayList<>();
        while (resultSet.next()){

            Produit produit=new Produit();
            produit.setId(resultSet.getInt("ID"));
            produit.setNom(resultSet.getString("NOM"));
            produit.setDescription(resultSet.getString("DESCRIPTION"));
            produit.setPrix(resultSet.getFloat("PRIX"));
            produit.setQuantite(resultSet.getInt("QUANTITE"));
            produits.add(produit);

        }
        return produits;
    }

    @Override
    public Produit findOne(int id) throws SQLException {

        Connection connection=SingletonConnexionDB.getConnection();
        PreparedStatement statement=connection.prepareStatement("select * from produit where ID=?");
        statement.setInt(1,id);
        Produit produit=new Produit();
        ResultSet resultSet=statement.executeQuery();

        if (resultSet.next()){

            produit.setId(resultSet.getInt("ID"));
            produit.setNom(resultSet.getString("NOM"));
            produit.setDescription(resultSet.getString("DESCRIPTION"));
            produit.setPrix(resultSet.getFloat("PRIX"));
            produit.setQuantite(resultSet.getInt("QUANTITE"));

        }

        return produit;
    }

    @Override
    public Produit save(Produit o) throws SQLException {

        Connection connection=SingletonConnexionDB.getConnection();
        PreparedStatement statement=connection.prepareStatement("insert into produit(NOM,DESCRIPTION,PRIX,QUANTITE) values (?,?,?,?)");
        statement.setString(1,o.getNom());
        statement.setString(2,o.getDescription());
        statement.setFloat(3,o.getPrix());
        statement.setInt(4,o.getQuantite());
        statement.executeUpdate();

        return o;
    }

    @Override
    public boolean delete(Produit o) {

        try {
            Connection connection=SingletonConnexionDB.getConnection();
            PreparedStatement statement=connection.prepareStatement("delete from produit where ID=?");
            statement.setInt(1,o.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            return false;
        }
        return true;
    }

    @Override
    public Produit update(Produit o) throws SQLException {

        Connection connection=SingletonConnexionDB.getConnection();
        PreparedStatement statement=connection.prepareStatement("update produit set NOM=?,DESCRIPTION=?,PRIX=?,QUANTITE=? where ID=?");
        statement.setString(1,o.getNom());
        statement.setString(2,o.getDescription());
        statement.setFloat(3,o.getPrix());
        statement.setInt(4,o.getQuantite());
        statement.setInt(5,o.getId());
        statement.executeUpdate();
        return o;
    }
    @Override
    public List<Produit> find(String str) throws SQLException {

        Connection connection=SingletonConnexionDB.getConnection();
        PreparedStatement statement=connection.prepareStatement("select * from produit where NOM like ?");
        statement.setString(1,"%"+str+"%");
        ResultSet resultSet=statement.executeQuery();
        List<Produit> produits=new ArrayList<>();
        while (resultSet.next()){
            Produit produit=new Produit();
            produit.setId(resultSet.getInt("ID"));
            produit.setNom(resultSet.getString("NOM"));
            produit.setDescription(resultSet.getString("DESCRIPTION"));
            produit.setPrix(resultSet.getFloat("PRIX"));
            produit.setQuantite(resultSet.getInt("QUANTITE"));
            produits.add(produit);
        }
        return produits;
    }
}
