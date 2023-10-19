package book.dao.mapper;

import java.util.List;

import book.vo.BookVO;

public interface BookMapper {
	List<BookVO> selectBookList();
	BookVO selectBookByTitle(String title);
}
