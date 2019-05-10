package myWorld.entity;

public class AreaCodeCityVO extends BaseEntity{
	private String provCode;
	private String provName;
	private String cityCode;
	private String cityName;
	private String areaCode;
	private String areaName;
	
	
	
	public AreaCodeCityVO() {
		super();
	}
	public AreaCodeCityVO(String provCode, String provName, String cityCode, String cityName, String areaCode,
			String areaName) {
		super();
		this.provCode = provCode;
		this.provName = provName;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.areaCode = areaCode;
		this.areaName = areaName;
	}
	public String getProvCode() {
		return provCode;
	}
	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}
	public String getProvName() {
		return provName;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
}
