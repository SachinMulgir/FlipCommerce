package com.example.FlipCommerce.Controller;

import com.example.FlipCommerce.Dto.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){
        try{
            ProductResponseDto productResponseDto = this.productService.addProduct(productRequestDto);
            return new ResponseEntity(productResponseDto, HttpStatus.CREATED);
        }catch (RuntimeException ex){
            return new ResponseEntity("Failed to add product!!", HttpStatus.BAD_REQUEST);
        }
    }
}
