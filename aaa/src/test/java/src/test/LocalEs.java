//package src.test;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHits;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.junit.Test;
//
//
//public class LocalEs {
//	
//	
//	@SuppressWarnings("resource")
//	@Test
//	public void test() {
//		String host = "localhost";
//		Integer port = 9300;
////		TransportClient client = null;
////		client = getClient(client);
//	       //创建客户端
//		TransportClient client = null;
//		try {
//			Settings settings = Settings.builder().put("cluster.name", "elasticsearch")
//    				.put("client.transport.sniff",true)
//    				.put("transport.type","netty3")
//    				.put("http.type", "netty3")
//    				.build();
//			client = new PreBuiltTransportClient(settings)
//			.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
//		BoolQueryBuilder qb = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "王五"))// 查询主短
//				;
//		SearchResponse response = client.prepareSearch("company").setTypes("employee")
//				.setQuery(qb).setExplain(false).setSize(1000000).get();
//		SearchHits hits = response.getHits();
//		System.out.println(hits);
//		client.close();
//		
//	}
//	@SuppressWarnings("resource")
//	public static synchronized TransportClient getClient(TransportClient client){
//		Settings setting = Settings.builder().put("cluster.name","elasticsearch")
////											.put("client.transport.sniff",true)
////											.put("transpot.type","netty4")
////											.put("http.type", "netty4")
//				    	    				.build();
//		try {
//			client = new PreBuiltTransportClient(setting)
//					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"),9200));
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
//		return client;
//	}
//}