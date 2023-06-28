package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.DbConnect;
import study.dto.PersonDto;

public class PersonDao {
	DbConnect db = new DbConnect();

	// insert
	public void insertPerson(PersonDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into person values (null,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);

			// 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getYear());
			pstmt.setString(3, dto.getAdd());
			pstmt.setString(4, dto.getJob());
			pstmt.setString(5, dto.getPhoto());

			// 실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// delete
	public void deletePerson(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from person where num=" + num;

		try {
			pstmt = conn.prepareStatement(sql);
			// 위에서 바인딩 해놔서 여기서 다시 안해도됨
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// get data
	public PersonDto getData(int num) {
		PersonDto dto = new PersonDto();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from person where num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setInt(1, num);
			// 실행
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setYear(rs.getInt("birthyear"));
				dto.setAdd(rs.getString("address"));
				dto.setJob(rs.getString("job"));
				dto.setPhoto(rs.getString("photo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return dto;

	}

	// update
	public void updatePerson(PersonDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "update person set name=?, birthyear=?, address=?, photo=?, job=? where num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getYear());
			pstmt.setString(3, dto.getAdd());
			pstmt.setString(4, dto.getPhoto());
			pstmt.setString(5, dto.getJob());
			pstmt.setInt(6, dto.getNum());

			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// db에서 데이터를 list에 담아서 리턴하는 메소드
	public List<PersonDto> getAllPersons() {
		List<PersonDto> list = new Vector<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from person";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PersonDto dto = new PersonDto();
				// 데이터 넣기
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setYear(rs.getInt("birthyear"));
				dto.setAdd(rs.getString("address"));
				dto.setJob(rs.getString("job"));
				dto.setPhoto(rs.getString("photo"));
				// 리스트에 추가
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
	public List<PersonDto> getSearchNamePersons(String sword) {
		List<PersonDto> list = new Vector<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from person where name like ? order by num asc";

		try {
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, "%"+sword+"%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PersonDto dto = new PersonDto();
				// 데이터 넣기
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setYear(rs.getInt("birthyear"));
				dto.setAdd(rs.getString("address"));
				dto.setJob(rs.getString("job"));
				dto.setPhoto(rs.getString("photo"));
				// 리스트에 추가
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
