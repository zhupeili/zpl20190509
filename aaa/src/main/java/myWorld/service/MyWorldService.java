package myWorld.service;

import java.util.List;

import myWorld.entity.BaseEntity;
import myWorld.entity.ResponseVO;
import myWorld.entity.UserVO;
public interface MyWorldService {
//	String selectById(String baseEntity);
//	List<BaseEntity> selectByName(BaseEntity baseEntity);
//	List<BaseEntity> selectTicket(BaseEntity baseEntity);
//	List<BaseEntity> selectTicket11(BaseEntity baseEntity);
	UserVO selectUser(BaseEntity baseEntity);
	ResponseVO insertUser(BaseEntity baseEntity);
	ResponseVO insertAreaCodeCity(BaseEntity baseEntity);
	ResponseVO updateNumberCodeCity(BaseEntity baseEntity);
	ResponseVO selectMsisdn(BaseEntity baseEntity);
}
