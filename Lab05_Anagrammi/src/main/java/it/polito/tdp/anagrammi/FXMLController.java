package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

	private Model model;

    @FXML
    void doAnagramma(ActionEvent event) {
    	String parola=this.txtParola.getText();

    	txtCorretti.clear();
    	txtErrati.clear();
    	
    	if(parola.length()==0) {
    		txtErrati.setText("Errore, inserire una parola");
    		return;
    	}
    	
    	if(!parola.matches("[a-zA-Z]+")) {
    		txtErrati.setText("Errore, inserire solo lettore");
    		return;
    	}
    	
    	String nuovaParola=parola.toLowerCase();
    	
    	if(!model.isCorrect(nuovaParola)) {
    		txtErrati.setText("Errore, inserire una parola presente nel dizionario italiano");
    		return;
    	}
    	
    	List<String> anagrammi=this.model.anagrammi(nuovaParola);
    	
    	for(String s:anagrammi) {
    		if(this.model.isCorrect(s)) {
    			this.txtCorretti.appendText(s+"\n");
    		}
    		else {
    			this.txtErrati.appendText(s+"\n");
    		}
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
	}
}
