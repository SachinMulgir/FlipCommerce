package com.example.FlipCommerce.Service.Impl;

import com.example.FlipCommerce.Dto.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.Dto.RequestDto.ItemRequestDto;
import com.example.FlipCommerce.Model.Cart;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Model.Item;
import com.example.FlipCommerce.Model.Product;
import com.example.FlipCommerce.Repository.CustomerRepository;
import com.example.FlipCommerce.Repository.ItemRepository;
import com.example.FlipCommerce.Repository.ProductRepository;
import com.example.FlipCommerce.Service.ItemService;
import com.example.FlipCommerce.Transformer.ItemTransformer;
import com.example.FlipCommerce.exception.EntityNotPresentException;
import com.example.FlipCommerce.exception.InsufficientQuantityException;
import com.example.FlipCommerce.exception.OutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ItemRepository itemRepository;


    @Override
    public Item createItem(ItemRequestDto itemRequestDto) {
        //Check if customer and product exist or not:
        //Customer Check:
        String customerEmail = itemRequestDto.getCustomerEmail();
        Optional<Customer> customerOptional = this.customerRepository.findByEmail(customerEmail);
        if( customerOptional.isEmpty() ){
            throw new EntityNotPresentException("Customer Not Found!!");
        }
        Customer customer = customerOptional.get();

        //Product check:
        int productId = itemRequestDto.getProductId();
        Optional<Product> productOptional = this.productRepository.findById(productId);
        if( productOptional.isEmpty() ){
            throw new EntityNotPresentException("Product Not Found!!");
        }
        Product product = productOptional.get();

        //Both exist:
        //check for the required_quantity:
        if( product.getAvailableQuantity() == 0 ){
            throw new OutOfStockException("Sorry!! Product is OUT OF STOCK");
        }

        if( product.getAvailableQuantity() < itemRequestDto.getRequiredQuantity() ){
            throw new InsufficientQuantityException("Insufficient Quantity!!");
        }

        //reqDto -> entity:
        Item item = ItemTransformer.itemRequestDtoToItem(product, customer, itemRequestDto.getRequiredQuantity());

        //save entity:
        Item savedItem = this.itemRepository.save(item);


        //set parameter of customer and product using item: [will be saved in addToCart func()]
        product.getItemList().add(savedItem);

        return savedItem;
    }
}
