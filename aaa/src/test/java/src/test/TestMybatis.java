//package src.test;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

//
//public class TestMybatis {
//	public String ChangePassword(String userId,String passWord,HttpServletRequest req ){
//
//        HttpSession session = req.getSession();//获取session存储的值
//		//通过oprate的Update_UserPassword修改密码     最后存入新的密码
//        String userInfo = commDbOpService.oprate("Update_UserPassword", new String[]{passWord,userId});
//        Map<String,Object> userInfoMap = new HashMap<String,Object>();//这个没看懂
//		
//		userInfoMap = JsonUtil.Json2Object(userInfo, userInfoMap);//这个是要和前台页面json交互的值
//      User user=request.getSession().getAttribute("user");//拿到用户当前的账号
//      String id = user.getUserId;
//      user
//      
//      
//      String oldpwd = user.getParameter("oldpwd");//旧密码                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
//        String newpwd = userInfoMap.getParameter("newpwd");//新密码  
//        String confirm = request.getParameter("confirm");//确认新密码  
//         String pwd = userNow.getSuPassword();//得到该客户当前的字符串  
//        String MDoldpwd = md5.getMD5(oldpwd); //这块的md5我没调用 
//        try{                                                                       
//            if(MDoldpwd.equals(pwd)){ //输入的旧密码与原密码一致  
//                if(newpwd.equals(confirm)){//判断输入的两个新密码是否一致  
//                    if(!(md5.getMD5(newpwd).equals(pwd))){//如果新密码与原密码不同，执行更新密码操作  
//                        userNow.setSuPassword(md5.getMD5(newpwd));  
//                        exit(request,                                                                                                                                                                );  
//                    }else if(md5.getMD5(newpwd).equals(pwd)){  
//                        throw new ApplicationException("密码没有改动");  
//                    }  
//                }else{//抛出异常  
//                    throw new ApplicationException("抱歉，密码输入不一致");  
//                }  
//            }else{//抛出异常  
//                throw new ApplicationException("旧密码输入错误");  
//            }  
//        }catch(Exception e){  
//            request.setAttribute("error", e);  
//              
//            request.getRequestDispatcher("/jsps/error.jsp").forward(request, response);  
//              
//}
//}
