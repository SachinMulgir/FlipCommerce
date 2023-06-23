package com.example.FlipCommerce.Controller;

import com.example.FlipCommerce.Dto.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/category-price")
    public ResponseEntity getProductByCategoryAndPrice(@RequestParam("category") Category category, @RequestParam("price") int price){
        List<ProductResponseDto> productRequestDtoList = this.productService.getProductByCategoryAndPrice(category,price);
        return new ResponseEntity(productRequestDtoList, HttpStatus.OK);
    }
}
