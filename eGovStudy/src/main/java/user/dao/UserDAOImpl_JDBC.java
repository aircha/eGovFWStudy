package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import common.JDBCUtil;
import user.vo.UserVO;

@Component("jdbc")
public class UserDAOImpl_JDBC implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAOImpl_JDBC DB 연동");
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		String sql ="select * from userinfo "
				+ "where userid = ? and userpwd= ? ";
		try{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while(rs.next()){
				vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
		return vo;
	}

	@Override
	public int addUser(UserVO user) {
		String sql =
				"insert into userinfo"
	+ " (userid, username, userpwd, email, phone, address)"
	+ " values (?, ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		int row = 0;
		
		try{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//ps ? 값 세팅 => PreparedStatementSetter
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getUserpwd());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAddress());
			//실행 ps.
			row = ps.executeUpdate();
			//결과값 핸들링
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
		return row;
	}

	@Override
	public UserVO getUser(String uid) {
		String sql = "select * from userinfo "
				+ "where userid = ?";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		int row = 0;
		
		try{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//ps ? 값 세팅 => PreparedStatementSetter
			ps.setString(1, uid);
			//실행 ps.
			rs = ps.executeQuery();
			//결과값 핸들링  RowMapper 작업
			while(rs.next()){
				vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
				vo.setEmail(rs.getString("email"));
				vo.setAddress(rs.getString("address"));
				vo.setPhone(rs.getString("phone"));
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
		return vo;
	}

	@Override
	public List<UserVO> getUserList() {
		String sql = "select * from userinfo ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		int row = 0;
		List<UserVO> list = new ArrayList<UserVO>();
		try{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//ps ? 값 세팅 => PreparedStatementSetter
			//실행 ps.
			rs = ps.executeQuery();
			//결과값 핸들링  RowMapper 작업
			while(rs.next()){
				vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
				vo.setEmail(rs.getString("email"));
				vo.setAddress(rs.getString("address"));
				vo.setPhone(rs.getString("phone"));
				list.add(vo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
		return list;
	}

	@Override
	public int updateUser(UserVO user) {
		String sql = "update userinfo "
				+ "set email=?,phone=?,address=? "
				+ "where  userid  = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		int row = 0;
		
		try{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//ps ? 값 세팅 => PreparedStatementSetter
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getUserid());
			//실행 ps.
			//결과값 핸들링
			row = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
		return row;
	}

	@Override
	public int deleteUser(String uid) {
		String sql = "delete from userinfo "
				+ " where  userid  = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		int row = 0;
		
		try{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//ps ? 값 세팅 => PreparedStatementSetter
			ps.setString(1, uid);
			//실행 ps.
			//결과값 핸들링
            row = ps.executeUpdate();  			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
		
		return row;
	}
}
