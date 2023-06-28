package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import db.DbConnect;
import study.dto.CarDto;

public class CarDao {
	DbConnect db = new DbConnect();

	// insert
	public void insertCar(CarDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into mycar values (null, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, dto.getCarname());
			pstmt.setInt(2, dto.getCarprice());
			pstmt.setString(3, dto.getCarphoto());
			pstmt.setString(4, dto.getGuipday());

			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	// deleteCar
	public void deleteCar(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from mycar where num=" + num;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	// getAllCars dto의 모든 인자들 반환?
	public List<CarDto> getAllCars() {
		List<CarDto> list = new Vector<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from mycar";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CarDto dto = new CarDto();
				dto.setNum(rs.getInt("num"));
				dto.setCarname(rs.getString("carname"));
				dto.setCarprice(rs.getInt("carprice"));
				dto.setCarphoto(rs.getString("carphoto"));
				dto.setGuipday(rs.getString("guipday"));

				list.add(dto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}
	
	public CarDto getCar(int num) {
		CarDto dto = null;
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select * from mycar where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String carname = rs.getString("carname");
				int carprice = rs.getInt("carprice");
				String carphoto = rs.getString("carphoto");
				String guipday = rs.getString("guipday");
				
				dto = new CarDto(num, carname, carprice, carphoto, guipday);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dto;
		
	}
	
	public void updateCar(CarDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt=null;
		String sql = "update mycar set carname=?, carprice=?, carphoto=?, guipday=? where num=? ";

		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCarname());
			pstmt.setInt(2, dto.getCarprice());
			pstmt.setString(3, dto.getCarphoto());
			pstmt.setString(4, dto.getGuipday());
			pstmt.setInt(5, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		
		
	}

}
