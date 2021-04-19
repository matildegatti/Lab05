package it.polito.tdp.anagrammi.model;

import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammiDAO;

public class Model {
	
	Anagrammi anagrammi=new Anagrammi();
	AnagrammiDAO anagrammidao=new AnagrammiDAO();
	
	public boolean isCorrect(String parola) {
		return this.anagrammidao.isCorrect(parola);
	}

	public List<String> anagrammi(String parola) {
		return this.anagrammi.anagrammi(parola);
	}
	
	
}
