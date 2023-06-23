package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.Dto.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.CustomerResponseDto;
import com.example.FlipCommerce.Model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .address(customerRequestDto.getAddress())
                .email(customerRequestDto.getEmail())
                .mobile(customerRequestDto.getMobile())
                .gender(customerRequestDto.getGender())
                .build();
    }

    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer){
        return CustomerResponseDto.builder()
                .name(customer.getName())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .mobile(customer.getMobile())
                .gender(customer.getGender())
                .build();
    }
}
