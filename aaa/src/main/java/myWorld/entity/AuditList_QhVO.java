package myWorld.entity;

import java.util.List;


/** 
* @author zpl 
* @version 创建时间：2018年4月8日 下午2:38:22 
* 类说明 
*/
public class AuditList_QhVO extends BaseEntity{
	private Long   taskBaseId;//任务主键
    private String owner;   //任务创建者
    private String taskName;//任务名称
    private String beginTime;//开始时间
    private String endTime; //结束时间
    private String taskStatus;//任务状态
    private String stopTime;//终止时间
    private int    taskTargetCount; //任务目标人数
    private int    taskAreaCount;//任务区域个数
    private String taskUser;//任务使用者
    private String isAdd;//是否追加
    private int    approverStatus;//审批状态
    private String greenChannel; //是否是绿色通道
    private String orgId;  //机构id
    private String taskCreateTime; //任务创建时间
    private String approver; //审批人
    
    
    
	public String getTaskCreateTime() {
		return taskCreateTime;
	}
	public void setTaskCreateTime(String taskCreateTime) {
		this.taskCreateTime = taskCreateTime;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getIsAdd() {
		return isAdd;
	}
	public void setIsAdd(String isAdd) {
		this.isAdd = isAdd;
	}
	public String getGreenChannel() {
		return greenChannel;
	}
	public void setGreenChannel(String greenChannel) {
		this.greenChannel = greenChannel;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public Long getTaskBaseId() {
		return taskBaseId;
	}
	public void setTaskBaseId(Long taskBaseId) {
		this.taskBaseId = taskBaseId;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public int getTaskTargetCount() {
		return taskTargetCount;
	}
	public void setTaskTargetCount(int taskTargetCount) {
		this.taskTargetCount = taskTargetCount;
	}
	public int getTaskAreaCount() {
		return taskAreaCount;
	}
	public void setTaskAreaCount(int taskAreaCount) {
		this.taskAreaCount = taskAreaCount;
	}
	public String getTaskUser() {
		return taskUser;
	}
	public void setTaskUser(String taskUser) {
		this.taskUser = taskUser;
	}
	public int getApproverStatus() {
		return approverStatus;
	}
	public void setApproverStatus(int approverStatus) {
		this.approverStatus = approverStatus;
	}
    
    

}
