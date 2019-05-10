package myWorld.entity;


public class WoodVO extends BaseEntity{
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "WoodVO [userName=" + userName + "]";
	}


	
}
