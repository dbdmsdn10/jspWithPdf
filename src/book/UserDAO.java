package book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	public UserVO read(String id, String password) {
		UserVO vo = new UserVO();
		try {
			String sql = "select * from userinfo where id=? and password=?";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return vo;
	}

	public void insert(UserVO vo) {
		try {
			String sql = "insert into userinfo(id, password, name) values(?, ?, ?)";
			PreparedStatement ps = DataBase.CON.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
