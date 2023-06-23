package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.Dto.ResponseDto.CartResponseDto;
import com.example.FlipCommerce.Dto.ResponseDto.ItemResponseDto;
import com.example.FlipCommerce.Model.Cart;
import com.example.FlipCommerce.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {

    public static CartResponseDto cartToCartResponseDto(Cart cart){

        List<ItemResponseDto> itemDtoList = new ArrayList<>();
        for( Item item : cart.getItemList() ){
            ItemResponseDto itemResponseDto = ItemTransformer.itemToItemResponseDto(item);
            itemDtoList.add(itemResponseDto);
        }

        return CartResponseDto.builder()
                .customerName(cart.getCustomer().getName())
                .customerEmail(cart.getCustomer().getEmail())
                .itemResponseDtoList(itemDtoList)
                .cartTotal(cart.getCartTotal())
                .build();

    }
}
