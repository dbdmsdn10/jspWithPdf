package book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BBSDAO {
	public ArrayList<BBSVO> list(int start) {
		ArrayList<BBSVO> array = new ArrayList<BBSVO>();
		try {
			String sql = "select * from bbs order by seqno desc limit ?, 5";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setInt(1, start);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BBSVO vo = new BBSVO();
				vo.setSeqno(rs.getInt("seqno"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getDate("wdate"));
				array.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return array;
	}

	// 게시판 글읽기
	public BBSVO read(int seqno) {
		BBSVO vo = new BBSVO();
		try {
			String sql = "select * from bbs where seqno=?";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setInt(1, seqno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vo.setSeqno(rs.getInt("seqno"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getDate("wdate"));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return vo;
	}

	// 게시글 입력
	public void insert(BBSVO vo) {
		try {
			String sql = "insert into bbs(title, content, wdate, writer) values(?,?, now(), ?)";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setString(3, vo.getWriter());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// 게시글 갯수 출력
	public int total() {
		int total = 0;
		try {
			String sql = "select count(seqno) total from bbs";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				total = rs.getInt("total");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return total;
	}
}
