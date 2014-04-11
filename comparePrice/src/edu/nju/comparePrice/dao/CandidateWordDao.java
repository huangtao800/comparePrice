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
import edu.nju.comparePrice.models.CandidateWord;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.Commodity;


@Repository
public class CandidateWordDao extends HibernateDao<CandidateWord, Long> {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Autowired
    private BrandDao brandDao;

	public List<CandidateWord> queryCommoditiesByName(int brandId){
	    final ArrayList<CandidateWord> candidateWordList =new ArrayList<CandidateWord>();
			
			String sql = "select * from candidate_word where bid="+brandId;
			
			jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
	            public void processRow(ResultSet rs) throws SQLException {    
	            	CandidateWord candidateWord=new CandidateWord();
	            	candidateWord.setId(rs.getInt("id"));
	            	candidateWord.setName(rs.getString("name")); 
	            	Integer bid=rs.getInt("bid");
	                candidateWord.setBid(bid);
	               
	                Brand brand=brandDao.queryBrandById(bid);
	                candidateWord.setBrand(brand);
	            	candidateWordList.add(candidateWord);
	            }
	               });
			return  candidateWordList;
		
		}
	
	public boolean removeCandidateWord(CandidateWord cw) {
		jdbcTemplate.update("DELETE FROM candidate_word WHERE id= ?", new Object[] {cw.getId()});
		
		return true;
	}
	
	public boolean addCandidateWord(CandidateWord cw){
		
		jdbcTemplate.update("INSERT INTO candidate_word VALUES(?,?, ?)", new Object[] {null,cw.getBid(),cw.getName()});
		
		return true;
	}
	
	
}