package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.DbConnect;
import study.dto.MyCarDto;

public class MyCarDao {
	DbConnect db = new DbConnect();

	// insert
	public void insertCar(MyCarDto dto) {
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

	// delete
	public void deledtCar(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from mycar where num=" + num;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	// 전체데이터반환
	public List<MyCarDto> getAllCars() {
		List<MyCarDto> list = new Vector<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from mycar";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MyCarDto dto = new MyCarDto();
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
}
