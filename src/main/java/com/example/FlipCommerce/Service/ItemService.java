package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.Dto.RequestDto.ItemRequestDto;
import com.example.FlipCommerce.Model.Item;

public interface ItemService {
    Item createItem(ItemRequestDto itemRequestDto);
}
