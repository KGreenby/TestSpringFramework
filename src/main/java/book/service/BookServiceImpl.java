package book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.dao.BookDao;
import book.vo.BookVO;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	@Override
	public List<BookVO> getBookList() {
		return bookDao.readAll();
	}

	@Override
	public BookVO getBookByTitle(String title) {
		return bookDao.read(title);
	}

}
