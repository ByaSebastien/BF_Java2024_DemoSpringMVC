package be.bstorm.bf_java_2024_demospringmvc.pl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<String> names = List.of(
            "Pierre",
            "Pol",
            "Jacques"
    );

    // Quand je contact mon server à l'url http://localhost:8080/ ,
    // il me retourne le contenus du fichier home.html (situé dans templates)
    @GetMapping("/") // url (contacter le server)
    public String home() {
        return "home"; // path vers html file depuis template(return du contenus html)
    }

    @GetMapping("/hello/{name}")
    public String hello(
            @PathVariable
            String name,
            Model model
    ){
        String sentence = "Hello " + name + "!";
        model.addAttribute("sentence", sentence);
        return "hello";
    }
}
