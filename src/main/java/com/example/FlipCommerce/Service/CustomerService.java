package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.Dto.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.CustomerResponseDto;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);

}
