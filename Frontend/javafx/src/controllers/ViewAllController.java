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

public class ViewAllController implements Initializable {

    @FXML
    private BorderPane border_pane1;

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

    public void show_applicantInfo(MouseEvent event) throws IOException {
        Parent applicantInfo = FXMLLoader.load(getClass().getResource("/views/applicantInfo.fxml"));
        border_pane1.setCenter(applicantInfo);
    }
}
