package spring.test;

import static org.mockito.Mockito.*;
import org.junit.Test;
/** 
* @author zpl 
* @version 创建时间：2018年3月16日 下午3:48:17 
* 类说明 
*/
public class BraveKnightTest {

	@Test
	public void kightShouldEmbarkOnQuest(){
		Quest mockQuest = mock(Quest.class);
		BraveKnight knight = new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		verify(mockQuest, times(1)).embark();
		System.out.println("sss");
	}
//	public static void main(String[] args) {
//		Quest mockQuest = mock(Quest.class);
//		BraveKnight knight = new BraveKnight(mockQuest);
//		knight.embarkOnQuest();
//		verify(mockQuest, times(1)).embark();
//		System.out.println("sss");
//	}
}
