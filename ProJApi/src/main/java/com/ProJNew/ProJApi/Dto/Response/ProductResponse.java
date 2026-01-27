package com.ProJNew.ProJApi.Dto.Response;

import com.ProJNew.ProJApi.Entities.Enums.Gender;
import com.ProJNew.ProJApi.Entities.Enums.Status;
import com.ProJNew.ProJApi.Entities.Properties.Brand;
import com.ProJNew.ProJApi.Entities.Properties.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;

    private String productCode;

    private String productName;

    private Brand brand;

    private Category category;

    private Long materialId;

    private Gender gender;

    private String trademark;

    private String originCountry;

    private Status status ;

}
