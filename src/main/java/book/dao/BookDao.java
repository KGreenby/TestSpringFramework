package book.dao;

import java.util.List;

import book.vo.BookVO;

public interface BookDao {
	public List<BookVO> readAll();
	public BookVO read(String title);
}
