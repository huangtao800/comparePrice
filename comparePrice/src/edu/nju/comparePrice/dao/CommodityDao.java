package edu.nju.comparePrice.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;








import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;

import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.models.CommodityCrawl;


@Repository
public class CommodityDao extends HibernateDao<Commodity, Long> {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Autowired
    private BrandDao brandDao;

	public ArrayList<Commodity> getForbiddenCommodities(){
		final ArrayList<Commodity> commodityList =new ArrayList<Commodity>();
		
		String sql = "select * from forbid_commodity";
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            	Commodity commodity=new Commodity();
            	commodity.setId(rs.getInt("cid"));
            	commodity.setName(rs.getString("name"));
                
                
            	commodityList.add(commodity);
            }
               });
		return  commodityList;
	
	}

	public List<Commodity> getToForbidCommodities(String commodityName){
		return queryCommoditiesByName(commodityName);
		
	}
	public boolean cancelForbid(int commodityId) {
		return removeForbidCommodity(commodityId);
	}

	public boolean forbid(int commodityId) {
		return addForbidCommodity(commodityId);
		
	}

	
	public List<Commodity> queryCommoditiesByName(String commodityName){
    final ArrayList<Commodity> commodityList =new ArrayList<Commodity>();
		
		String sql = "select * from commodity where name='"+commodityName+"'";
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            	Commodity commodity=new Commodity();
            	commodity.setId(rs.getInt("id"));
            	commodity.setLink(rs.getString("link"));
            	commodity.setName(rs.getString("name")); 
            	Integer bid=rs.getInt("bid");
                commodity.setBid(bid);
                commodity.setPrice(rs.getDouble("price"));
                commodity.setOnlineId(rs.getString("onlineid"));
                commodity.setUnit(rs.getInt("unit"));
                Brand brand=brandDao.queryBrandById(bid);
                commodity.setBrand(brand);
            	commodityList.add(commodity);
            }
               });
		return  commodityList;
	
	}
	public boolean addForbidCommodity(int commodityId) {
		Commodity commodity=queryCommodityByID(commodityId);
		jdbcTemplate.update("INSERT INTO forbid_commodity VALUES(?,?, ?)", new Object[] {null,commodity.getId(),commodity.getName()});
		
		return true;
	}
	public boolean removeForbidCommodity(int commodityId) {
		jdbcTemplate.update("DELETE FROM forbid_commodity WHERE cid= ?", new Object[] {commodityId});
		
		return true;
	}
	
	
	public Commodity queryCommodityByID(int commodityId) {
		
		 final Commodity commodity =new Commodity();
			
			String sql = "select * from commodity where id="+commodityId;
			
			jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
	            public void processRow(ResultSet rs) throws SQLException {    
	            	
	            	commodity.setId(rs.getInt("id"));
	            	commodity.setLink(rs.getString("link"));
	            	commodity.setName(rs.getString("name")); 
	            	Integer bid=rs.getInt("bid");
	                commodity.setBid(bid);
	                commodity.setPrice(rs.getDouble("price"));
	                commodity.setOnlineId(rs.getString("onlineid"));
	                commodity.setUnit(rs.getInt("unit"));
	                Brand brand=brandDao.queryBrandById(bid);
	                commodity.setBrand(brand);
	            	
	            }
	               });
			return  commodity;
	        
	  
				
		
	}
	
	public Commodity queryCommodityByOnlineID(String cOnlineId) {
		
		 final Commodity commodity =new Commodity();
			
			String sql = "select * from commodity where onlineid='"+cOnlineId+"'";
			
			jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
	            public void processRow(ResultSet rs) throws SQLException {    
	            	
	            	commodity.setId(rs.getInt("id"));
	            	commodity.setLink(rs.getString("link"));
	            	commodity.setName(rs.getString("name")); 
	            	Integer bid=rs.getInt("bid");
	                commodity.setBid(bid);
	                commodity.setPrice(rs.getDouble("price"));
	                commodity.setOnlineId(rs.getString("onlineid"));
	                commodity.setUnit(rs.getInt("unit"));
	                Brand brand=brandDao.queryBrandById(bid);
	                commodity.setBrand(brand);
	            	
	            }
	               });
			if(commodity.getId() == null)
				return null;
			return  commodity;
	        
	  
				
		
	}
	public boolean updateCommodityByCrawl(CommodityCrawl crawl,int commodityid) {
		
			jdbcTemplate.update("UPDATE commodity SET link=?, name=?,bid=?,price=?,onlineid=?,unit=? where id=?", new Object[] {crawl.getLink(),crawl.getName(),crawl.getBrandId(),crawl.getPrice(),crawl.getOnlineId(),crawl.getUnit(),commodityid});  
		
		 return true;
	}
	
	
	public boolean insertCommodity(CommodityCrawl crawl) {
		jdbcTemplate.update("INSERT INTO commodity VALUES(?,?,?,?,?,?,?)", new Object[] {null,crawl.getName(),crawl.getPrice(),crawl.getUnit(),crawl.getBrandId(),crawl.getLink(),crawl.getOnlineId()});  
		
		 return true;
	}
	/*public void testcase() {
		ArrayList<Commodity> forbiddenCommodities=DaoFacade.getInstance().getForbiddenCommodities();
		System.out.println("forbiddenCommodities");
		for(Commodity c:forbiddenCommodities) {
			System.out.print(c.getId()+"|");
		}
		ArrayList<Commodity> commodities=DaoFacade.getInstance().getToForbidCommodities("forbid");
		System.out.println("toforbidCommodities");
		for(Commodity c:commodities) {
			System.out.print(c.getId()+"|");
		}
		
		boolean isAdd=DaoFacade.getInstance().forbid(1);
		
		boolean isCancel=DaoFacade.getInstance().cancelForbid(2);
		
		
	}*/
	

}

