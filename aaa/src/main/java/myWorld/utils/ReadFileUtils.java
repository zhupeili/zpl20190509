package myWorld.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeMap;

//import org.apache.log4j.Logger;

import myWorld.entity.AreaCodeCityVO;

public class ReadFileUtils {
	
//	private static Logger log = Logger.getLogger(ReadFileUtils.class);
	/**
	 * �Ӹ�Ŀ¼��ȡ�ļ�
	 */
	public static void readTxtFromRoot(){
		String enCoding = "UTF-8";
		File file = new File("config/nationcode_new.txt");
		//�ж��ļ��Ƿ����
		if(file.isFile()&&file.exists()){
			try {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file),enCoding);
				BufferedReader br = new BufferedReader(read);
				String lineTxt = null;
				while((lineTxt = br.readLine()) != null){
					System.out.println(lineTxt);
				}
				read.close();
			} catch (Exception e) {
				e.printStackTrace();
//				log.info(e);
			} 
		}
		
	}
	/**
	 * ��src/main/resources��TXT�ļ�
	 */
	public static void readTxtFromResources(){
		String enCoding = "UTF-8";
		InputStream url = ReadFileUtils.class.getClassLoader().getResourceAsStream("config/nationcode_new.txt");
		InputStream url1 = ReadFileUtils.class.getClassLoader().getResourceAsStream("config/config.properties");
		try {
			InputStreamReader read = new InputStreamReader(url1,enCoding);
			BufferedReader br = new BufferedReader(read);
			char[] cubf = new char[1];
			cubf[0] = 'a';
			int bb = br.read(cubf);
			System.out.println(bb);
			String lineText = "";
			while((lineText = br.readLine()) != null){
				System.out.println(lineText);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//�ж��ļ��Ƿ����
			try {
				InputStreamReader read1 = new InputStreamReader(url,enCoding);
				BufferedReader br = new BufferedReader(read1);
				String lineTxt = null;
				while((lineTxt = br.readLine()) != null){
					System.out.println(lineTxt);
				}
				read1.close();
			} catch (Exception e) {
				e.printStackTrace();
//				log.info(e);
			} 
		}
	/**
	 * ��ȡ��Ŀ¼��properties�ļ�
	 * ��ȡ/src/main/resources��properties�ļ�
	 */
	public static void readProperties(){
		File file = new File("config/config.properties");
		InputStream url = ReadFileUtils.class.getClassLoader().getResourceAsStream("config/config.properties");
		Properties pro = new Properties();
		try {
			pro.load(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			System.out.println(pro.getProperty("es.ip"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			pro.load(new InputStreamReader(url,"UTF-8"));
			Enumeration<?> propertyNames = pro.propertyNames();
			while(propertyNames.hasMoreElements()){
				String key  = (String) propertyNames.nextElement();
				String value = pro.getProperty(key);
				System.out.println(key+":"+value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		readTxtFromRoot();
//		readTxtFromResources();
//		readProperties();
//		map();
		String aa ="1234";
		System.out.println(aa.substring(0, 2));
	}
	public static Map<String, String> readProperties1(){
		Map<String, String> map = new TreeMap<String,String>();
		List<Integer> provCodeList = new ArrayList<Integer>();
		List<Integer> cityCodeList = new ArrayList<Integer>();
		List<Integer> areaCodeList = new ArrayList<Integer>();
		File file = new File("config/areaCodeCity.properties");
		Properties pro = new Properties();
		try {
			pro.load(new InputStreamReader(new FileInputStream(file),"UTF-8"));
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
		for (int i = 0; i < provCodeList.size(); i++) {
			for(int j = 0; j < cityCodeList.size(); j++){
				if(provCodeList.get(i).toString().substring(0,2)
						.equals(cityCodeList.get(j).toString().substring(0,2))){
					for(int k = 0; k < areaCodeList.size(); k++){
						if(areaCodeList.get(k).toString().substring(0,4)
								.equals(cityCodeList.get(i).toString().substring(0,4))){
							String provCode = provCodeList.get(i).toString();
							String provName = map.get(provCode);
							String cityCode = cityCodeList.get(j).toString();
							String cityName = map.get(cityCode);
							String areaCode = areaCodeList.get(k).toString();
							String areaName = map.get(areaCode);
							AreaCodeCityVO areaCodeCity = new AreaCodeCityVO(provCode, provName, cityCode, cityName, areaCode, areaName);
							
						}
					}
				}
			}
			
		}
		return map;
	}
	public static void map(){
		Map<String, String> map = readProperties1();
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+":"+value);
		}
	}

}
