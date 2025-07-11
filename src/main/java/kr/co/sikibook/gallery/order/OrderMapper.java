package kr.co.sikibook.gallery.order;

import kr.co.sikibook.gallery.order.model.OrderDetailGetRes;
import kr.co.sikibook.gallery.order.model.OrderGetRes;
import kr.co.sikibook.gallery.order.model.OrderPostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int save(OrderPostDto dto);
    List<OrderGetRes> findAllByMemberIdOrderByIdDesc(int memberId);
    OrderDetailGetRes findByOrderIdAndMemberId(OrderDetailGetReq req);
}
