package edu.nju.comparePrice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;

import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.Brand;

@Repository
public class BrandDao extends HibernateDao<Brand, Long> {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public ArrayList<Brand> getBrandList(){
		
	final ArrayList<Brand> brandList =new ArrayList<Brand>();
		String sql = "select * from brand";
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            	Brand brand=new Brand();
            	brand.setId(rs.getInt("id"));
            	brand.setName(rs.getString("name"));
            	brand.setWeight(rs.getInt("weight"));
                brand.setFlag(rs.getBoolean("flag"));
            	brandList.add(brand);
            }
               });
		return  brandList;
	}
	public  Brand queryBrandById(int brandId){
		
		 final Brand brand =new Brand();
			
			String sql = "select * from brand where id="+brandId;
			
			jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
	            public void processRow(ResultSet rs) throws SQLException {    
	            	brand.setId(rs.getInt("id"));
	            	brand.setName(rs.getString("name"));
	            	brand.setWeight(rs.getInt("weight"));
	                brand.setFlag(rs.getBoolean("flag"));
	            	
	            	
	            }
	               });
			return  brand;
	        
	  
				
				
		}

	public boolean saveBrand(int brandId,int brandWeight) {
		jdbcTemplate.update("INSERT INTO brand VALUES(?, ?, ?, ?)", new Object[] {brandId, null,null, brandWeight});  
		return true;
	}

	/*public void testcase() {
		
		{
		ArrayList<Brand> brandList=DaoFacade.getInstance().getBrandList();
		for(Brand brand:brandList) {
			System.out.print(brand.getName()+"|");
		}
		
		DaoFacade.getInstance().saveBrand(1, 2);
		}
		
	}*/
	
}
