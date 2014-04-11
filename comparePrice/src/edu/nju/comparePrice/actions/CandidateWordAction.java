package edu.nju.comparePrice.actions;

import java.util.ArrayList;

import edu.nju.comparePrice.models.CandidateWord;
import edu.nju.comparePrice.models.SpecialWord;
import edu.nju.comparePrice.services.CommentService;

public class CandidateWordAction extends BaseAction{
	private static final long serialVersionUID = 6756350499319035598L;

	private ArrayList<SpecialWord> candidateWordList;
	
	private CommentService commentService;
	
	@Override
	public String execute () {
		if (candidateWordList == null) {
			candidateWordList = commentService.getSpecialWordsList();
		}
		return SUCCESS;
	}
	
	public String add() {
		return SUCCESS;
	}

	public ArrayList<SpecialWord> getCandidateWordList() {
		return candidateWordList;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
}
