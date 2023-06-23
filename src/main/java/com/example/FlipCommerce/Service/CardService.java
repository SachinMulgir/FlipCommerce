package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.Dto.RequestDto.CardRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.CardResponseDto;

public interface CardService {
    CardResponseDto addCard(CardRequestDto cardRequestDto);
}
