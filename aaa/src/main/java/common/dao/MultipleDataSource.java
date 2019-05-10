package common.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/** 
* @author zpl 
* @version 创建时间：2018年2月26日 下午4:22:20 
* Description: 多数据源的数据访问时指定数据源标识
*/
public class MultipleDataSource extends AbstractRoutingDataSource{
	private static ThreadLocal<String> dataSourceKey =new InheritableThreadLocal<String>();

	public static void setDateSourceKey(String dateSource){
		dataSourceKey.set(dateSource);
	}
	
	@Override
	protected Object determineCurrentLookupKey() {
		return dataSourceKey.get();
	}
	

}
