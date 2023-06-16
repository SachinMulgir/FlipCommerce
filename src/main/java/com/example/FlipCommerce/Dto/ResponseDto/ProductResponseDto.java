package com.example.FlipCommerce.Dto.ResponseDto;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.Enum.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {

    String name;

    Category category;

    int price;

    String sellerName;

    Status status;
}
