package edu.nju.comparePrice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;

import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.models.CommodityCrawl;
import edu.nju.comparePrice.models.Synonym;


@Repository
public class CommodityDao extends HibernateDao<Commodity, Long> {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Autowired
    private BrandDao brandDao;
	@Autowired
    private SynonymDao synonymDao;

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
	
	public Commodity getForbiddenCommodityByID(int cid){
		final Commodity commodity =new Commodity();
		
		String sql = "select * from forbid_commodity where cid="+cid;
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            
            	commodity.setId(rs.getInt("cid"));
            	commodity.setName(rs.getString("name"));
                
                
            	
            }
               });
		return  commodity;
	
	}

	public List<Commodity> getToForbidCommodities(String commodityName){
		ArrayList<Commodity> toForbidCommodityList=(ArrayList<Commodity>) queryCommoditiesByName(commodityName);
//		ArrayList<Commodity> toForbidCommodityList=new ArrayList<Commodity>();
		
//		int size=toForbidCommodityList.size();
//		System.out.println("size:"+size);
//		ArrayList<Integer> indexToRemove=new ArrayList<Integer>();
//		for(int i=0;i<size;i++){
//			Commodity forbid=getForbiddenCommodityByID(toForbidCommodityList.get(i).getId());
//			System.out.println(forbid);
//			System.out.println(forbid.getId());
//			if(forbid.getId()!=null){
//				indexToRemove.add(i);
//			}
//		}
//		
//		System.out.println(indexToRemove);
//		for(int j=0;j<indexToRemove.size();j++){
//			System.out.println("qqq "+j);
//			toForbidCommodityList.remove(indexToRemove.get(j));
//		}
//		System.out.println("sizesize:"+toForbidCommodityList.size());
		return toForbidCommodityList;
		
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
		Commodity c=getForbiddenCommodityByID(commodityId);
		if(c.getId()!=null)
			return true;
		
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
	
	public ArrayList<Commodity> findCommodity(List<Synonym> keywords){
		ArrayList<String> queryList=new ArrayList<String>();
		for(int i=0;i<Math.min(keywords.size(),2);i++) {
			ArrayList<Synonym> synonymList=new ArrayList<Synonym>();
			synonymList.add(keywords.get(i));
			System.out.println("index"+i+keywords.get(i));
			if(keywords.get(i).getFlag()!=null){
		synonymList.addAll(synonymDao.getSynonymByFlag(keywords.get(i).getFlag()));
			}
		StringBuilder sBuilder=new StringBuilder();
	
		for(Synonym temp:synonymList) {
		sBuilder.append(" OR name like '%"+temp.getName()+"%'");
		}
        String query=new String();
        query=sBuilder.substring(4).toString();
        queryList.add(query);
		}
	    
		final ArrayList<Commodity> commodityList =new ArrayList<Commodity>();
		String sql=new String();
        if(keywords.size()==1){
        	sql = "select * from commodity where ("+queryList.get(0)+ ")" ;
        }
		
		else{
			sql = "select * from commodity where ("+queryList.get(0)+ ") AND ("+queryList.get(1)+")";
		}
        final Set<Integer> fobbidens = getFobbidens();
        System.out.println(fobbidens);
        jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
		            public void processRow(ResultSet rs) throws SQLException {    
		            	Commodity commodity=new Commodity();
		            	if(fobbidens.contains(rs.getInt("id"))) {
		            		return;
		            	}
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
		
		if(commodityList.size()==0){
			String sql2=new String();
	        if(keywords.size()==1){
	        	sql2 = "select * from commodity where ("+queryList.get(0)+ ")" ;
	        }
			
			else{
				sql2 = "select * from commodity where ("+queryList.get(0)+ ") OR ("+queryList.get(1)+")";
			}
			jdbcTemplate.query(sql2, new RowCallbackHandler() { //editing    
			            public void processRow(ResultSet rs) throws SQLException {    
			            	Commodity commodity=new Commodity();
			            	if(fobbidens.contains(rs.getInt("id"))) {
			            		return;
			            	}
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
			
			
		}
		return  commodityList;




		}
	
	private Set<Integer> getFobbidens() {
		Set<Integer> fobbidens = new HashSet<Integer>();
		for(Commodity c : getForbiddenCommodities()) {
			fobbidens.add(c.getId());
		}
		return fobbidens;
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



