package com.example.FlipCommerce.Controller;

import com.example.FlipCommerce.Dto.RequestDto.CardRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.CardResponseDto;
import com.example.FlipCommerce.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto){
        try{
            CardResponseDto cardResponseDto = this.cardService.addCard(cardRequestDto);
            return new ResponseEntity(cardResponseDto, HttpStatus.CREATED);
        }catch (RuntimeException ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
