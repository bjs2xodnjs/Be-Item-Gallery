package kr.co.sikibook.gallery.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailGetReq {
    private int orderId;
    private int memberId;
}
