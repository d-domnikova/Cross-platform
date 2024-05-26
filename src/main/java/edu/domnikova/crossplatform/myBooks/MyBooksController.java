package edu.domnikova.crossplatform.myBooks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myBooks")
public class MyBooksController {

    @GetMapping
    public String myBooks (Model model){
        return "myBooks/myBooks";
    }
}
