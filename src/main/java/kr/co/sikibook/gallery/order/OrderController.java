package kr.co.sikibook.gallery.order;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sikibook.gallery.account.etc.AccountConstants;
import kr.co.sikibook.gallery.common.util.HttpUtils;
import kr.co.sikibook.gallery.order.model.OrderDetailGerReq;
import kr.co.sikibook.gallery.order.model.OrderDetailGetRes;
import kr.co.sikibook.gallery.order.model.OrderPostReq;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> add(HttpServletRequest httpReq, @RequestBody OrderPostReq req) {
        int logginedMemberId = (int) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        log.info("req: {}", req);
        int result = orderService.saveOrder(req, logginedMemberId);

        return null;
    }

    @GetMapping
    public ResponseEntity<?> getOrders(HttpServletRequest httpReq) {
        int logginedMemberId = (int) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        log.info("logginedMemberId: {}", logginedMemberId);

        return ResponseEntity.ok(orderService.findAllByMemberId(logginedMemberId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findDetail(HttpServletRequest httpReq, @PathVariable int orderId) {
        int logginedMemberId = (int) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        OrderDetailGetReq req = new OrderDetailGetReq();
        req.setOrderId(orderId);
        req.setMemberId(logginedMemberId);
        OrderDetailGetRes result = orderService.detail(req);
        return ResponseEntity.ok(result);
    }
}