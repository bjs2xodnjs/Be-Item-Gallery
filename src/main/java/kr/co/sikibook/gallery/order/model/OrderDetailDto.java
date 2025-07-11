package kr.co.sikibook.gallery.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDto {
    private int id;
    private String name;
    private String imgPath;
    private int price;
    private int discountPer;


}
