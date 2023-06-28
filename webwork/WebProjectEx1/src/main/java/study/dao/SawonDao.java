package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.DbConnect;
import study.dto.SawonDto;

public class SawonDao {
	DbConnect db = new DbConnect();
	
	public List<SawonDto> getAllSawon(){
		List<SawonDto> list = new Vector<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SawonDto dto = new SawonDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setScore(rs.getInt("score"));
				dto.setGender(rs.getString("gender"));
				dto.setBuseo(rs.getString("buseo"));
				list.add(dto);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return list;
		
	}
	
	public List<SawonDto> getAllSawonMan(){
		List<SawonDto> list = new Vector<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon where gender='남자'";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SawonDto dto = new SawonDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setScore(rs.getInt("score"));
				dto.setGender(rs.getString("gender"));
				dto.setBuseo(rs.getString("buseo"));
				list.add(dto);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return list;
		
	}
	public List<SawonDto> getAllSawonWoman(){
		List<SawonDto> list = new Vector<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon where gender='여자'";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SawonDto dto = new SawonDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setScore(rs.getInt("score"));
				dto.setGender(rs.getString("gender"));
				dto.setBuseo(rs.getString("buseo"));
				list.add(dto);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return list;
		
	}
	
	public List<SawonDto> getSelectList(int select){
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		
		List<SawonDto> list=new Vector<SawonDto>();
		if(select==1)
			sql="select * from sawon order by num asc";
		else if(select==2)
			sql="select * from sawon where gender='남자' order by num asc";
		else
			sql="select * from sawon where gender='여자' order by num asc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SawonDto dto=new SawonDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setScore(rs.getInt("score"));
				dto.setGender(rs.getString("gender"));
				dto.setBuseo(rs.getString("buseo"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
		
	}
	
	
}
