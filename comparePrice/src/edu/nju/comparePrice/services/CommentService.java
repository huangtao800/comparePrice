package edu.nju.comparePrice.services;

import java.util.ArrayList;

public class CommentService {

	private static CommentService commentService;

	private CommentService() {

	}

	public static CommentService getInstance() {
		if (commentService == null) {
			commentService = new CommentService();
		}
		return commentService;
	}

	public void postComment(int userID, String comment) {

	}

	public void checkComment(int userID, String comment) {

	}

	public void checkWaterNavy(int userID, ArrayList<String> commentList) {

	}
}
