package spring.sort;

import java.util.List;

public class NumberHomeVO implements Comparable<NumberHomeVO>{
	
	private String msisdn;
	private String homeName;
	private String taskId;
	private String name;
	private int value;
	private String procince;
	private String city;
	private List<NumberHomeVO> batch;	

	public String getProcince() {
		return procince;
	}
	public void setProcince(String procince) {
		this.procince = procince;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<NumberHomeVO> getBatch() {
		return batch;
	}
	public void setBatch(List<NumberHomeVO> batch) {
		this.batch = batch;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getHomeName() {
		return homeName;
	}
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	@Override
	public String toString() {
		return "NumberHomeVO [msisdn=" + msisdn + ", homeName=" + homeName + ", taskId=" + taskId + ", name=" + name
				+ ", value=" + value + ", batch=" + batch + "]";
	}
	@Override
	public int compareTo(NumberHomeVO n) {
		return n.getValue()-this.getValue();
	}
	
}
