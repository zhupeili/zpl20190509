package myWorld.entity;

public class QuickCdrDetailsVO {
	private String userNum;	//	本端号码
	private String relateNum;//	对端号码
	private String cdrType;//	主被叫/主被短（通联类型）
	private String userLacCi;//	本端lac,ci
	private String userLogLat;//	本端经纬度
	private String callTime;//	通话时长
	private String spCode;//	本端运营商
	private String userImsi;//	本端imsi
	private String relateImsi;//对端imsi
	private String userImei;//	本端imei
	private String relateImei;//对端imei
	private String userLocation;//	本端号码通联位置（基站名称）
	private String relateLocation;//对端号码位置
	private String SmsContent;//	短信内容
	private String beginTime;//	通话开始/短信发送时间
	private String endTime;//	通话结束时间
	private String userHomeName;
	private String relateHomeName;//	对端号码归属地

}
