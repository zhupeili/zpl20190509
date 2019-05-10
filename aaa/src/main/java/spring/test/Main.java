package spring.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import myWorld.dao.MyWorldDao;
import myWorld.service.MyWorldService;

/**
 * @author zpl
 * @version 创建时间：2018年3月16日 下午3:39:09 类说明
 */
public class Main {

	private Knight k;

	public static void main(String[] args) {
		// ApplicationContext context =
		// new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
		// ApplicationContext context2 =
		// new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
		// MyWorldService myService =
		// context.getBean("myWorldService",MyWorldService.class);
		//// String www = myService.selectById("11");

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"hongxiutianxiangbooks",
						"root", "root");
				System.out.println(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
