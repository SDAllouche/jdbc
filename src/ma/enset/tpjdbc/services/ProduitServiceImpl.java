package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.dao.ProduitDao;
import ma.enset.tpjdbc.dao.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public class ProduitServiceImpl implements ProduitService{

    ProduitDao produitDao;

    public ProduitServiceImpl(ProduitDao produitDao) {
        this.produitDao=produitDao;
    }

    @Override
    public void addProduit(Produit p) throws SQLException { produitDao.save(p); }

    @Override
    public void deleteProduit(Produit p) throws SQLException { produitDao.delete(p); }

    @Override
    public void updateProduit(Produit p) throws SQLException { produitDao.update(p); }

    @Override
    public List<Produit> getProduits(String str) throws SQLException { return produitDao.find(str); }

    public List<Produit> getAllProduits() throws SQLException { return this.produitDao.findAll(); }

}
