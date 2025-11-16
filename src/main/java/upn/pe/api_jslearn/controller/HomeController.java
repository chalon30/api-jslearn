package upn.pe.api_jslearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("port", port);
        return "index"; // sin ".html"
    }
}
