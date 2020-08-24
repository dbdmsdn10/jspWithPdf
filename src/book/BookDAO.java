package book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	// 도서목록 출력-----------------------------------------------------//
	public ArrayList<BookVO> list() {
		ArrayList<BookVO> array = new ArrayList<BookVO>();
		try {
			String sql = "select * from goodsinfo";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setCode(rs.getString("code"));
				vo.setTitle(rs.getString("title"));
				vo.setPrice(rs.getString("price"));
				vo.setWriter(rs.getString("writer"));
				array.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return array;
	}

	// 도서 읽기 -------------------------------------------------------//
	public BookVO read(String code) {
		BookVO vo = new BookVO();
		try {
			String sql = "select * from goodsinfo where code=?";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo.setCode(rs.getString("code"));
				vo.setTitle(rs.getString("title"));
				vo.setPrice(rs.getString("price"));
				vo.setWriter(rs.getString("writer"));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return vo;
	}

	// 도서 입력 -------------------------------------------------------//
	public boolean insert(BookVO vo) {
		try {
			String sql = "insert into goodsinfo(code, title, writer, price) values(?, ?, ?, ?)";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setString(1, vo.getCode());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getWriter());
			ps.setString(4, vo.getPrice());
			ps.execute();
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	// 도서 삭제 -------------------------------------------------------//
	public boolean delete(String code) {
		try {
			String sql = "delete from goodsinfo where code=?";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setString(1, code);
			ps.execute();
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	// 도서 수정 ------------------------------------------------------------------//
	public boolean update(BookVO vo) {
		try {
			String sql = "update goodsinfo set title=?, writer=?, price=? where code=?";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getPrice());
			ps.setString(4, vo.getCode());
			ps.execute();
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	// 데이타갯수 출력
	public int count(String key, String word) {
		int count = 0;
		try {
			String sql = "select count(*) total from goodsinfo where " + key + " like ?";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("total");
			}
		} catch (Exception e) {
			System.out.println("데이타갯수 출력" + e.toString());
		}
		return count;
	}

	// 도서목록 출력
	public ArrayList<BookVO> list(String key, String word, int page) {
		ArrayList<BookVO> array = new ArrayList<BookVO>();
		try {
			String sql = "select * from goodsinfo where " + key + " like ? limit ?, 5";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			ps.setInt(2, (page - 1) * 5);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setCode(rs.getString("code"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getString("price"));
				array.add(vo);
			}

		} catch (Exception e) {
		}
		return array;
	}
}
