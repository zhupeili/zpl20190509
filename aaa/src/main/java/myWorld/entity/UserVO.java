package myWorld.entity;
/** 
* @author zpl 
* @version 创建时间：2018年5月8日 下午3:36:04 
* 类说明 
*/
public class UserVO extends BaseEntity{
	
	private String id;
	private String userCount;
	private String realName;
	private String age;
	private String qq;
	private String e_mail;
	private String pwd;
	private String sex;
	private String mobilePhone;
	private String createTime;
	
	
	
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getUserCount() {
		return userCount;
	}
	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userCount=" + userCount + ", realName=" + realName + ", age=" + age + ", qq="
				+ qq + ", e_mail=" + e_mail + ", pwd=" + pwd + ", sex=" + sex + "]";
	}

	
	 

}
