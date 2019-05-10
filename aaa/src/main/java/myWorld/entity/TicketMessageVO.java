package myWorld.entity;

import java.util.List;

/** 
* @author zpl 
* @version 创建时间：2018年3月6日 上午10:47:15 
* 类说明 
*/
public class TicketMessageVO extends BaseEntity{
	private String dest = "";//目的地
	private String endTime = "";//到达时间
	private String msisdn = "";//电话号码
	private String origin = "";//出发地
	private String platform = "";//订票平台
	private String smsContent = "";//短信内容
	private String startTime = "";//出发时间
	private String travelTime = "";//订票时间
	private List<String> msisdns;
	
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		if (dest == null || "null".equals(dest) || "".equals(dest)){
			this.dest = "--";
		}else{
			this.dest = dest;
		}
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		if (endTime == null || "null".equals(endTime) || "".equals(endTime)){
			this.endTime = "--";
		}else{
			this.endTime = endTime;
		}
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		if (msisdn == null || "null".equals(msisdn) || "".equals(msisdn)){
			this.msisdn = "--";
		}else{
			this.msisdn = msisdn;
		}
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		if (origin == null || "null".equals(origin) || "".equals(origin)){
			this.origin = "--";
		}else{
			this.origin = origin;
		}
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		if (platform == null || "null".equals(platform) || "".equals(platform)){
			this.platform = "--";
		}else{
			this.platform = platform;
		}
	}
	public String getSmsContent() {
		return smsContent;
	}
	public void setSmsContent(String smsContent) {
		if (smsContent == null || "null".equals(smsContent) || "".equals(smsContent)){
			this.smsContent = "--";
		}else{
			this.smsContent = smsContent;
		}
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		if (startTime == null || "null".equals(startTime) || "".equals(startTime)){
			this.startTime = "--";
		}else{
			this.startTime = startTime;
		}
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		if (travelTime == null || "null".equals(travelTime) || "".equals(travelTime)){
			this.travelTime = "--";
		}else{
			this.travelTime = travelTime;
		}
	}
	public List<String> getMsisdns() {
		return msisdns;
	}
	public void setMsisdns(List<String> msisdns) {
		this.msisdns = msisdns;
	}
	
	
}
