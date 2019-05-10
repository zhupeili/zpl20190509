package myWorld.dao.imp;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import common.dao.BaseDao;
import common.dao.MultipleDataSource;
import myWorld.dao.MyWorldDao;
import myWorld.entity.BaseEntity;
import myWorld.entity.NumberVO;
import myWorld.entity.UserVO;

/** 
* @author zpl 
* @version 11:35:14 
* 
*/
@Repository
public class MyWorldDaoImp extends BaseDao implements MyWorldDao{


//	@Override
//	public List<BaseEntity> selectByName(BaseEntity baseEntity) {
//		MultipleDataSource.setDateSourceKey("ds");
//        String mapperName = "MyWorldDao";
//		return this.selectList("MyWorld."+mapperName+"selectByName", baseEntity);
//	}
//
//	@Override
//	public String selectById(String baseEntity) {
//		
//		return this.selectObject(baseEntity);
//	}
//
//	@Override
//	public List<BaseEntity> selectTicket(BaseEntity baseEntity) {
//		MultipleDataSource.setDateSourceKey("ds");
//        String mapperName = "MyWorldDao";
//		return this.selectList("MyWorld."+mapperName+"selectTicket", baseEntity);
//	}
//
//	@Override
//	public List<BaseEntity> selectTicket11(BaseEntity baseEntity) {
//		MultipleDataSource.setDateSourceKey("ds");
//        String mapperName = "MyWorldDao";
//		return this.selectList("MyWorld."+mapperName+"selectTicket11", baseEntity);
//	}
//
	@Override
	public UserVO selectUser(BaseEntity baseEntity) {
		MultipleDataSource.setDateSourceKey("ds");
//        String mapperName = "MyWorldDao";
        String mapperName = "UserDao";
//		return this.selectObject("MyWorld."+mapperName+"selectUser", baseEntity);
		return null;
	}

	@Override
	public Boolean insertUser(BaseEntity baseEntity) {
		MultipleDataSource.setDateSourceKey("ds");
        String mapperName = "MyWorldDao";
        return this.insertObject("MyWorld."+mapperName+"insertUser", baseEntity)>0;
	}

	@Override
	public Boolean insertAreaCodeCity(BaseEntity baseEntity) {
		MultipleDataSource.setDateSourceKey("ds");
        String mapperName = "MyWorldDao";
        return this.insertObject("MyWorld."+"MyWorldDao"+"insertAreaCodeCity", baseEntity)>0;
	}

	@Override
	public Boolean updateAreaCodeCity(BaseEntity baseEntity) {
		MultipleDataSource.setDateSourceKey("ds");
        String mapperName = "MyWorldDao";
        return this.insertObject("MyWorld."+"MyWorldDao"+"updateAreaCodeCity", baseEntity)>0;
	}

	@Override
	public List<NumberVO> selectNumber(BaseEntity baseEntity) {
		MultipleDataSource.setDateSourceKey("ds");
        String mapperName = "MyWorldDao";
        return this.selectObject("MyWorld."+"MyWorldDao"+"selectNumber", baseEntity);
	}

	@Override
	public Boolean updateNumber(BaseEntity baseEntity) {
		MultipleDataSource.setDateSourceKey("ds");
        String mapperName = "MyWorldDao";
        return this.insertObject("MyWorld."+"MyWorldDao"+"updateNumber", baseEntity)>0;
	}

	@Override
	public Set<String> selectMsisdn(BaseEntity baseEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
