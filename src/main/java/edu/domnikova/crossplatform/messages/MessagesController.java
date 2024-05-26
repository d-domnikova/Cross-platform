package edu.domnikova.crossplatform.messages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messages")
public class MessagesController {

    @GetMapping
    public String messages (Model model){
        return "messages/messages";
    }
}
