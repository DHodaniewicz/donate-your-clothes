package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {

    CategoryRepository categoryRepository;
    InstitutionRepository institutionRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/donate")
    public String donateClothsForm(Model model) {
        model.addAttribute("donation", new Donation());
//        model.addAttribute("availableCategories", categoryRepository.findAll());
//        model.addAttribute("availableInstitutions", institutionRepository.findAll());
        return "form";
    }

    @ModelAttribute("availableCategories")
    List<Category> availableCategories() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("availableInstitutions")
    List<Institution> availableInstitutions() {
        return institutionRepository.findAll();
    }


}
