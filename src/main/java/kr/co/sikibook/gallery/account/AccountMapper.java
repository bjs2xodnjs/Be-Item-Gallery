package kr.co.sikibook.gallery.account;

import kr.co.sikibook.gallery.account.model.AccountJoinReq;
import kr.co.sikibook.gallery.account.model.AccountLoginReq;
import kr.co.sikibook.gallery.account.model.AccountLoginRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
     int save (AccountJoinReq req);
     AccountLoginRes findByLoginId(AccountLoginReq req);

}
