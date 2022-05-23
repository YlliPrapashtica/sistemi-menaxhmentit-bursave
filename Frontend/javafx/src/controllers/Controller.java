package controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private BorderPane border_pane;

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }


    public void show_ViewAllApplicants(javafx.scene.input.MouseEvent event) throws IOException {
        Parent ViewAllApplicants = FXMLLoader.load(getClass().getResource("/views/ViewAllApplicants.fxml"));
        border_pane.setCenter(ViewAllApplicants);

    }

    public void show_myAccount(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent myAccount = FXMLLoader.load(getClass().getResource("/views/myAccount.fxml"));
        border_pane.setCenter(myAccount);
    }

    public void show_applyform(MouseEvent mouseEvent2) throws IOException {
        Parent Apply = FXMLLoader.load(getClass().getResource("/views/Apply.fxml"));
        border_pane.setCenter(Apply);
    }



}
