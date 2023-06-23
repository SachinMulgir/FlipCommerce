package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.Dto.ResponseDto.CartResponseDto;
import com.example.FlipCommerce.Model.Cart;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Model.Item;

public interface CartService {

    Cart allocateCartToCustomer(Customer customer);

    CartResponseDto addToCart(Item item, String customerEmail);
}
