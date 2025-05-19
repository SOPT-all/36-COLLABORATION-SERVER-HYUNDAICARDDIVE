package org.sopt.hyundai.card.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.card.controller.dto.CardRes;
import org.sopt.hyundai.card.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/home")
    public ResponseEntity<CardRes> home(
            @RequestParam final String sortOption,
            @RequestParam final String category
    ){
        return ResponseEntity.ok(cardService.getHome(sortOption, category));
    }
}