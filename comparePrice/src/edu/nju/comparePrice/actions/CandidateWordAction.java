package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.CandidateWord;
import edu.nju.comparePrice.models.SpecialWord;
import edu.nju.comparePrice.services.CommentService;

public class CandidateWordAction extends BaseAction{
	private static final long serialVersionUID = 6756350499319035598L;

	private ArrayList<SpecialWord> candidateWordList;
	
	private String candidateWord;
	private String brandId;
	
	private CommentService commentService;
	private BrandService brandService;
	
	@Override
	public String execute () {
		if (candidateWordList == null) {
			candidateWordList = commentService.getSpecialWordsList();
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
		commentService.addSpecialWord(specialWord);
		return SUCCESS;
	}

	public ArrayList<SpecialWord> getCandidateWordList() {
		return candidateWordList;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
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
		boolean isValid = true;
		if (isValid) {
			Brand brand = new Brand();
			brand.setId(brandId);
			return brand;
		} else {
			return null;
		}
	}
	
	
}
