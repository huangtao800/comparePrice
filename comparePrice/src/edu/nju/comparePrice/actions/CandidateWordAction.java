package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.SpecialWord;
import edu.nju.comparePrice.services.BrandService;
import edu.nju.comparePrice.services.SpecialWordService;

public class CandidateWordAction extends BaseAction{
	private static final long serialVersionUID = 6756350499319035598L;

	private ArrayList<SpecialWord> candidateWordList;
	
	private String candidateWord;
	private String brandId;
	
	private SpecialWordService specialWordService;
	private BrandService brandService;
	
	@Override
	public String execute () {
		if (candidateWordList == null) {
			candidateWordList = specialWordService.getSpecialWordsList();
		}
		return SUCCESS;
	}
	
	public String add() {
		Brand brand = fetchBrand(brandId);
		if (brand == null) {
			return ERROR;
		}
		
		SpecialWord specialWord = new SpecialWord();
		specialWord.setBid(brand.getId());
		specialWord.setBrand(brand);
		specialWord.setName(candidateWord);
		specialWordService.addSpecialWord(specialWord);
		return SUCCESS;
	}
	
	public String delete() {
		String candidateWordIdString = request.getParameter("candidateWordId");
		int candidateWordId = Integer.parseInt(candidateWordIdString);
		specialWordService.deleteSpecialWord(candidateWordId);
		return SUCCESS;
	}

	public ArrayList<SpecialWord> getCandidateWordList() {
		return candidateWordList;
	}

	public void setSpecialWordService(SpecialWordService specialWordService) {
		this.specialWordService = specialWordService;
	}

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	public void setCandidateWord(String candidateWord) {
		this.candidateWord = candidateWord;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	
	private Brand fetchBrand (String brandIdString) {
		int brandId = 0;
		try{
			brandId = Integer.parseInt(brandIdString);
		} catch (NumberFormatException e) {
			return null;
		}
		
		boolean isValid = brandService.contains(brandId);
		if (isValid) {
			Brand brand = new Brand();
			brand.setId(brandId);
			return brand;
		} else {
			return null;
		}
	}
}
