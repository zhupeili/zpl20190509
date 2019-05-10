package myWorld.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Zpl_test {
	public static void main(String[] args) {
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("a", "b");
			map.put("c", "a");
			map.put("b", "c");

			// ----------Map遍历开始---------------

			// 增强for循环遍历、使用keySet()遍历
			for (String aa : map.keySet()) {
				map.get(aa);
			}
			// 增强for循环遍历、使用entrySet()遍历
			for (Map.Entry<String, String> entry : map.entrySet()) {
				entry.getKey();
				entry.getValue();
			}

			// 迭代器遍历、使用keySet()遍历
			{
				Iterator<String> it = map.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next();
					String value = map.get(key);
				}
			}
			System.out.println(map.keySet());

			// 迭代器遍历、使用entrySet()遍历
			{
				Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, String> entry = it.next();
					entry.getKey();
					entry.getValue();
				}
			}
		}
		// ---------------------Map遍历结束------------------------
		/*
		 * HashMap、Hashtable、LinkedHashMap排序 注： TreeMap也可以使用此方法进行排序，但是更推荐下面的方法。
		 */
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("a", "b");
			map.put("c", "a");
			map.put("b", "c");
			List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
				@Override
				public int compare(Entry<String, String> mapping1, Entry<String, String> mapping2) {
					return mapping1.getKey().compareTo(mapping2.getKey());
				}
			});
		}
		// TreeMap排序
		// TreeMap默认按key进行升序排序，如果想改变默认的顺序，可以使用比较器:
		{
			Map<String, String> map1 = new TreeMap<String, String>(new Comparator<String>() {
				public int compare(String obj1, String obj2) {
					return obj2.compareTo(obj1);// 降序排序
				}
			});
			map1.put("a", "c");
			map1.put("b", "b");
			map1.put("c", "a");

			for (String key : map1.keySet()) {
				System.out.println(key + " ：" + map1.get(key));
			}
		}
		// 按value排序(通用)
		{
			Map<String, String> map = new TreeMap<String, String>();
			map.put("a", "c");
			map.put("b", "b");
			map.put("c", "a");

			// 通过ArrayList构造函数把map.entrySet()转换成list
			List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
			// 通过比较器实现比较排序
			Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
				public int compare(Map.Entry<String, String> mapping1, Map.Entry<String, String> mapping2) {
					return mapping1.getValue().compareTo(mapping2.getValue());
				}
			});

			for (String key : map.keySet()) {
				System.out.println(key + " ：" + map.get(key));
			}

		}
	}
}
