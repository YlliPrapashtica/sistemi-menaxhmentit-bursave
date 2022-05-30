package controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.ApplicantModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ViewAllController  {

    @FXML
    private BorderPane border_pane1;
    
    @FXML
    private VBox content;
	@FXML
    private HBox singleUserHBox;
 

   
    
	@FXML
    public void initialize(){  
    	 try { 
             HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8000/api/applicant").asJson();  
             ApplicantModel[] applicantModel = new Gson().fromJson(apiResponse.getBody().toString(), ApplicantModel[].class);   
             List<ApplicantModel> applicantModelList = Arrays.asList(applicantModel);  
             addNode(applicantModelList);
             
         } 
         catch (UnirestException e) { 
             e.printStackTrace();
         }
    } 
	  private void addNode(List<ApplicantModel> applicantModel) {
 
	        try {

	        	for(int i = 0; i < applicantModel.size(); i++)
	        	{ 

		        	  FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/SingleApplicantBox.fxml"));
	        		Node node  = loader.load();  
	        		content.getChildren().add(node);
	           
	            SingleApplicantBoxController controller = (SingleApplicantBoxController)loader.getController(); 
	            
	            controller.setFullName(applicantModel.get(i).getFullname());
	            controller.setOnClickEvent(border_pane1,applicantModel.get(i).getID());
	            
	        	}  
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

}
