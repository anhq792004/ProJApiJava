package com.ProJNew.ProJApi.Dto.Request;

import com.ProJNew.ProJApi.Entities.Enums.Gender;
import com.ProJNew.ProJApi.Entities.Enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateRequest {
    private String productCode;
    private String productName;

    private Long brandId;
    private Long categoryId;

    private String description;
    private String material;
    private Gender gender;
    private String trademark;
    private String originCountry;
    private Status status;
}
