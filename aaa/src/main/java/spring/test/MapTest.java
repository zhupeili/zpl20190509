package spring.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import net.sf.json.JSONArray;
import spring.serializable.SerializableTest;
import spring.serializable.SerializeUtils;

public class MapTest {
	
	Map<String,String> map = new HashMap<>();
	Map<String,String> map2 = new LinkedHashMap<>();
	Map<String,String> map3 = new HashedMap();
	Map<String,String> map4 = null;

	
	public static void main(String[] args) {
		
		List<SerializableTest> list = new ArrayList<>();
		boolean add = list.add(new SerializableTest("aaa",1));
		byte[] serializeObject = null;
		try {
			serializeObject = SerializeUtils.serializeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Object deserializeObject = SerializeUtils.deserializeObject(serializeObject);
			JSONArray js = new JSONArray();
			js.fromObject(deserializeObject);
			System.out.println(js.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
