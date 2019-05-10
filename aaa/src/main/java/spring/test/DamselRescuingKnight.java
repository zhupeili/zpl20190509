package spring.test;
/** 
* @author zpl 
* @version 创建时间：2018年3月16日 下午3:11:44 
* 类说明 
*/
public class DamselRescuingKnight implements Knight {
	private RescueDamselQuest quest;

	public DamselRescuingKnight() {
		this.quest = new RescueDamselQuest();
	}

	@Override
	public void embarkOnQuest() {
		quest.embarkOnQuest();
		
	}
	
	
	

}
