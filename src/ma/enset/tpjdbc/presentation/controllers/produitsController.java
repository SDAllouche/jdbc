//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ma.enset.tpjdbc.presentation.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ma.enset.tpjdbc.dao.ProduitImpl;
import ma.enset.tpjdbc.dao.entities.Produit;
import ma.enset.tpjdbc.services.ProduitService;
import ma.enset.tpjdbc.services.ProduitServiceImpl;

public class produitsController implements Initializable {

    private int id;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textDescription;
    @FXML
    private TextField textPrix;
    @FXML
    private TextField textQuantite;

    @FXML
    private TextField textSearch;
    @FXML
    private TableView<Produit> tableView = new TableView<>();

    @FXML
    private TableColumn<Produit,Integer> colId;

    @FXML
    private TableColumn<Produit,String> colNom;

    @FXML
    private TableColumn<Produit,Float> colPrix;

    @FXML
    private TableColumn<Produit,Integer> colQuantite;
    private ObservableList<Produit> produitList = FXCollections.observableArrayList();
    private ProduitService produitService = new ProduitServiceImpl(new ProduitImpl());

    public produitsController() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.tableView.setItems(this.produitList);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        try {
            produitList.addAll(produitService.getAllProduits());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        textSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                produitList.clear();
                try {
                    produitList.addAll(produitService.getProduits(newValue));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    Produit p =tableView.getSelectionModel().getSelectedItem();
                    clearProduit();
                    id=p.getId();
                    textNom.setText(p.getNom());
                    textDescription.setText(p.getDescription());
                    textPrix.setText(String.valueOf(p.getPrix()));
                    textQuantite.setText(String.valueOf(p.getQuantite()));
                }
            }
        });
    }

    @FXML
    public void addProduit() throws SQLException {
        String nom = this.textNom.getText();
        String description = this.textDescription.getText();
        if (!nom.isEmpty() && !description.isEmpty() && !this.textPrix.getText().isEmpty() && !this.textQuantite.getText().isEmpty()) {
            float prix = Float.parseFloat(this.textPrix.getText());
            int quantite = Integer.parseInt(this.textQuantite.getText());
            Produit produit = new Produit();
            produit.setNom(nom);
            produit.setDescription(description);
            produit.setPrix(prix);
            produit.setQuantite(quantite);
            this.produitService.addProduit(produit);
            this.loadProduits();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("Veuillez remplir tout les champs !");
            alert.show();
        }

    }

    @FXML
    public void deleteProduit() throws SQLException {
        MultipleSelectionModel<Produit> produit = this.tableView.getSelectionModel();
        if (produit != null) {
            this.produitService.deleteProduit((Produit)produit.getSelectedItem());
            this.produitList.remove(produit.getSelectedIndex());
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("Veuillez selectionner un element ! !");
            alert.show();
        }

    }

    @FXML
    public void updateProduit() throws SQLException {

        String nom = this.textNom.getText();
        String description = this.textDescription.getText();
        if (!nom.isEmpty() && !description.isEmpty() && !this.textPrix.getText().isEmpty() && !this.textQuantite.getText().isEmpty()) {
            float prix = Float.parseFloat(this.textPrix.getText());
            int quantite = Integer.parseInt(this.textQuantite.getText());
            Produit produit = new Produit();
            produit.setId(id);
            produit.setNom(nom);
            produit.setDescription(description);
            produit.setPrix(prix);
            produit.setQuantite(quantite);
            produitService.updateProduit(produit);
            clearProduit();
            loadProduits();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("Veuillez remplir tout les champs !");
            alert.show();
        }

    }

    @FXML
    public void clearProduit() {
        textNom.clear();
        textDescription.clear();
        textPrix.clear();
        textQuantite.clear();
    }

    private void loadProduits() throws SQLException {
        this.produitList.clear();
        this.produitList.addAll(this.produitService.getAllProduits());
    }
}

