package myWorld.service.imp;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myWorld.dao.MyWorldDao;
import myWorld.entity.AreaCodeCityVO;
import myWorld.entity.BaseEntity;
import myWorld.entity.NumberVO;
import myWorld.entity.ResponseVO;
import myWorld.entity.UserVO;
import myWorld.service.MyWorldService;
@Service("myWorldService")
public class MyWorldServiceImp implements MyWorldService{
	@Autowired
	MyWorldDao myWorldDao;

//	@Override
//	public String selectById(String baseEntity) {
//		
//		return myWorldDao.selectById(baseEntity);
//	}
//
//	@Override
//	public List<BaseEntity> selectByName(BaseEntity baseEntity) {
//		return myWorldDao.selectByName(baseEntity);
//	}
//
//	@Override
//	public List<BaseEntity> selectTicket(BaseEntity baseEntity) {
//		return myWorldDao.selectTicket(baseEntity);
//	}
//
//	@Override
//	public List<BaseEntity> selectTicket11(BaseEntity baseEntity) {
//		return myWorldDao.selectTicket11(baseEntity);
//	}
//
	@Override
	public UserVO selectUser(BaseEntity baseEntity) {
		
		return  myWorldDao.selectUser(baseEntity);
	}

	@Override
	public ResponseVO insertUser(BaseEntity baseEntity) {
		Boolean flag = myWorldDao.insertUser(baseEntity);
		if(flag){
			return  new ResponseVO(200,"");
		}else{
			return  new ResponseVO(300,"");
		}
		
	}

	@Override
	public ResponseVO insertAreaCodeCity(BaseEntity baseEntity) {
		Map<String, String> map = new TreeMap<String,String>();
		List<Integer> provCodeList = new ArrayList<Integer>();
		List<Integer> cityCodeList = new ArrayList<Integer>();
		List<Integer> areaCodeList = new ArrayList<Integer>();
		File file = new File("config/areaCodeCity.properties");
		InputStream url1 = MyWorldServiceImp.class.getClassLoader().getResourceAsStream("config/areaCodeCity.properties");

		Properties pro = new Properties();
		try {
			pro.load(new InputStreamReader(url1,"UTF-8"));
			Enumeration<?> propertyNames = pro.propertyNames();
			while(propertyNames.hasMoreElements()){
				String key  = (String) propertyNames.nextElement();
				key.substring(2);
				if(key.substring(2).equalsIgnoreCase("0000")){
					provCodeList.add(Integer.valueOf(key));
					Collections.sort(provCodeList);  
				}
				else if(key.substring(4).equalsIgnoreCase("00")){
					cityCodeList.add(Integer.valueOf(key));
					Collections.sort(cityCodeList);  
				}
				else{
					areaCodeList.add(Integer.valueOf(key));
					Collections.sort(areaCodeList);  
				}
				String value = pro.getProperty(key);
//				System.out.println(key+":"+value);
				map.put(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		for (int i = 0; i < cityCodeList.size(); i++) {
			AreaCodeCityVO areaCodeCity = new AreaCodeCityVO();
			String cityCode = cityCodeList.get(i).toString();
			String cityName = map.get(cityCode);
			areaCodeCity.setCityCode(cityCode);
			areaCodeCity.setCityName(cityName);
			boolean flag = myWorldDao.updateAreaCodeCity(areaCodeCity);
		}
//		for (int i = 0; i < provCodeList.size(); i++) {
//			if(provCodeList.get(i)==110000||
//					provCodeList.get(i)==120000||
//					provCodeList.get(i)==130000||
//					provCodeList.get(i)==310000||
//					provCodeList.get(i)==410000||
//					provCodeList.get(i)==420000||
//					provCodeList.get(i)==460000||
//					provCodeList.get(i)==500000||
//					provCodeList.get(i)==650000){
//				for(int k = 0; k < areaCodeList.size(); k++){
//					if(areaCodeList.get(k).toString().substring(0,2)
//							.equals(provCodeList.get(i).toString().substring(0,2))){
//						String provCode = provCodeList.get(i).toString();
//						String provName = map.get(provCode);
//						String cityCode = areaCodeList.get(k).toString().substring(0,4)+"00";
//						String cityName = "";
//						String areaCode = areaCodeList.get(k).toString();
//						String areaName = map.get(areaCode);
//						AreaCodeCityVO areaCodeCity = new AreaCodeCityVO(provCode, provName, cityCode, cityName, areaCode, areaName);
//						try{
//						boolean flag = myWorldDao.insertAreaCodeCity(areaCodeCity);
//						}catch (Exception e) {
//							e.printStackTrace();
//							return null;
//						}
//					}
//				}
//				
//			}
//			for(int j = 0; j < cityCodeList.size(); j++){
//				if(provCodeList.get(i).toString().substring(0,2)
//						.equals(cityCodeList.get(j).toString().substring(0,2))){
//					for(int k = 0; k < areaCodeList.size(); k++){
//						if(areaCodeList.get(k).toString().substring(0,4)
//								.equals(cityCodeList.get(j).toString().substring(0,4))){
//							String provCode = provCodeList.get(i).toString();
//							String provName = map.get(provCode);
//							String cityCode = cityCodeList.get(j).toString();
//							String cityName = map.get(cityCode);
//							String areaCode = areaCodeList.get(k).toString();
//							String areaName = map.get(areaCode);
//							AreaCodeCityVO areaCodeCity = new AreaCodeCityVO(provCode, provName, cityCode, cityName, areaCode, areaName);
//							try{
//							boolean flag = myWorldDao.insertAreaCodeCity(areaCodeCity);
//							}catch (Exception e) {
//								e.printStackTrace();
//								return null;
//							}
//						}
//					}
//				}
//			}
//			
//		}
		return null;
	}
	public static void main(String[] args) {
//		new MyWorldServiceImp().insertAreaCodeCity(new AreaCodeCityVO());
		String aa = "1234";
		;
		System.out.println(aa.substring(0, aa.length()-1));
	}

	@Override
	public ResponseVO updateNumberCodeCity(BaseEntity baseEntity) {
		Map<String, String> map = new TreeMap<String,String>();
		InputStream url1 = MyWorldServiceImp.class.getClassLoader().getResourceAsStream("config/areaCodeCity.properties");
		Properties pro = new Properties();
		try {
			pro.load(new InputStreamReader(url1,"UTF-8"));
			Enumeration<?> propertyNames = pro.propertyNames();
			while(propertyNames.hasMoreElements()){
				String key  = (String) propertyNames.nextElement();
				String value = pro.getProperty(key).substring(0,pro.getProperty(key).length()-1);
				map.put(value, key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		List<NumberVO> selectNumber = myWorldDao.selectNumber(baseEntity);
		try{
		for(NumberVO num : selectNumber){
			String city_code = map.get(num.getCity_name());
			num.setCity_code(city_code);
			Boolean updateNumber = myWorldDao.updateNumber(num);
			System.out.println(updateNumber);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ResponseVO selectMsisdn(BaseEntity baseEntity) {
		Set<String> set = myWorldDao.selectMsisdn(baseEntity);
		return new ResponseVO(200,"",set);
	}
	
}
