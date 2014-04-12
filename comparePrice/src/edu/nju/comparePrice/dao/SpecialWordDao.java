package edu.nju.comparePrice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;

import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.SpecialWord;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.Commodity;


@Repository
public class SpecialWordDao extends HibernateDao<SpecialWord, Long> {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Autowired
    private BrandDao brandDao;
	
	public ArrayList<SpecialWord> getSpecialWords(){

	 	String sql = "select * from special_word";
		
	        final ArrayList<SpecialWord> wordList =new ArrayList<SpecialWord>();
			
			jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
	            public void processRow(ResultSet rs) throws SQLException {    
	            	SpecialWord specialWord=new SpecialWord();
	            	specialWord.setBid(rs.getInt("bid"));
	            	specialWord.setName(rs.getString("name"));
	            	wordList.add(specialWord);
	            }
	               });
			

		return wordList;
		
	}
	public List<SpecialWord> querySpecialWordByBrandId(int brandId){
	    final ArrayList<SpecialWord> specialWordList =new ArrayList<SpecialWord>();
			
			String sql = "select * from special_word where bid="+brandId;
			
			jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
	            public void processRow(ResultSet rs) throws SQLException {    
	            	SpecialWord specialWord=new SpecialWord();
	            	specialWord.setId(rs.getInt("id"));
	            	specialWord.setName(rs.getString("name")); 
	            	Integer bid=rs.getInt("bid");
	                specialWord.setBid(bid);
	               
	                Brand brand=brandDao.queryBrandById(bid);
	                specialWord.setBrand(brand);
	            	specialWordList.add(specialWord);
	            }
	               });
			return  specialWordList;
		
		}
	
	public boolean removeSpecialWord(SpecialWord cw) {
		jdbcTemplate.update("DELETE FROM special_word WHERE id= ?", new Object[] {cw.getId()});
		
		return true;
	}
	
	public boolean addSpecialWord(SpecialWord cw){
		
		jdbcTemplate.update("INSERT INTO special_word VALUES(?,?, ?)", new Object[] {null,cw.getBid(),cw.getName()});
		
		return true;
	}
	
	
}