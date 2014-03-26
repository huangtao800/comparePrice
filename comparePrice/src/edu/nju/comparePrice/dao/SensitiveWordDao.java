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
import edu.nju.comparePrice.models.SensitiveWord;
import edu.nju.comparePrice.models.User;
@Repository
public class SensitiveWordDao extends HibernateDao<SensitiveWord, Long> {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	
	public boolean addSensitiveWord(String sensitiveWord) {
		jdbcTemplate.update("INSERT INTO sensitive_word VALUES(?, ?)", new Object[] {null,sensitiveWord});  
		return true;
		
	}

	public ArrayList<SensitiveWord> getSensiviveWordList(){
		
		return getSensitiveWords();
	}

	public boolean removeSensitiveWord(int sensitiveWordId) {
		jdbcTemplate.update("DELETE FROM sensitive_word WHERE id=?", new Object[] {sensitiveWordId});  
		return true;
		
	}
	
	public ArrayList<SensitiveWord> getSensitiveWords(){
		
		
		final ArrayList<SensitiveWord> sensitivewordList =new ArrayList<SensitiveWord>();
		String sql = "select * from sensitive_word";
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            	SensitiveWord sensitiveword=new SensitiveWord();
            	sensitiveword.setId(rs.getInt("id"));
            	sensitiveword.setName(rs.getString("name"));
            
            
            	sensitivewordList.add(sensitiveword);
            }
               });
		return  sensitivewordList;
	}
	
	public void testcase() {
		ArrayList<SensitiveWord> sensitiveWords=DaoFacade.getInstance().getSensitiveWords();
		for(SensitiveWord s:sensitiveWords) {
			System.out.print(s.getName()+"|");
		}
		
		boolean isAdd=DaoFacade.getInstance().addSensitiveWord("sensitive");
		boolean isRemove=DaoFacade.getInstance().removeSensitiveWord(1);
		
		}

}
