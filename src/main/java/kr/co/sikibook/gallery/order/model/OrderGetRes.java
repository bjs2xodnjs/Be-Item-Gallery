package kr.co.sikibook.gallery.order.model;

import lombok.Getter;

@Getter
public class OrderGetRes {
    private int Id;
    private String name;
    private String payment;
    private long amount;
    private String created;
}
