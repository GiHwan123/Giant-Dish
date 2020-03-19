package com.example.demo.web;


import com.example.demo.domain.Food;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

//음식 목록을 보여준다.

public class FoodListResponseDto {

    private Long id;
    private String name;
    private int price;
    private LocalDateTime modifiedDate;

    public FoodListResponseDto(Food entity){
        this.id = getId();
        this.name = entity.getName(); // 푸드이름
        this.price = entity.getPrice(); // 가격
    }
}
