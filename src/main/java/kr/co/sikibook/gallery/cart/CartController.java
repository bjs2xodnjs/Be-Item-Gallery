package kr.co.sikibook.gallery.cart;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sikibook.gallery.account.etc.AccountConstants;
import kr.co.sikibook.gallery.cart.model.CartDeleteReq;
import kr.co.sikibook.gallery.cart.model.CartGetRes;
import kr.co.sikibook.gallery.cart.model.CartPostReq;
import kr.co.sikibook.gallery.common.util.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor

public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<?> save(HttpServletRequest httpReq, @RequestBody CartPostReq req) {
        log.info("req: {}", req);
        int logginedMemberId = (int) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        req.setMemberId(logginedMemberId);
        int result = cartService.save(req);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<?> getCart(HttpServletRequest httpReq) {
        int logginedIdMemberId = (int) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        List<CartGetRes> result = cartService.findAll(logginedIdMemberId);
        return ResponseEntity.ok(result);

    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<?> deleteMemberItem(HttpServletRequest httpReq, @PathVariable int cartId) {
        int logginedIdMemberId = (int) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        CartDeleteReq req = new CartDeleteReq(cartId, logginedIdMemberId);
        int result = cartService.remove(req);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMemberCart(HttpServletRequest httpReq) {
        int logginedMemberId = (int) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        int result = cartService.removeAll(logginedMemberId);
        return ResponseEntity.ok(result);
    }
}