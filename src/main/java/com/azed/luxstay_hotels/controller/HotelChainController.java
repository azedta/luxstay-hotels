package com.azed.luxstay_hotels.controller;

import com.azed.luxstay_hotels.model.HotelChain;
import com.azed.luxstay_hotels.service.HotelChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotel-chains")
public class HotelChainController {

    private final HotelChainService hotelChainService;

    @Autowired
    public HotelChainController(HotelChainService hotelChainService) {
        this.hotelChainService = hotelChainService;
    }

    @GetMapping
    public String listHotelChains(Model model) {
        model.addAttribute("hotelChains", hotelChainService.findAllHotelChains());
        return "hotel-chain/hotel-chains";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hotelChain", new HotelChain());
        return "hotel-chain/add-hotel-chain";
    }

    @PostMapping
    public String addHotelChain(@ModelAttribute HotelChain hotelChain) {
        // If logo is null, empty, or only whitespace, assign default placeholder
        if (hotelChain.getLogo() == null || hotelChain.getLogo().trim().isEmpty()) {
            hotelChain.setLogo("placeholder.png");
        }

        hotelChainService.addHotelChain(hotelChain);
        return "redirect:/hotel-chains";
    }

    @GetMapping("/delete/{id}")
    public String deleteHotelChain(@PathVariable Long id) {
        hotelChainService.deleteHotelChain(id);
        return "redirect:/hotel-chains";
    }
}
