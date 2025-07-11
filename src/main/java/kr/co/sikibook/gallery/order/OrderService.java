package kr.co.sikibook.gallery.order;

import kr.co.sikibook.gallery.cart.CartMapper;
import kr.co.sikibook.gallery.item.ItemMapper;
import kr.co.sikibook.gallery.item.model.ItemGetRes;
import kr.co.sikibook.gallery.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final ItemMapper itemMapper;
    private final CartMapper cartMapper;

    @Transactional
    public int saveOrder(OrderPostReq order, int logginedMemberId) {
        // 상품 정보 DB 로부터 가져온다.
        List<ItemGetRes> itemList = itemMapper.findAllByIdIn(order.getItemIds());
        log.info("itemList:{}", itemList);
        int amount = 0;
        for (ItemGetRes item : itemList) {
            amount += item.getPrice() - (item.getPrice() * item.getDiscountPer() / 100);
        }
        log.info("amount:{}", amount);

        // 만드세요! OrderPostDto 객체화 하시고 데이터 넣어주세요.

        OrderPostDto orderPostDto = new OrderPostDto();
        orderPostDto.setMemberId(logginedMemberId);
        orderPostDto.setName(order.getName());
        orderPostDto.setAddress(order.getAddress());
        orderPostDto.setPayment(order.getPayment());
        orderPostDto.setCardNumber(order.getCardNumber());
        orderPostDto.setAmount(amount);
        log.info("before=orderPostDto:{}", orderPostDto);
        int result = orderMapper.save(orderPostDto);
        log.info("after-orderPostDto:{}", orderPostDto);


        OrderItemPostDto orderItemPostDto = new OrderItemPostDto(orderPostDto.getOrderId(),order.getItemIds());
        // int resultDetail = orderItemMapper.save(orderItemPostDto)
        orderItemMapper.save(orderItemPostDto);

        cartMapper.deleteByMemberId(logginedMemberId);

        return 1;
    }
    public List<OrderGetRes> findAllByMemberId(int memberId) {
        return orderMapper.findAllByMemberIdOrderByIdDesc(memberId);
    }
    public OrderDetailGetRes detail(OrderDetailGetReq req) {
        OrderDetailGetRes result = orderMapper.findByOrderIdAndMemberId(req);
        log.info("result={}", result);
        return result;
    }
}
