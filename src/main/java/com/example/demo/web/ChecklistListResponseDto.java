package com.example.demo.web;

import com.example.demo.domain.Address;
import com.example.demo.domain.Checklist;
import com.example.demo.domain.DeliveryStatus;
import com.example.demo.domain.Food;

//본인이 주문한 정보를 보여준다.
public class ChecklistListResponseDto {
    private int price;
    private int stock;
    private String Food_name;
    private String Store_name;
    private Address address;
    private DeliveryStatus status;

    public ChecklistListResponseDto(Checklist entity){
        this.Food_name = entity.getFood_name(); // 푸드이름
        this.Store_name = entity.getStore_name(); // 가격
        this.address = entity.getAddress();
        this.price = entity.getPrice();
        this.status = entity.getStatus();
        this.stock = entity.getStock();
    }
}
