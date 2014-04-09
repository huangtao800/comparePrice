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
		double price;
		String id;
		String name;
		String brand;
		String link;
		int count = 0;
		try {
			ctx=new InitialContext();
			ds= (DataSource) ctx.lookup("java:comp/env/jdbc/crawler") ;	
			Connection con;
			con = ds.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM commodity;");  
			while(rs.next()){
				price = rs.getDouble("price");
				id = rs.getString("id");
				name = rs.getString("name");
				link = rs.getString("link");
				brand = rs.getString("brand");
				CommodityCrawl commodity = new CommodityCrawl(name,price,0,brand,link,id);
				commodityList.add(commodity);
				if(commodityList.size() == 100){
					daoFacade.updateCommodity(commodityList);
					commodityList =  new ArrayList<CommodityCrawl>();
					count ++;
				}
				daoFacade.updateCommodity(commodityList);
				System.out.println(commodity.getOnlineId()+"/"+commodity.getBrandName()+"/"+commodity.getName());
				System.out.println(count);
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
