package kr.co.sikibook.gallery.order;

import kr.co.sikibook.gallery.order.model.OrderItemPostDto;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface OrderItemMapper {
    int save (OrderItemPostDto dto);
}
