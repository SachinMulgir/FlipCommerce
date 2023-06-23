package com.example.FlipCommerce.Controller;

import com.example.FlipCommerce.Dto.RequestDto.ItemRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.CardResponseDto;
import com.example.FlipCommerce.Dto.ResponseDto.CartResponseDto;
import com.example.FlipCommerce.Dto.ResponseDto.ItemResponseDto;
import com.example.FlipCommerce.Model.Item;
import com.example.FlipCommerce.Service.CartService;
import com.example.FlipCommerce.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){
        try{
            Item item = this.itemService.createItem(itemRequestDto);
            CartResponseDto cartResponseDto = this.cartService.addToCart(item, itemRequestDto.getCustomerEmail());
            return new ResponseEntity(cartResponseDto, HttpStatus.CREATED);
        }catch (RuntimeException ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
