package spring.test;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JdbcMain {
	
	public static void main(String[] args) {
		try {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		// mysql驱动
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"emojitest",
				"root", "root");

		Statement ps = (Statement) con.createStatement();
		String sql = "select * from emoji";
		String sql1 = "insert into emoji values()";
		ResultSet rs = ps.executeQuery(sql);
		while (rs.next()) {
		// 循环输出结果集
		String account = rs.getString("emoji");
		System.out.println("account:" + account);
		}
		} catch (Exception e) {
		System.out.println("MYSQL error" + e.getMessage());
		}
	}
}
