package com.cpan252.assignment3.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import com.cpan252.assignment3.repository.ClothesRepository;

import com.cpan252.assignment3.model.Item;



@Controller
@Slf4j
@RequestMapping("/clothelist")
public class ClotheListController {

    private static final int PAGE_SIZE = 5;
    @Autowired
    private ClothesRepository clothesRepository;

    public ClotheListController(ClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }
    @GetMapping
    public String clothelist() {
        return "clothelist";
    }

    @ModelAttribute
    public void items(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        var itemPage = clothesRepository.findAll(PageRequest.of(0, PAGE_SIZE));

        model.addAttribute("username", username);
        model.addAttribute("items", itemPage);
        model.addAttribute("currentPage", itemPage.getNumber());
        model.addAttribute("totalPages", itemPage.getTotalPages());
    }








    @GetMapping("/sort")
    public String sortByBrand(Model model){

        Sort sort = Sort.by(Sort.Direction.ASC, "brand");
        Pageable pageable = PageRequest.of(0, PAGE_SIZE, sort);
        Page<Item> sortedItemsPage = clothesRepository.findAll(pageable);

        model.addAttribute("items", sortedItemsPage);
        model.addAttribute("currentPage", sortedItemsPage.getNumber());
        model.addAttribute("totalPages", sortedItemsPage.getTotalPages());
        return "clothelist";
    }


    @GetMapping("/switchPage")
    public String switchPage(Model model,
                             @RequestParam("pageToSwitch") Optional<Integer> pageToSwitch) {
        var page = pageToSwitch.orElse(0);
//        var currentPath = request.getRequestURL().toString();

        var totalPages = (int) model.getAttribute("totalPages");
        if (page < 0 || page >= totalPages) {
            return "clothelist";
        }
        var itemPage = clothesRepository.findAll(PageRequest.of(pageToSwitch.orElse(0),
                PAGE_SIZE));
        model.addAttribute("items", itemPage.getContent());
        model.addAttribute("currentPage", itemPage.getNumber());
        return "clothelist";

    }
}
