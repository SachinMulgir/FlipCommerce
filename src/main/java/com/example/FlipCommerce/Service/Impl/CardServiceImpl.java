package com.example.FlipCommerce.Service.Impl;

import com.example.FlipCommerce.Dto.RequestDto.CardRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.CardResponseDto;
import com.example.FlipCommerce.Model.Card;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Repository.CardRepository;
import com.example.FlipCommerce.Repository.CustomerRepository;
import com.example.FlipCommerce.Service.CardService;
import com.example.FlipCommerce.Transformer.CardTransformer;
import com.example.FlipCommerce.exception.EntityNotPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws EntityNotPresentException{

        //Check whether the Customer exist or not:
        String customerEmail = cardRequestDto.getCustomerEmail();
        Optional<Customer> customerOptional = this.customerRepository.findByEmail(customerEmail);

        if( customerOptional.isEmpty() ){
            throw new EntityNotPresentException("Customer not found!!");
        }

        // if found:
        Customer customer = customerOptional.get();

        // reqDto -> Entity:
        Card card = CardTransformer.cardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);

        // make changes and save to database:
        customer.getCardList().add(card);
        Card savedCard = this.cardRepository.save(card);
        Customer savedCustomer = this.customerRepository.save(customer);

        // entity -> responseDto
        return CardTransformer.cardToCardResponseDto(savedCard, savedCustomer);
    }
}
