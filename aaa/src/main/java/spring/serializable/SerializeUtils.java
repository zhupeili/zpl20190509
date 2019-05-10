package spring.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**   
* @Title: SerializeUtils.java 
* @Package com.chanct.situation.utils 
* @Description: TODO 
* @company 长安通信科技有限责任公司
* @author 葛旭东   
* @date 2017年10月20日 下午7:05:05 
* @version V1.0   
*/
public class SerializeUtils {
	/**
	 * 将对象序列化成二进制
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static byte[] serializeObject(Object object) throws Exception {
		if(object == null){
			return null;
		}
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(object);
		byte[] bytes = byteOut.toByteArray();
		return bytes;
	}
	
	/**
	 * 将二进制反序列化成对象
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static Object deserializeObject(byte[] bytes) throws Exception {
		Object object = null;
		if(bytes == null){
			return object;
		}
		ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
		ObjectInputStream in = new ObjectInputStream(byteIn);
		object = in.readObject();
		return object;
	}
	
	/**
	 * 将二进制反序列化成对象
	 * @param bytes
	 * @param cla
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <E> E deserializeObject_(byte[] bytes,Class<E> cla) throws Exception {
		return (E)deserializeObject(bytes);
	}
	
	
	
	public static void main(String[] args) throws Exception {
//		byte[] bytes = serializeObject(new AreaAlarmState());
//		System.out.println(bytes);
//		AreaAlarmState a = (AreaAlarmState)deserializeObject(bytes);
//		System.out.println(a.stateTuple);
	}
}
