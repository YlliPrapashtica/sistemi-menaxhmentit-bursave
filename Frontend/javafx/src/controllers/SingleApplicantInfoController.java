package controllers;

import java.awt.Desktop;
import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.ApplicantModel;

public class SingleApplicantInfoController {
	@FXML
    private  Text firstNameValue;
	@FXML
    private  Text lastNameValue;
	@FXML
    private  Text personalNumberValue;
	@FXML
    private  Text studentCardNumberValue;
	@FXML
    private  Text emailValue;
	@FXML
    private  Text phoneValue;
	@FXML
    private  Text universityValue;
	@FXML
    private  Text facultyValue;
	@FXML
    private  Text scholarshipValue;
	@FXML
    private  Button cvValue;
	@FXML
    private  Button extraDocumentsValue; 
	@FXML
    private VBox content;
	
	public String id;

    private Desktop desktop = Desktop.getDesktop();
    
	public SingleApplicantInfoController (String id) {
	this.id = id;	

	}
	
	@FXML
    public void initialize(){  
    	 try { 
             HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8000/api/applicant/"+this.id).asJson(); 
             
             ApplicantModel applicantModel = new Gson().fromJson(apiResponse.getBody().toString(), ApplicantModel.class); 
             setCurrentInfo(applicantModel);

             cvValue.setOnAction(
                     (EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
                         @Override
                         public void handle(final ActionEvent e) {
                        	 openFile(new File(cvValue.getText().toString()));
                         }
                     });
             extraDocumentsValue.setOnAction(
                     (EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
                         @Override
                         public void handle(final ActionEvent e) {
                        	 openFile(new File(extraDocumentsValue.getText().toString()));
                         }
                     });
             
             
             
         } 
         catch (UnirestException e) { 
             e.printStackTrace();
         }
    } 
	
	   private void openFile(File file) {
	        try {
	            desktop.open(file);
	        } catch (IOException ex) {
	           
	        }
	    }
	    
	@FXML
    public void setCurrentInfo(ApplicantModel applicantModel) {  
firstNameValue.setText(applicantModel.getFirstName());
lastNameValue.setText(applicantModel.getLastName());
personalNumberValue.setText(applicantModel.getPersonalNumber());
studentCardNumberValue.setText(applicantModel.getStudentCardNumber());
emailValue.setText(applicantModel.getEmail());
phoneValue.setText(applicantModel.getPhone());
universityValue.setText(applicantModel.getUniversity());
facultyValue.setText(applicantModel.getFaculty());
scholarshipValue.setText(applicantModel.getScholarship());
cvValue.setText(applicantModel.getCv());
extraDocumentsValue.setText(applicantModel.getExtraDocuments());
content.getChildren().add(new Text("ywywywy")); 

    }
	
	
}
