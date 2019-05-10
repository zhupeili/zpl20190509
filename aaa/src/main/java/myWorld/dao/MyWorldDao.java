package myWorld.dao;

import java.util.List;
import java.util.Set;

import myWorld.entity.BaseEntity;
import myWorld.entity.NumberVO;
import myWorld.entity.UserVO;
public interface MyWorldDao {
//	public String selectById(String baseEntity);
//	public List<BaseEntity> selectByName(BaseEntity baseEntity);
//	public List<BaseEntity> selectTicket(BaseEntity baseEntity);
//	public List<BaseEntity> selectTicket11(BaseEntity baseEntity);
	public UserVO selectUser(BaseEntity baseEntity);
	public Boolean insertUser(BaseEntity baseEntity);
	public Boolean insertAreaCodeCity(BaseEntity baseEntity);
	public Boolean updateAreaCodeCity(BaseEntity baseEntity);
	public List<NumberVO> selectNumber(BaseEntity baseEntity);
	public Boolean updateNumber(BaseEntity baseEntity);
	public Set<String> selectMsisdn(BaseEntity baseEntity);
}
