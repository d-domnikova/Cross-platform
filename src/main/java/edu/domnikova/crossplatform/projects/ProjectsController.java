package edu.domnikova.crossplatform.projects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectsController {

    @GetMapping
    public String projects (Model model){
        return "projects/projects";
    }
}
