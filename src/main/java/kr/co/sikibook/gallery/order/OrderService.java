package kr.co.sikibook.gallery.order;

import kr.co.sikibook.gallery.item.ItemMapper;
import kr.co.sikibook.gallery.item.model.ItemGetRes;
import kr.co.sikibook.gallery.order.model.OrderPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final ItemMapper itemMapper;

    public int saveOrder(OrderPostReq order) {
        // 상품 정보 DB 로부터 가져온다.
        List<ItemGetRes> items = itemMapper.findAllByIdIn(order.getItemIds());

        return 1;
    }
}
