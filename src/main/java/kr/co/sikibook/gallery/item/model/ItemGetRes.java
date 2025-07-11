package kr.co.sikibook.gallery.item.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ItemGetRes {
    private int id;
    private String name;
    private String imgPath;
    private int price;
    private int discountPer;
}
