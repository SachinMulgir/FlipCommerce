package com.example.FlipCommerce.Service.Impl;

import com.example.FlipCommerce.Dto.ResponseDto.CartResponseDto;
import com.example.FlipCommerce.Model.Cart;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Model.Item;
import com.example.FlipCommerce.Repository.CartRepository;
import com.example.FlipCommerce.Repository.CustomerRepository;
import com.example.FlipCommerce.Service.CartService;
import com.example.FlipCommerce.Transformer.CartTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CartRepository cartRepository;


    @Override
    public Cart allocateCartToCustomer(Customer customer) {
        return Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();
    }

    @Override
    public CartResponseDto addToCart(Item item, String customerEmail) {

        Customer customer = this.customerRepository.findByEmail(customerEmail).get();
        Cart cart = customer.getCart();

        //set cartTotal:
        int existing = cart.getCartTotal();
        int newAmt = item.getProduct().getPrice() * item.getRequiredQuantity();
        cart.setCartTotal(existing + newAmt);

        cart.getItemList().add(item);

        // need to save: cart,item,product
        Cart savedCart = this.cartRepository.save(cart);

        //Entity -> respDto
        return CartTransformer.cartToCartResponseDto(savedCart);
    }


}
