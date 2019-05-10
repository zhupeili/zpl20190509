package spring.test;
/** 
* @author zpl 
* @version 创建时间：2018年3月16日 下午3:44:18 
* 类说明 
*/
public class BraveKnight implements Knight{
	private Quest quest;
	
	public BraveKnight(Quest quest) {
		this.quest = quest;
	}

	@Override
	public void embarkOnQuest() {
		quest.embark();
		
	}

}
