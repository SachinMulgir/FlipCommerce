package com.example.FlipCommerce.Service.Impl;

import com.example.FlipCommerce.Dto.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.CustomerResponseDto;
import com.example.FlipCommerce.Model.Cart;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Repository.CustomerRepository;
import com.example.FlipCommerce.Service.CartService;
import com.example.FlipCommerce.Service.CustomerService;
import com.example.FlipCommerce.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CartService cartService;

    @Override
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

        //RequestDto -> entity
        Customer customer = CustomerTransformer.customerRequestDtoToCustomer(customerRequestDto);

        //allocate Cart to the customer:
        Cart cart = this.cartService.allocateCartToCustomer(customer);
        customer.setCart(cart);

        //save the entity:
        Customer savedCustomer = this.customerRepository.save(customer);

        //entity -> CustomerResponseDto
        return CustomerTransformer.customerToCustomerResponseDto(savedCustomer);
    }




}
