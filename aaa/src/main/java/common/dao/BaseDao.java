package common.dao;

import java.sql.Connection;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* @author zpl 
* @version 创建时间：2018年2月26日 下午2:11:44 
* 类说明 
*/
public class BaseDao extends SqlSessionDaoSupport{
	
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    protected <S> S getMapper(Class<S> clazz) {
        return getSqlSession().getMapper(clazz);
    }

    /**
     * 获取connection
     *
     * @return connection
     */
    public Connection getConnection() {
        SqlSessionTemplate st = (SqlSessionTemplate) getSqlSession();
        return SqlSessionUtils.getSqlSession(st.getSqlSessionFactory(), st.getExecutorType(),
                st.getPersistenceExceptionTranslator()).getConnection();
    }
    /**
     * 返回指定类型数据
     *
     * @param method 要执行的mapper中的id
     * @return 指定类型实体
     */
    public <T> T selectObject(String method) {
        return this.getSqlSession().selectOne(method);
    }
    
    public <T> T selectObject(String method, Object entity) {
        return this.getSqlSession().selectOne(method);
    }
    /**
     * 返回指定类型的List集合
     *
     * @param method 要执行的mapper中的id
     * @param entity 指定类型的数据
     * @return list集合
     */
    public <T> List<T> selectList(String method, Object entity) {
        return this.getSqlSession().selectList(method, entity);
    }
    /*
     * insert
     **/
    public <T> int insertObject(String method, Object entity){
    	
    	return this.getSqlSession().insert(method,entity);
    }
}
