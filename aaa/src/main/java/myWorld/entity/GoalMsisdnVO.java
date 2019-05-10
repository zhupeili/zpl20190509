package myWorld.entity;

import java.util.List;


/**
 * 目标号码管理实体类
 */
public class GoalMsisdnVO extends BaseEntity {
    private Long resourceId;//目标号码id
    private Integer lbs;//是否lbs监控
    private String imei;//机身码
    private String imsi;//卡号
    private String name;//姓名
    private String endTime;//结束时间
    private String msisdn;//手机号
    private String lbsName;
    private Integer status = 1;//是否启用
   // private String goalStatusName;
    private String createTime;//目标录入时间
    private String owner;//目标所有者
    private List<GoalMsisdnVO> batch;//批量添加
    private Integer approverStatus ;
    private String orgId; //机构id
    private Integer numType;//号码类型，0国内，1国外
    private String[] flag;
    private String flagIds;
    private String flagNames;

	
	public String getFlagNames() {
		return flagNames;
	}

	public void setFlagNames(String flagNames) {
		this.flagNames = flagNames;
	}

	public String[] getFlag() {
		return flag;
	}

	public void setFlag(String[] flag) {
		this.flag = flag;
	}

	public String getFlagIds() {
		return flagIds;
	}

	public void setFlagIds(String flagIds) {
		this.flagIds = flagIds;
	}

	public Integer getNumType() {
		return numType;
	}

	public void setNumType(Integer numType) {
		this.numType = numType;
	}

	public Integer getApproverStatus() {
		return approverStatus;
	}

	public void setApproverStatus(Integer approverStatus) {
		this.approverStatus = approverStatus;
	}

	public GoalMsisdnVO() {
        super();
    }

    public GoalMsisdnVO(Long resourceId) {
        super();
        this.resourceId=resourceId;
    }

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getLbs() {
		return lbs;
	}

	public void setLbs(Integer lbs) {
		this.lbs = lbs;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<GoalMsisdnVO> getBatch() {
		return batch;
	}

	public void setBatch(List<GoalMsisdnVO> batch) {
		this.batch = batch;
	}

	public String getLbsName() {
		return lbsName;
	}

	public void setLbsName(String lbsName) {
		this.lbsName = lbsName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	

   
}
