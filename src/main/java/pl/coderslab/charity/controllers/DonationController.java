package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entities.Category;

import java.util.List;

@Controller
public class DonationController {
    @GetMapping("/donate")
    public String donateClothsForm() {
        return "form";
    }



}
