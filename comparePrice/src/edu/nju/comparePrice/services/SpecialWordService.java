package edu.nju.comparePrice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.SpecialWord;

public class SpecialWordService {
	@Autowired 
	private DaoFacade daoFacade;
	
	public ArrayList<SpecialWord> getSpecialWordsList(){
		ArrayList<SpecialWord> specialWords = daoFacade.getSpecialWords();
		return specialWords;
		
	}
	
	public void addSpecialWord(SpecialWord specialWord){
		daoFacade.addSpecialWord(specialWord);
	}
	
	public void deleteSpecialWord(int specialWordId){
		daoFacade.removeSpecialWord(specialWordId);
	}

}
