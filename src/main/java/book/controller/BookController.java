package book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import book.service.BookService;
import book.vo.BookVO;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	public BookController() {
		System.out.println(this.getClass().getName() + "생성자 호출했어영!");
	}
	
	@RequestMapping("/bookList.do")
	public ModelAndView bookList() {
		List<BookVO> bookVO = bookService.getBookList();
		return new ModelAndView("bookList", "bookList", bookVO);
	}
	
	@RequestMapping("/getBook.do")
	public String getBook(@RequestParam String title, Model model) { // 이 방법을 좀 더 선호
		BookVO bookVO = bookService.getBookByTitle(title);
		model.addAttribute("book", bookVO);
		return "bookInfo";
	}
}
