package edu.nju.comparePrice.services;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.DaoFacade;

public class BrandService {
	@Autowired 
	private DaoFacade daoFacade;
	
	public boolean contains(int id){
		return true;
	}

}
