package edu.nju.comparePrice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import edu.nju.comparePrice.models.CrawlerWebsite;
@Repository
public class CrawlerWebsiteDao {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	public ArrayList<CrawlerWebsite> getCrawlerWebSiteList(){
		final ArrayList<CrawlerWebsite> crawlerWebsiteList =new ArrayList<CrawlerWebsite>();
		
		String sql = "select * from crawler_website";
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            	CrawlerWebsite crawlerWebsite=new CrawlerWebsite();
            	crawlerWebsite.setId(rs.getInt("id"));
            	crawlerWebsite.setName(rs.getString("name"));
                crawlerWebsite.setLink(rs.getString("link"));
                
            	crawlerWebsiteList.add(crawlerWebsite);
            }
               });
		return  crawlerWebsiteList;
	
	}

	
	
	public boolean addCrawlerWebsite(String crawlerWebSite) {
		
		jdbcTemplate.update("INSERT INTO crawler_website VALUES(?,?, ?)", new Object[] {null,crawlerWebSite,null});
		
		return true;
	}
	public boolean removeCrawlerWebsite(int crawlerWebsiteId) {
		jdbcTemplate.update("DELETE FROM crawler_website WHERE id= ?", new Object[] {crawlerWebsiteId});
		
		return true;
	}

}
