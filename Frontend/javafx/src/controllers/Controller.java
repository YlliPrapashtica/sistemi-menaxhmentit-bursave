package controllers;


import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable {

    @FXML
    private BorderPane border_pane;

    @Override
    public void initialize(URL url, ResourceBundle rb){
    	
    }


    public void show_ViewAllApplicants(javafx.scene.input.MouseEvent event) throws IOException   {
        Parent ViewAllApplicants  = FXMLLoader.load(getClass().getResource("/views/ViewAllApplicants.fxml"));
	        border_pane.setCenter(ViewAllApplicants);


    }

    public void show_myAccount(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent myAccount = FXMLLoader.load(java.util.Objects.requireNonNull(getClass().getResource("/views/myAccount.fxml")));
        border_pane.setCenter(myAccount);
    }

    public void show_applyform(MouseEvent mouseEvent2) throws IOException {
        Parent Apply = FXMLLoader.load(java.util.Objects.requireNonNull(getClass().getResource("/views/Apply.fxml")));
        border_pane.setCenter(Apply);
    }


        public void show_chat(javafx.scene.input.MouseEvent event) {
        //Parent chati = FXMLLoader.load(java.util.Objects.requireNonNull(getClass().getResource("../chat/src/client/Login.java")));
        //border_pane.setCenter(chati);
//            try {
//                java.awt.Desktop.getDesktop().open(new java.io.File("../chat/src/client/Login.java"));
//            } catch(IOException ex) {
//                System.out.println(ex.getMessage());
//            }
        	
//        	try { 
//        	    Desktop.getDesktop().open(new File("C:\\Users\\yllip\\Desktop\\Formify\\sistemi-menaxhmentit-bursave\\chat\\src\\client\\jarfile.jar"));     
//        	} catch(IOException ex) {
//        	    System.out.println(ex.getMessage());
//        	}
        	try {
				Process process = Runtime.getRuntime().exec("java -jar C:/Users/yllip/Desktop/Formify/sistemi-menaxhmentit-bursave/chat/src/client/jarfile.jar");
				printResults(process);
				System.out.println("123123");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    }
        
        public static void printResults(Process process) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
}
