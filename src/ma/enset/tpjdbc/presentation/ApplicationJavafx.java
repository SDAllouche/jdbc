package ma.enset.tpjdbc.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class ApplicationJavafx extends Application{

    public ApplicationJavafx() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        BorderPane root = (BorderPane)FXMLLoader.load(this.getClass().getResource("view/Produit.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Gestion des Produits");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
