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

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.apache.xpath.internal.operations.And;

import edu.nju.comparePrice.models.BaseUser;
import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.SpecialWord;
import edu.nju.comparePrice.models.User;


@Repository
public class UserDao extends HibernateDao<User, Long> {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
    
	
	public boolean login(String username,String password) {
		boolean isExist=false;
        String sql = "select * from user where name = '"+username+"' and password ='"+password+"'";
        final ArrayList<User> userList =new ArrayList<User>();
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            	User user=new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	userList.add(user);
            }
               });
		
		if(userList!=null && !userList.isEmpty()) {
			isExist=true;
		}
		return  isExist;
		
	}
	public void addWaterNavy(int userID) {
		jdbcTemplate.update("INSERT INTO navy VALUES(?, ?, ?)", new Object[] {null,userID, 1});  
		
	}
	public BaseUser findBaseUser(int id) {
		BaseUser baseUser=new BaseUser();
		User user=this.find(id);
		baseUser.setId(user.getId());
		baseUser.setPassword(user.getPassword());
		return baseUser;
		
	}

		public User find(int userId) {
			final User user=new User();
			String sql = "select * from user where id="+userId;
			
			jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
	            public void processRow(ResultSet rs) throws SQLException {    
	           
	            	user.setId(rs.getInt("id"));
	            	System.out.println(rs.getInt("id"));
	            	System.out.println(user.getId());
	            	user.setName(rs.getString("name"));
	            	System.out.println(rs.getString("name"));
	                user.setPassword(rs.getString("password"));   
	                user.setSensitivecount(rs.getInt("sensitivecount"));
	            
	            }
	               });
			System.out.println(user.getId()+user.getName());
			return  user;
			
		}
		public int save(String username, String password) {
			jdbcTemplate.update("INSERT INTO user VALUES(?, ?, ?, ?)", new Object[] {null,username, password,null});  
			int id=queryUserByName(username).getId();
			return id;
		}
			
		
		public User queryUserByName(String userName) {
			final User user =new User();
			String sql = "select * from user where name = '"+userName+"'";
			
			jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
	            public void processRow(ResultSet rs) throws SQLException {    
	            	
	            	user.setId(rs.getInt("id"));
	            }
	               });
			return user;
		}
		
	
		
	

		public int getSensitiveCountByUseID(int userId) {
			User user=this.find(userId);
			int scount=user.getSensitivecount();
			return scount;
		
			
		}

		public void addSentsitiveCount(int userID,int increment) {
			int originSCount=this.getSensitiveCountByUseID(userID);
			int currentSCount=originSCount+increment;
			jdbcTemplate.update("UPDATE user SET sensitivecount=? where id="+userID, new Object[] {currentSCount});  
			
			
		}
		
	/*	public void testcase() {
			
			boolean isExist=DaoFacade.getInstance().login("use1","123");
			
			System.out.println(isExist);
			addWaterNavy(3);
			User user=DaoFacade.getInstance().find(1);
			System.out.println(user.getId()+user.getName());
			int save=DaoFacade.getInstance().save("newuser","123");
			System.out.println(save);
			ArrayList<SpecialWord> specialWords=DaoFacade.getInstance().getSpecialWords();
			for(SpecialWord s:specialWords) {
				System.out.print(s.getName()+"|");
			}
			int count=DaoFacade.getInstance().getSensitiveCountByUseID(1);
			System.out.println(count);
			addSentsitiveCount(2, 4);
		}
	*/
	
	
}

