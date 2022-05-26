package controllers;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.ApplicantModel;

public class MyAccountController {
	@FXML
    private static Text emailValue;
    @FXML
    private VBox mainVBox;
	@FXML
	private static Text firstNameValue;
	
	@FXML
    public void initialize(){  
    	 try {
             System.out.println("13123");
             HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8000/api/applicant/627e335f4bc99c47410cf8c4").asJson();
             System.out.println(apiResponse.getBody().toString());
             ApplicantModel applicantModel = new Gson().fromJson(apiResponse.getBody().toString(), ApplicantModel.class);
//             System.out.println(applicantModel.getFirstName());

System.out.println(applicantModel.getEmail());
setCurrentInfo(applicantModel);
         } 
         catch (UnirestException e) {
//         	
             e.printStackTrace();
         }
    }

    public void setCurrentInfo(ApplicantModel applicantModel) {
//    	emailValue.initOwner(mainVBox.getScene().getWindow());
    	emailValue.setText(applicantModel.getEmail());
    }
	
	
}
