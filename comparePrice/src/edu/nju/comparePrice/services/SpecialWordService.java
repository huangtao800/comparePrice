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
		//桩
		Brand brand2 = new Brand();
		brand2.setName("amazon");
		ArrayList<SpecialWord> specialWords = new ArrayList<>();
		SpecialWord s1 = new SpecialWord(brand2,"sb");
		s1.setId(1);
		SpecialWord s2 = new SpecialWord(brand2,"假冒");
		s2.setId(2);
		specialWords.add(s1);
		specialWords.add(s2);
		return specialWords;
		
	}
	
	public void addSpecialWord(SpecialWord specialWord){
		System.out.println("add candidate word");
	}
	
	public void deleteSpecialWord(int specialWordId){
		System.out.println("delete candidate word " + specialWordId);
	}

}
