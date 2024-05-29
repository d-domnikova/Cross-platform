package edu.domnikova.crossplatform.myBooks;

import edu.domnikova.crossplatform.myBooks.book.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myBooks")
public class MyBooksController {
    private final BookService service;

    public MyBooksController(BookService service){
        this.service = service;
    }

    @GetMapping
    public String index (Model model, @SortDefault.SortDefaults(@SortDefault("title")) Pageable pageable){
        model.addAttribute("title", "Books");
        model.addAttribute("books", service.getBooks(pageable));
        return "myBooks/myBooks";
    }
}
