package myWorld.entity;

import java.util.List;


public class GoalAreaVO extends BaseEntity {
	private Long resourceId;//区域基本信息id
	private String areaName;//区域名称
	private String owner;//区域所有者
	private String areaSourceType;//区域来源方式
	private Long systemId;//系统区域id
	private String taskBaseId;//任务Id 
	private Long[] resourceIds;//系统区域id
	private Double acreage;//区域面积
	private String orgId;//机构Id
	private String operateTime;
	private List<GoalAreaVO> batch;
	private int status;        //表示字段
	 private int approverStatus ;
	 
	 
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getApproverStatus() {
		return approverStatus;
	}

	public void setApproverStatus(int approverStatus) {
		this.approverStatus = approverStatus;
	}

	public GoalAreaVO() {
		super();
	}

	public GoalAreaVO(Long resourceId) {
		super();
		this.resourceId = resourceId;
	}
	
	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAreaSourceType() {
		return areaSourceType;
	}

	public void setAreaSourceType(String areaSourceType) {
		this.areaSourceType = areaSourceType;
	}

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getTaskBaseId() {
		return taskBaseId;
	}

	public void setTaskBaseId(String taskBaseId) {
		this.taskBaseId = taskBaseId;
	}
	
	public Long[] getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(Long[] resourceIds) {
		this.resourceIds = resourceIds;
	}


	public List<GoalAreaVO> getBatch() {
		return batch;
	}

	public void setBatch(List<GoalAreaVO> batch) {
		this.batch = batch;
	}
	

	
	public Double getAcreage() {
		return acreage;
	}

	public void setAcreage(Double acreage) {
		this.acreage = acreage;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	
	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}


	

}
