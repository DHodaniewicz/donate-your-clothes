package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {

    CategoryRepository categoryRepository;
    InstitutionRepository institutionRepository;
    DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/donate")
    public String donateClothsForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donate")
    public String donateCloths(Donation donation) {
        donationRepository.save(donation);
        return null;
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
