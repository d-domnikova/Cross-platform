package edu.domnikova.crossplatform.myBooks;

import edu.domnikova.crossplatform.myBooks.book.BookService;
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
    public String index (Model model){
        model.addAttribute("books", service.getAllBooks());
        return "myBooks/myBooks";
    }
}
