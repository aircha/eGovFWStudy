package day1;

import java.sql.Connection;

import org.junit.Test;

import common.JDBCUtil;

public class Test2 {
	
	@Test
	public void connectionTest() {
		Connection con = JDBCUtil.getConnection();
		System.out.println(con);
		JDBCUtil.close(null, null, con);
	}
}
