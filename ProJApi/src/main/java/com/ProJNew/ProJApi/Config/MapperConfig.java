package com.ProJNew.ProJApi.Config;

import com.ProJNew.ProJApi.Mapper.ProductMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ProductMapper productMapper() {
        return ProductMapper.INSTANCE;
    }
}
