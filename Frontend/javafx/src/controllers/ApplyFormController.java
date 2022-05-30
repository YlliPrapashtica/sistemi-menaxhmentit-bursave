package controllers;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApplyFormController implements Initializable {

    @FXML
    private VBox border_pane;
	@FXML
    private  TextField firstNameValue;
	@FXML
    private  TextField lastNameValue;
	@FXML
    private  TextField personalNumberValue;
	@FXML
    private  TextField studentCardNumberValue;
	@FXML
    private  TextField emailValue;
	@FXML
    private  TextField phoneValue;
	@FXML
    private  TextField facultyValue;
	@FXML
    private  Button cvValue;
	@FXML
    private  Button extraDocumentsValue; 
	@FXML
    private  Button submit; 
	@FXML
    private  VBox content;
    
    File extraDocument= new File(""), cv = new File("");

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
    	FileChooser fileChooser = new FileChooser();
    	Stage  window = new Stage();
    	

    	checkFields();    	
    	cvValue.setOnAction(
            (EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    cv = fileChooser.showOpenDialog(window);
                    if (extraDocument != null) {
                    	System.out.println(extraDocument);
                    	checkFields();
                    }
                }
            });
//    	cvValue.setOnAction(e->  
//        {  
//            FileChooser file = new FileChooser();  
//            file.setTitle("Open File");  
//            file.showOpenDialog(primaryStage);  
//        });  

    	extraDocumentsValue.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    extraDocument = fileChooser.showOpenDialog(window);
                    if (extraDocument != null) {
                    	System.out.println(extraDocument);checkFields();
                    }
                }
            });
    	submit.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                	handleSumbit(cv,extraDocument);
                }
            });
    	
    	firstNameValue.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost

            	checkFields();
                }
            });
    	lastNameValue.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost

            	checkFields();
                }
            });
    	
    	personalNumberValue.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                  checkFields();
                    
                }
            });
    	
    	studentCardNumberValue.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost

            	checkFields();
                }
            });  
    	
    	
    	emailValue.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost

            	checkFields();
                }
            });   
    	
    	
    	phoneValue.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                   
                    	checkFields();
                    
                }
            });  
    	
    	
    	facultyValue.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                    	checkFields();
                    
                }
            });
    	

    }
    
    public void handleSumbit(File cv, File extraDocuments){ 
    	Map<String, Object> fields = new HashMap<>();
    	 
        fields.put("first_name", firstNameValue.getText());
        fields.put("last_name", lastNameValue.getText());
        fields.put("personal_number", personalNumberValue.getText());
        fields.put("student_card_number", studentCardNumberValue.getText());
        fields.put("email",emailValue.getText());
        fields.put("phone", phoneValue.getText());
        fields.put("faculty",facultyValue.getText());
        fields.put("university","627cccb2e8032cfc6dbc1767");
        fields.put("scholarship","627cd467c76e47d75535e5a8"); 
        fields.put("cv", cv);
        fields.put("extra_documents", extraDocuments); 
    	 HttpResponse<JsonNode> jsonResponse;
		try {
			jsonResponse = Unirest.post(
				      "http://localhost:8000/api/applicant/").fields(fields)
				      .asJson();
	    	 System.out.println(jsonResponse.getBody().toString());
	    	 System.out.println(jsonResponse.getStatus());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()); 
		}
    }

 
@FXML
public boolean checkFields() {
boolean canSubmit = false;
	
	if(firstNameValue.getText().toString().length() > 0 && 
			lastNameValue.getText().toString().length() > 0 && 			personalNumberValue.getText().toString().length() > 0 && 			studentCardNumberValue.getText().toString().length() > 0 &&
			emailValue.getText().toString().length() > 0 &&
			phoneValue.getText().toString().length() > 0 && 
			facultyValue.getText().toString().length() > 0 &&
			cv.getPath().length() > 5 && extraDocument.getPath().length() > 5 ) canSubmit = true;


	submit.setDisable(!canSubmit);
	
   
	
	return false;
}


}
