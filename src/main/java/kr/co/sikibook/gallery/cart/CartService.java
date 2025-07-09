package kr.co.sikibook.gallery.cart;

import kr.co.sikibook.gallery.cart.model.CartDeleteReq;
import kr.co.sikibook.gallery.cart.model.CartGetRes;
import kr.co.sikibook.gallery.cart.model.CartPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartService {
    private final CartMapper cartMapper;

    public int save(CartPostReq req) {
        return cartMapper.save(req);
    }
    public List<CartGetRes> findAll(int memberId) {
        return cartMapper.findAllWithItemById(memberId);
    }
    public int remove(CartDeleteReq req) {
        return cartMapper.deleteByMemberIdAndItemId(req);
    }
}
