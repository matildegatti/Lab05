package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagrammi {

	public List<String> anagrammi(String parola){
		List<String> risultato=new ArrayList<String>();
		permuta("", parola,0,risultato);
		return risultato;
	}
	
	private void permuta(String parziale, String lettere, int livello, List<String> risultato) {
	
		if(lettere.length()==0) {
			risultato.add(parziale);
		}
		else {
			for(int i=0; i<lettere.length(); i++) {
				Character tentativo=lettere.charAt(i);
				
				String nuovaparziale=parziale+tentativo;
				String nuovelettere = lettere.substring(0, i)+lettere.substring(i+1);
				
				permuta(nuovaparziale,nuovelettere,livello+1, risultato);
			}
		}
		
	}
	
}
