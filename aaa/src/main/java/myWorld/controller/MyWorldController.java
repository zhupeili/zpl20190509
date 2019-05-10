package myWorld.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myWorld.dao.MyWorldDao;
import myWorld.entity.NumberVO;
import myWorld.entity.ResponseVO;
import myWorld.service.MyWorldService;

@Controller
@RequestMapping("/myWorld")
@Scope("prototype")
public class MyWorldController {
	@Resource
	MyWorldService myWorldService;
	@Resource
	MyWorldDao myWorldDao;
	
	
	@RequestMapping(value = "/alarmTaskAdd", method = RequestMethod.POST)
	@ResponseBody
	public String start(String ww){
		String www = "111";
//		myWorldService.insertAreaCodeCity(new AreaCodeCityVO());
		myWorldService.updateNumberCodeCity(new NumberVO());
		return www;
	}
	@RequestMapping(value = "/sss", method = RequestMethod.POST)
	@ResponseBody
	public ResponseVO sss(String ww){
		String www = "111";
//		myWorldService.insertAreaCodeCity(new AreaCodeCityVO());
		return myWorldService.selectMsisdn(new NumberVO());
	}
//	@RequestMapping(value = "/alarmTaskQuery", method = RequestMethod.POST)
//	@ResponseBody
//	public List<WoodVO> start1(BaseEntity ww){
//		List<BaseEntity> www = myWorldService.selectByName(ww);
//		return null;
//	}
//	@RequestMapping(value = "/ticketQuery", method = RequestMethod.POST)
//	@ResponseBody
//	public List<TicketMessageVO> ticketQuery(TicketMessageVO ww){
//		TicketMessageVO t = new TicketMessageVO();
//		List<BaseEntity> www = myWorldService.selectTicket(ww);
//		return null;
//	}
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	@ResponseBody
//	public String audit_export_qh(HttpServletResponse response, AuditList_QhVO ww) {
//		//		goalMsisdnVO.setOwner("TEST");
//				Map<String, String> map = new HashMap<>();
//				Map<String, String> map1 = new HashMap<>();
//				try {
//					for(int i=0; i<2; i++){}
//					String fileName = "涓氬姟瀹¤瀵煎嚭";
//					String[] headersChinese = { "浠诲姟鍚嶇О", "寮�濮嬫椂闂�", "缁撴潫鏃堕棿", "浠诲姟鍒涘缓鏃堕棿", "浠诲姟鐘舵��(1鏄湪鎺э紝2涓锛�3杩囨湡)",
//																"浠诲姟绠＄悊鍛�","浠诲姟浣跨敤浜�","浠诲姟鍔熻兘","鐩爣鍙风爜鏁伴噺","鍖哄煙鏁伴噺",};
//					String[] headersEnglish = { "taskName", "beginTime", "endTime", "taskCreateTime", "taskStatus", 
//															"owner","taskUser","taskFunction","taskTargetCount","taskAreaCount"};
//					List<BaseEntity> www = myWorldService.selectTicket(ww);
//					GoalMsisdnVO goalMsisdnVO = new GoalMsisdnVO();
//					goalMsisdnVO.setOwner("TEST");
//					List<BaseEntity> www1 = myWorldService.selectByName(goalMsisdnVO);
//					GoalAreaVO goalAreaVO =new GoalAreaVO();
//					List<BaseEntity> www2 = myWorldService.selectTicket11(goalAreaVO);
//					
////					ResponseVO responseVO = baseDataManageService.selectEntities(goalMsisdnVO);
//					ServletOutputStream out = response.getOutputStream();
////					if (Objects.equals(responseVO.getStatus(), CommonConstants.FLAG_QUERY_SUCCESS)) {
//						response.setContentType("application/vnd.ms-excel;charset=utf-8");
//						response.setHeader("Content-Disposition",
//								"attachment;filename=" + new String("涓氬姟瀹¤.xls".getBytes(), "iso-8859-1"));
//						map.put("sheetTitle", fileName); // 璁剧疆excel sheet鍚嶇О
//						map.put("title", fileName);// 璁剧疆excel 鏍囬
//						List<String> list = new ArrayList<String>();
//						ExportTaskInfo.exportEntities(out, www,www1,www2, map, headersChinese, headersEnglish);
////					}
//					out.flush();
//					out.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				return null;
//			}	
	
}
