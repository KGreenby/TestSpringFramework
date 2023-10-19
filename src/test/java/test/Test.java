package test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import book.dao.mapper.BookMapper;
import book.service.BookService;
import book.vo.BookVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class Test {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	BookMapper bookMapper;
	
	@Autowired
	BookService bookService;
	
	
	
	@org.junit.jupiter.api.Test
	public void dataSource() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB Product Name : " + metaData.getDatabaseProductName());
			System.out.println("DB Driver : " + metaData.getDriverName());
			System.out.println("DB Url : " + metaData.getURL());
			System.out.println("DB Username : " + metaData.getUserName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	@org.junit.jupiter.api.Test
	public void sessionFactory() {
		System.out.println(sessionFactory.getClass().getName());
	}
	
	@org.junit.jupiter.api.Test @Disabled
	public void session() {
		BookVO book = sqlSession.selectOne("selectBookByTitle", "개미");
		System.out.println(book);
	}
	
	@org.junit.jupiter.api.Test @Disabled
	public void mapper() {
		BookVO book = bookMapper.selectBookByTitle("개미");
		System.out.println(book);
	}
	
	@org.junit.jupiter.api.Test
	public void service() {
		BookVO book = bookService.getBookByTitle("개미");
		System.out.println(book);
	}
	

}
