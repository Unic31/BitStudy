package study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.setting.ConnectionManager;
import study.dto.SmartDto;

public class SmartDao {
	ConnectionManager connectionManager = ConnectionManager.getInstance();
	 SqlSession session;
	 
	 private SqlSession getSession()
	 {
	  session = connectionManager.openSession();

	  return session;
	 }
	 ////////////////////////////////////////////////
	 public int getTotalCount() {
		 int totalCount;
		 session=getSession();
		 totalCount=session.selectOne("smart.getTotalCount");//namespace.id///namespace생략 가능(혼동되니까 그냥 붙이자)
		 session.close();
		 return totalCount;
	 }
	 public void insertSmart(SmartDto dto) {
		 session=getSession();
		 session.insert("smart.insertSmart",dto);
		 session.close();
	 }
	 public List<SmartDto> getAllList(){
		 List<SmartDto> list = null;
		 session=getSession();
		 list=session.selectList("smart.selectOfSmart");
		 session.close();
		 return list;
	 }
	 public void updateReadCount(int num) {
		 session=getSession();
		 session.update("smart.updateReadCount",num);
		 session.close();
	 }
	 public void updateLikes(int num) {
		 session=getSession();
		 session.update("smart.updateLikes",num);
		 session.close();
	 }
	 public SmartDto getData(int num) {
		 SmartDto dto = null;
		 session=getSession();
		 dto=session.selectOne("smart.selectOneOfSmart",num);
		 session.close();
		 return dto;
	 }
	 public void deleteOfSmart(int num) {
		 session=getSession();
		 session.delete("smart.deleteOfSmart",num);
		 session.close();
	 }
	 public void updateSmart(SmartDto dto) {
		 session=getSession();
		 session.delete("smart.updateSmart",dto);
		 session.close();
	 }
}
