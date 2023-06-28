package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import db.DbConnect;
import study.dto.ProjectDto;

public class ProjectDao {
	DbConnect db = new DbConnect();

	// insert
	public void insertPj(ProjectDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into pj values (null, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPhoto());
			pstmt.setString(5, dto.getFood());
			pstmt.setString(6, dto.getPrice());
			pstmt.setString(7, dto.getStar());
			pstmt.setInt(8, dto.getCount());

			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	// 다보여주는거
	public List<ProjectDto> getAllDatas() {
		List<ProjectDto> list = new Vector<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from pj order by num desc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String photo = rs.getString("photo");
				String food = rs.getString("food");
				String price = rs.getString("price");
				String star = rs.getString("star");
				int count = rs.getInt("count");

				ProjectDto dto = new ProjectDto(num, writer, title, content, photo, food, price, star, count);

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

	// detaill
	public ProjectDto getData(int num) {
		ProjectDto dto = null;
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from pj where num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String photo = rs.getString("photo");
				String food = rs.getString("food");
				String price = rs.getString("price");
				String star = rs.getString("star");
				int count = rs.getInt("count");

				dto = new ProjectDto(num, writer, title, content, photo, food, price, star, count);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return dto;

	}

	public void deleteProject(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from pj where num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	public void upProject(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "update pj set count=count+1 where num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	public void updateProject(ProjectDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "update pj set writer=?, title=?, content=?, photo=?, food=?, price=?, star=? where num=?";
		String sql2 = "update pj set writer=?, title=?, content=?, food=?, price=?, star=? where num=?";

		try {
			if (dto.getPhoto() == null) {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getContent());
				pstmt.setString(4, dto.getFood());
				pstmt.setString(5, dto.getPrice());
				pstmt.setString(6, dto.getStar());
				pstmt.setInt(7, dto.getNum());

				pstmt.execute();
			} else {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getContent());
				pstmt.setString(4, dto.getPhoto());
				pstmt.setString(5, dto.getFood());
				pstmt.setString(6, dto.getPrice());
				pstmt.setString(7, dto.getStar());
				pstmt.setInt(8, dto.getNum());

				pstmt.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	public void searchProject(String a) {
		Connection conn =db.getMysqlConnection();
		Statement stmt=null;
		ResultSet rs= null;
		String sql = "select * from pj where content like ='%"+a+"%'";
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String photo = rs.getString("photo");
				String food = rs.getString("food");
				String price = rs.getString("price");
				String star = rs.getString("star");
				int count = rs.getInt("count");

				ProjectDto dto = new ProjectDto(num, writer, title, content, photo, food, price, star, count);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	public List<ProjectDto> getAllDatasA(String a) {
		List<ProjectDto> list = new Vector<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from pj where content like \"%"+a+"%\"";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String photo = rs.getString("photo");
				String food = rs.getString("food");
				String price = rs.getString("price");
				String star = rs.getString("star");
				int count = rs.getInt("count");

				ProjectDto dto = new ProjectDto( num, writer, title, content, photo, food, price, star, count);

				list.add(dto);
				System.out.println(sql);
				
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		System.out.println(list);
		return list;

	}

}
