package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.Dto.RequestDto.CardRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.CardResponseDto;
import com.example.FlipCommerce.Model.Card;
import com.example.FlipCommerce.Model.Customer;

import java.util.UUID;

public class CardTransformer {

    public static Card cardRequestDtoToCard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .validTill(cardRequestDto.getValidTill())
                .build();
    }


    public static CardResponseDto cardToCardResponseDto(Card savedCard, Customer savedCustomer) {
        return CardResponseDto.builder()
                .customerName(savedCustomer.getName())
                .customerEmail(savedCustomer.getEmail())
                .cardNo(savedCard.getCardNo())
                .cardType(savedCard.getCardType())
                .build();
    }
}
