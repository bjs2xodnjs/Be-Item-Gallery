package kr.co.sikibook.gallery.order.model;

import lombok.Builder;
import lombok.Getter;


import java.util.List;

@Getter
@Builder
public class OrderPostDto {
    private int memberId;
    private String name;
    private String address;
    private String payment;
    private String cardNumber;
    private long amount;



}
