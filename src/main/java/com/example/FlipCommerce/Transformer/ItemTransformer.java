package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.Dto.ResponseDto.ItemResponseDto;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Model.Item;
import com.example.FlipCommerce.Model.Product;

public class ItemTransformer {

    public static Item itemRequestDtoToItem(Product product, Customer customer, int requiredQuantity){
        return Item.builder()
                .requiredQuantity(requiredQuantity)
                .cart(customer.getCart())
                .product(product)
                .build();
    }

    public static ItemResponseDto itemToItemResponseDto(Item item) {
        return ItemResponseDto.builder()
                .productName(item.getProduct().getName())
                .productPrice(item.getProduct().getPrice())
                .requiredQuantity(item.getRequiredQuantity())
                .build();
    }
}
