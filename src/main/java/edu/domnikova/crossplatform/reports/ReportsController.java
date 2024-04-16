package edu.domnikova.crossplatform.reports;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    @GetMapping
    public String reports (Model model){
        return "reports/reports";
    }
}
