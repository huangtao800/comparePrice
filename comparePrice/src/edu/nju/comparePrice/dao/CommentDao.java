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

import com.sun.xml.internal.ws.util.xml.CDATA;

import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.models.User;


@Repository
public class CommentDao extends HibernateDao<Comment, Long> {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CommodityDao commodityDao;

	public void setSensitiveFlag(int commentID, boolean flag) {
		jdbcTemplate.update("UPDATE comment SET state=?  where id=?", new Object[] {flag,commentID});  
	}
	
	

	public void setSpecialFlag(int commentID,boolean flag) {
		jdbcTemplate.update("UPDATE comment SET specialstate=?  where id=?", new Object[] {flag,commentID});  
	}
	
	public ArrayList<Comment> getComments(int cid){
				
		
		final ArrayList<Comment> commentList =new ArrayList<Comment>();
		String sql = "select * from comment where cid ="+cid;	
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            	Comment comment=new Comment();
            	comment.setId(rs.getInt("id"));
            	comment.setDetails(rs.getString("details"));
            	
            	comment.setSpecialstate(rs.getBoolean("specialstate"));
            	comment.setState(rs.getBoolean("state"));
            	Integer userId=rs.getInt("uid");
            			User user=userDao.find(userId);
            	comment.setUser(user);
            	comment.setUid(userId);
            	Integer commodityId=rs.getInt("cid");
            	comment.setCid(commodityId);
            	Commodity commodity=commodityDao.queryCommodityByID(commodityId);
            	comment.setCommodity(commodity);
            	
            	//condition added !!!!!!!!!!!!!!!!
            	if(!comment.getState()&&!comment.getSpecialstate()){
                	commentList.add(comment);
            	}
            }
               });
		return  commentList;
	
	}

	public boolean addComment(Comment c) {
		jdbcTemplate.update("INSERT INTO comment VALUES(?,?,?,?,?,?)", new Object[] {null,c.getUid(),c.getDetails(),c.getCid(),c.getState(),c.getSpecialstate()});
		return true;		
	}
	
	public Comment queryCommentById(int commentId) {
		 final Comment comment =new Comment();
			
			String sql = "select * from comment where id="+commentId;
			
			jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
	            public void processRow(ResultSet rs) throws SQLException {    
	            	comment.setId(rs.getInt("id"));
	            	comment.setDetails(rs.getString("details"));
	            	
	            	comment.setSpecialstate(rs.getBoolean("specialstate"));
	            	comment.setState(rs.getBoolean("state"));
	            	Integer userId=rs.getInt("uid");
	            			User user=userDao.find(userId);
	            	comment.setUser(user);
	            	comment.setUid(userId);
	            	Integer commodityId=rs.getInt("cid");
	            	comment.setCid(commodityId);
	            	Commodity commodity=commodityDao.queryCommodityByID(commodityId);
	            	comment.setCommodity(commodity);
	            	            
	            }
	               });
			return  comment;
	        
	  
				
			
	}
	
	
	public ArrayList<Comment> getSpecialComments(int cid){
		
		final ArrayList<Comment> commentList =new ArrayList<Comment>();
		String sql = "select * from comment where cid ="+cid;	
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            	Comment comment=new Comment();
            	comment.setId(rs.getInt("id"));
            	comment.setDetails(rs.getString("details"));
            	
            	comment.setSpecialstate(rs.getBoolean("specialstate"));
            	comment.setState(rs.getBoolean("state"));
            	Integer userId=rs.getInt("uid");
            			User user=userDao.find(userId);
            	comment.setUser(user);
            	comment.setUid(userId);
            	Integer commodityId=rs.getInt("cid");
            	comment.setCid(commodityId);
            	Commodity commodity=commodityDao.queryCommodityByID(commodityId);
            	comment.setCommodity(commodity);
            	
            	if(comment.getSpecialstate()){
                	commentList.add(comment);
            	}
            }
               });
		return  commentList;
	
	}
	
	
	
	
public ArrayList<Comment> getSensitiveCommentList(){
		
		final ArrayList<Comment> commentList =new ArrayList<Comment>();
		String sql = "select * from comment where state ="+true;	
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            	Comment comment=new Comment();
            	comment.setId(rs.getInt("id"));
            	comment.setDetails(rs.getString("details"));
            	
            	comment.setSpecialstate(rs.getBoolean("specialstate"));
            	comment.setState(rs.getBoolean("state"));
            	Integer userId=rs.getInt("uid");
            			User user=userDao.find(userId);
            	comment.setUser(user);
            	comment.setUid(userId);
            	Integer commodityId=rs.getInt("cid");
            	comment.setCid(commodityId);
            	Commodity commodity=commodityDao.queryCommodityByID(commodityId);
            	comment.setCommodity(commodity);
            	
            	commentList.add(comment);
            }
               });
		return  commentList;
	
	}


public boolean editSensitiveComment(int id,String details){
	jdbcTemplate.update("UPDATE comment SET details=?  where id=?", new Object[] {details,id});  

	return true;
}


	public ArrayList<Comment> getCommentsWithSpecialWord(){
		
		final ArrayList<Comment> commentList =new ArrayList<Comment>();
		String sql = "select * from comment where specialstate ="+true;	
		
		jdbcTemplate.query(sql, new RowCallbackHandler() { //editing    
            public void processRow(ResultSet rs) throws SQLException {    
            	Comment comment=new Comment();
            	comment.setId(rs.getInt("id"));
            	comment.setDetails(rs.getString("details"));            	
            	comment.setSpecialstate(rs.getBoolean("specialstate"));
            	comment.setState(rs.getBoolean("state"));
            	Integer userId=rs.getInt("uid");
            			User user=userDao.find(userId);
            	comment.setUser(user);
            	comment.setUid(userId);
            	Integer commodityId=rs.getInt("cid");
            	comment.setCid(commodityId);
            	Commodity commodity=commodityDao.queryCommodityByID(commodityId);
            	comment.setCommodity(commodity);
                commentList.add(comment);
            	
            }
               });
		return  commentList;
	
	}
	
	
	public boolean deleteSensitiveComment(int id) {
		jdbcTemplate.update("DELETE FROM comment WHERE id= ?", new Object[] {id});
		
		return true;
	}
	/*public void testcase() {
		Comment comment =new Comment();
		
		comment.setDetails("nothing");
        comment.setCid(1);
        comment.setUid(1);
      
		DaoFacade.getInstance().addComment(comment);
		Comment temp=DaoFacade.getInstance().queryCommentByID(1);
		System.out.println(temp.getId());
		ArrayList<Comment> comments=DaoFacade.getInstance().getComments(1);
		
		for(Comment comment2:comments) {
			System.out.print(comment2.getId()+"|");
		}
		DaoFacade.getInstance().setSpecialFlag(2, true);
		DaoFacade.getInstance().setSensitiveFlag(3, true);
		
		
	}*/
	
}

