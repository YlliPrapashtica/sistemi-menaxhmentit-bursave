package controllers;
 

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text; 

public class SingleApplicantBoxController {

	@FXML
    private  Text fullNameValue;  
	@FXML
    private  HBox singleUserHBox;  
	
	@FXML
    public void initialize(){  
    } 
	
	 
	@FXML
	public void setFullName(String fullName) {
		fullNameValue.setText(fullName);
	}
	public void setOnClickEvent(BorderPane border_pane1,String id) {
		singleUserHBox.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	  
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/applicantInfo.fxml"));
	        	  
					SingleApplicantInfoController controller = new SingleApplicantInfoController(id);
			        // Set it in the FXMLLoader
			        loader.setController(controller);

					Parent applicantInfo =  loader.load();
			        border_pane1.setCenter(applicantInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
	}
}
