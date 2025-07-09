package kr.co.sikibook.gallery.cart.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartPostReq {
    private int memberId;
    private int itemId;
}
