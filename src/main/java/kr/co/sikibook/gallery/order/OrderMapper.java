package kr.co.sikibook.gallery.order;

import kr.co.sikibook.gallery.order.model.OrderPostDto;
import kr.co.sikibook.gallery.order.model.OrderPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int save (OrderPostDto dto);
}
