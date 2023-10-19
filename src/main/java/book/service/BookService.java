package book.service;

import java.util.List;

import book.vo.BookVO;


public interface BookService {
	public List<BookVO> getBookList();
	public BookVO getBookByTitle(String title);
}
