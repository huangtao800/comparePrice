package edu.nju.comparePrice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import edu.nju.comparePrice.models.BaseUser;
import edu.nju.comparePrice.models.Brand;
import edu.nju.comparePrice.models.CandidateWord;
import edu.nju.comparePrice.models.Comment;
import edu.nju.comparePrice.models.Commodity;
import edu.nju.comparePrice.models.CommodityCrawl;
import edu.nju.comparePrice.models.CrawlerWebsite;
import edu.nju.comparePrice.models.SensitiveWord;
import edu.nju.comparePrice.models.SpecialWord;
import edu.nju.comparePrice.models.Synonym;
import edu.nju.comparePrice.models.User;
import edu.nju.comparePrice.spring.ApplicationContextContainer;

@Repository
public class DaoFacade {
	@Autowired
	private CommentDao cDao;
	@Autowired
	private UserDao uDao;
	@Autowired
    private SensitiveWordDao sDao;
	@Autowired
	private CommodityDao pDao;
	@Autowired
	private CandidateWordDao cwDao;
	@Autowired
	private BrandDao bDao;
	@Autowired
	private CrawlerWebsiteDao crDao;
	@Autowired
	private SynonymDao synonDao;
	
	
	
	/*public static DaoFacade getInstance(){
		return ApplicationContextContainer.getBean(DaoFacade.class);
	}*/
	
	public boolean login(String username,String password) {
		return uDao.login(username, password);
	}

	 
	public boolean updateCommodity(ArrayList<CommodityCrawl> crawlList){
	for(CommodityCrawl crawl:crawlList) {
		Brand brand=bDao.queryBrandByName(crawl.getBrandName());
		
		if(brand==null) {
			bDao.saveBrand(crawl.getBrandName());
	        brand=bDao.queryBrandByName(crawl.getBrandName());
		}
		crawl.setBrandId(brand.getId());
		Commodity commodity=pDao.queryCommodityByOnlineID(crawl.getOnlineId());
		
		if(commodity==null) {
			pDao.insertCommodity(crawl);
		}
		else {
			pDao.updateCommodityByCrawl(crawl, commodity.getId());
		}
	}
	return true;
		
		
	}

	public ArrayList<SensitiveWord> getSensitiveWords(){
		return (ArrayList<SensitiveWord>)sDao.getSensiviveWordList();
	}

	public ArrayList<SpecialWord> getSpecialWords(){
		return uDao.getSpecialWords();
	}

	public int getSensitiveCountByUseID(int userId) {
		return uDao.getSensitiveCountByUseID(userId);
	}

	public void addSentsitiveCount(int userID,int increment) {
	   uDao.addSentsitiveCount(userID, increment);
	}
	public void setSensitiveFlag(int commentID, boolean flag) {
		cDao.setSensitiveFlag(commentID, flag);
	}

	public void setSpecialFlag(int commentID,boolean flag) {
	
	}

	public void addWaterNavy(int userID) {
		uDao.addWaterNavy(userID);
	}

	public User find(int userId) {
		return uDao.find(userId);
	}
	public int save(String username, String password) {
		return uDao.save(username, password);
	}

	 

	public ArrayList<Comment> getComments(int cid){
		return (ArrayList<Comment>)cDao.getComments(cid);
	}

	public boolean addComment(Comment c) {
		return cDao.addComment(c);
	}

	public ArrayList<Comment> getSpecialComments(int cid){
		return cDao.getSpecialComments(cid);
	}

	
	
	 

	public ArrayList<Commodity> getForbiddenCommodities(){
		return (ArrayList<Commodity>)pDao.getForbiddenCommodities();
	}
    
	public ArrayList<Commodity> getToForbidCommodities(String commodityName){
		return (ArrayList<Commodity>) pDao.getToForbidCommodities(commodityName);
	}
	public boolean cancelForbid(int commodityId) {
		return pDao.cancelForbid(commodityId);
	}

	public boolean forbid(int commodityId) {
		return pDao.forbid(commodityId);
	}

	public boolean addSensitiveWord(String sensitiveWord) {
		return sDao.addSensitiveWord(sensitiveWord);
	}

	public ArrayList<SensitiveWord> getSensiviveWordList(){
		return (ArrayList<SensitiveWord>)sDao.getSensiviveWordList();
	}

	public boolean removeSensitiveWord(int sensitiveWordId) {
		return sDao.removeSensitiveWord(sensitiveWordId);
	}

	public ArrayList<Brand> getBrandList(){
		return (ArrayList<Brand>)bDao.getBrandList();
	}

	public boolean saveBrand(int brandId,int brandWeight) {
		return bDao.saveBrand(brandId, brandWeight);

	}

	 
	public ArrayList<CrawlerWebsite> getCrawlerWebSiteList(){
		
		return  crDao.getCrawlerWebSiteList();
	
	}

	public BaseUser findBaseUser(int id) {
	return uDao.findBaseUser(id);
	}
	
	public boolean addCrawlerWebsite(String crawlerWebSite) {
		
		
		
		return crDao.addCrawlerWebsite(crawlerWebSite);
	}
	public boolean removeCrawlerWebsite(int crawlerWebsiteId) {
		
		
		return crDao.removeCrawlerWebsite(crawlerWebsiteId);
	}

	public Commodity queryCommodityByID(Integer commodityId) {
		// TODO Auto-generated method stub
		return pDao.queryCommodityByID(commodityId);
	}

	public Comment queryCommentByID(int i) {
		// TODO Auto-generated method stub
		return cDao.queryCommentById(i);
	}
	public  Brand queryBrandById(int brandId){
		return bDao.queryBrandById(brandId);
	}

	
	public ArrayList<Synonym> getSynonymByFlag(int flag){
	    return synonDao.getSynonymByFlag(flag);
		
		}
	
		
	
		
		public Synonym getSynonymByName(String name) {
		return synonDao.getSynonymByName(name);
		
			
		}

		public boolean addSynonym(Synonym synonym) {
			
			return synonDao.addSynonym(synonym);
		}
	
		public List<CandidateWord> queryCandidateWordByBrandId(int brandId){
		  return cwDao.queryCandidateWordByBrandId(brandId);
			}
		
		public boolean removeCandidateWord(CandidateWord cw) {
			return cwDao.removeCandidateWord(cw);
		}
		
		public boolean addCandidateWord(CandidateWord cw){
			
			return cwDao.addCandidateWord(cw);
		}
		
		public ArrayList<Comment> getCommentsWithCandidateWord(){
		return cDao.getCommentsWithCandidateWord();
		}
		
		public ArrayList<Commodity> findCommodity(List<Synonym> keywords){
			return pDao.findCommodity(keywords);
		}
		
		
		public int getCurrentMaxFlag(){
			return synonDao.getCurrentMaxFlag();
		
		}
}
