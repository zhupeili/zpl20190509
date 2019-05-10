//package myWorld.utils;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Test {
//	
//	
//	public void sss(){
//		LoadClient client=new LoadClient(String confFile); //使用配置文件打开一个加载客户端对象 
//		Map<String, Object> from_detil=new HashMap<>();//构造数据 
//		 from_detil.put("name","pulu"); 
//		 from_detil.put("age",18); 
//		 Map<String, Object> to_detil=new HashMap<>();//构造数据 
//		 to_detil.put("name", "liuchang"); 
//		 to_detil.put("age",25); 
//		 Map<String, Object> relation=new HashMap<>();//构造数据 
//		 relation.put("reason", "colleague"); 
//		 relation.put("since", "2016-08-21"); 
//		PieceOfData data=new PieceOfData("graph_name");//指定数据所属图并初始化
//		 data.setPoint("uid", "112", "PERSON", from_detil);//添加第一个点的信息 
//		 data.setAnotherPoint("uid", "116", "PERSON", to_detil);//添加第二个点的信息 
//		 data.addRelation("friend", relation);//添加边的信息 
//		client.put(data);//将数据放入客户端缓存 
//		client.commit(); //批量提交客户端缓存中的数据 
//	}
//	
//
//}
