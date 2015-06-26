package user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import user.vo.UserVO;

@Component("spring")
public class UserDAOImpl_Spring implements UserDAO{

	@Autowired
	JdbcTemplate template;
	
	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAOImpl_Spring DB 연동");
		String sql ="select * from userinfo "
				+ "where userid = ? and userpwd= ? ";
		UserVO vo = null;
		try{
		    vo = template.queryForObject(sql,
				                     new String[]{id,pw},
				                     new UserRowMapper());
		}catch(Exception e){}
		
		return vo;
	}

	@Override
	public int addUser(final UserVO user) {
		String sql =
	  "insert into userinfo"
	+ " (userid, username, userpwd, email, phone, address)"
	+ " values (?, ?, ?, ?, ?, ?)";
		
		return template.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				   ps.setString(1, user.getUserid());
				   ps.setString(2, user.getUsername());
				   ps.setString(3, user.getUserpwd());
				   ps.setString(4, user.getEmail());
				   ps.setString(5, user.getPhone());
				   ps.setString(6, user.getAddress());
			}
		} );
	}

	@Override
	public UserVO getUser(String uid) {
		String sql = "select * from userinfo "
				+ "where userid = ?";
		UserVO vo = null;
		
		vo = template.queryForObject(sql,
				                     new String[]{uid},
				                     new UserRowMapper());
		return vo;
	}

	@Override
	public List<UserVO> getUserList() {
		String sql = "select * from userinfo ";
		return template.query(sql, new RowMapper<UserVO>() {
			@Override
			public UserVO mapRow(ResultSet rs, int rowNum) 
					                          throws SQLException {
				UserVO vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
			    return vo;
			} 
		});
	}

	@Override
	public int updateUser(UserVO user) {
		String sql = "update userinfo "
				+ "set email=?,phone=?,address=? "
				+ "where  userid  = ? ";
		
		return template.update(sql, user.getEmail(),
				                    user.getPhone(),
				                    user.getAddress(),
				                    user.getUserid()) ;
	}

	@Override
	public int deleteUser(String uid) {
		String sql = "delete from userinfo "
				+ " where  userid  = ? ";
		
		return template.update(sql, uid);
	}
}

class UserRowMapper implements RowMapper<UserVO>{

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) 
			                   throws SQLException {
		
			UserVO vo = new UserVO();
			vo.setUserid(rs.getString("userid"));
			vo.setUsername(rs.getString("username"));
			vo.setUserpwd(rs.getString("userpwd"));
			vo.setAddress(rs.getString("address"));
			vo.setEmail(rs.getString("email"));
			vo.setPhone(rs.getString("phone"));
		
		return vo;
	}
	
}









