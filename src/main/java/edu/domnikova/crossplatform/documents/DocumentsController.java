package edu.domnikova.crossplatform.documents;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documents")
public class DocumentsController {

    @GetMapping
    public String documents (Model model){
        return "documents/documents";
    }
}
