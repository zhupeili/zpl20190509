package myWorld.entity;

public class NumberVO extends BaseEntity{
	private String mobile_no;
	private String operator_name;
	private String prov_name;
	private String city_name;
	private String operator_code;
	private String create_date;
	private String modify_date;
	private String area_code;
	private String prov_code;
	private String city_code;
	
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getOperator_name() {
		return operator_name;
	}
	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}
	public String getProv_name() {
		return prov_name;
	}
	public void setProv_name(String prov_name) {
		this.prov_name = prov_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getOperator_code() {
		return operator_code;
	}
	public void setOperator_code(String operator_code) {
		this.operator_code = operator_code;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	public String getProv_code() {
		return prov_code;
	}
	public void setProv_code(String prov_code) {
		this.prov_code = prov_code;
	}
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	@Override
	public String toString() {
		return "NumberVO [mobile_no=" + mobile_no + ", operator_name=" + operator_name + ", prov_name=" + prov_name
				+ ", city_name=" + city_name + ", operator_code=" + operator_code + ", create_date=" + create_date
				+ ", modify_date=" + modify_date + ", area_code=" + area_code + ", prov_code=" + prov_code
				+ ", city_code=" + city_code + "]";
	}
	
	
	


}
