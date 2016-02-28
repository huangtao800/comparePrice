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
import edu.nju.comparePrice.models.Synonym;
import edu.nju.comparePrice.models.Synonym;
@Repository
public class SynonymDao extends HibernateDao<Synonym, Long> {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;



	public ArrayList<Synonym> getSynonymByFlag(int flag){
	    final ArrayList<Synonym> synonymList =new ArrayList<Synonym>();
			
			String sql = "select * from synonym where flag="+flag;
			
			jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
	            public void processRow(ResultSet rs) throws SQLException {    
	            	Synonym synonym=new Synonym();
	            	synonym.setId(rs.getInt("id"));
	            
	            	synonym.setName(rs.getString("name")); 
	            	synonym.setFlag(rs.getInt("flag"));
	            	synonymList.add(synonym);
	            }
	               });
			return  synonymList;
		
		}
		public boolean addSynonym(Synonym synonym) {
		
			jdbcTemplate.update("INSERT INTO synonym VALUES(?,?, ?)", new Object[] {null,synonym.getFlag(),synonym.getName()});
			
			return true;
		}
	
		
		public Synonym getSynonymByName(String name) {
			
			 final Synonym synonym =new Synonym();
				
				String sql = "select * from synonym where name='"+name+"'";
				
				jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
		            public void processRow(ResultSet rs) throws SQLException {    
		            	
		            	synonym.setId(rs.getInt("id"));
		     
			            
		            	synonym.setName(rs.getString("name")); 
		            	synonym.setFlag(rs.getInt("flag"));
		            	
		            }
		               });
				return  synonym;
		        
		  
					
			
		}
		
		public int getCurrentMaxFlag(){
			 final Synonym synonym =new Synonym();
				
				String sql = "select * from synonym where flag in (select max(flag) from synonym)";
				
				jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
		            public void processRow(ResultSet rs) throws SQLException {    
		            	
		            	synonym.setId(rs.getInt("id"));
		            	
		            	synonym.setName(rs.getString("name")); 
		            	synonym.setFlag(rs.getInt("flag"));
		            	
		            }
		               });
				return  synonym.getFlag();
		        
		}

}
