package helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class DynamicViews {
    public static void loadBorderCenter(BorderPane borderPane, String resource) throws IOException{
        Parent myAccount = FXMLLoader.load(new DynamicViews().getClass().getResource("/views/myAccount.fxml"));

        borderPane.setCenter(myAccount);
    }
}
