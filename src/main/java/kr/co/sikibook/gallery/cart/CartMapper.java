package kr.co.sikibook.gallery.cart;

import kr.co.sikibook.gallery.cart.model.CartDeleteReq;
import kr.co.sikibook.gallery.cart.model.CartGetRes;
import kr.co.sikibook.gallery.cart.model.CartPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    int save(CartPostReq req);
    List<CartGetRes> findAllWithItemById(int memberId);
    int deleteByCartIdAndMemberId(CartDeleteReq req);
    int deleteByMemberId(int memberId);

}
