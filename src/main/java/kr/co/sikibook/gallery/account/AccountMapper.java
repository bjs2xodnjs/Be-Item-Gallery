package kr.co.sikibook.gallery.account;

import kr.co.sikibook.gallery.account.model.AccountLoginReq;
import kr.co.sikibook.gallery.account.model.AccountLoginRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
     AccountLoginRes finalLoginId(AccountLoginReq req);

}
