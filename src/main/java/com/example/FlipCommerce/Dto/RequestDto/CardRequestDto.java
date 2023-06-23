package com.example.FlipCommerce.Dto.RequestDto;

import com.example.FlipCommerce.Enum.CardType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardRequestDto {

    String customerEmail;

    String cardNo;

    int cvv;

    CardType cardType;

    Date validTill;

}
