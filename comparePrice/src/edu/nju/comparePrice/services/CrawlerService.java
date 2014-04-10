package edu.nju.comparePrice.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.comparePrice.dao.DaoFacade;
import edu.nju.comparePrice.models.CommodityCrawl;


public class CrawlerService {
	@Autowired 
	private DaoFacade daoFacade;
	
	private Context ctx; 
	private DataSource ds;
	private Connection con = null;

	public void updateCommodity() {
		System.out.println("---------------------");
		ArrayList<CommodityCrawl> commodityList = new ArrayList<CommodityCrawl>();
		float price;
		String id;
		String cname;
		String brand;
		String link;
		int unit;
		int count = 0;
		int tmp = 0;
		try {
			ctx=new InitialContext();
			ds= (DataSource) ctx.lookup("java:comp/env/jdbc/crawler") ;	
			Connection con;
			con = ds.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM commodity;");  
			while(rs.next()){
				tmp++;
				if(tmp<12670)
					continue;
				price = rs.getFloat("price");
				id = rs.getString("id");
				cname = rs.getString("name");
				link = rs.getString("link");
				brand = rs.getString("brand");
				unit = rs.getInt("unit");
				String brandName = brand.replaceAll("'", "");
				String name = cname.replaceAll("'", "");
				CommodityCrawl commodity = new CommodityCrawl(name,price,unit,brandName,link,id);
				commodityList.add(commodity);
				if(commodityList.size() == 10){
					daoFacade.updateCommodity(commodityList);
					commodityList =  new ArrayList<CommodityCrawl>();
					count ++;
				}
				
				daoFacade.updateCommodity(commodityList);
				System.out.println(commodity.getOnlineId()+"/"+commodity.getBrandName()+"/"+commodity.getName());
				System.out.println(count+"/"+commodityList.size());
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
