package spring.test;
/** 
* @author zpl 
* @version 创建时间：2018年3月16日 下午3:16:26 
* 类说明 
*/
public class RescueDamselQuest implements Quest{

	public void embarkOnQuest(){
		System.out.println("营救任务！");
	}

	@Override
	public void embark() {
		System.out.println("任务！");
		
	}

}
