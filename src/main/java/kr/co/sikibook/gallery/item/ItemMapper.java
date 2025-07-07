package kr.co.sikibook.gallery.item;

import kr.co.sikibook.gallery.item.model.ItemGetRes;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemGetRes> findAllByIdIn(List<Integer> ids);
}
