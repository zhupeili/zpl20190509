package src.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @author zpl 
* @version 创建时间：2018年1月23日 下午5:52:59 
* 类说明 
*/
public class TTTTTT {
	
	//public static String time = 0.5;

	public static void main(String[] args) {
		String a = "100%";
		double b = percentToDouble(a);
		System.out.println(b);

	}
    public static void sort(int[] a)
    {
        int temp = 0;
        for (int i = a.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (a[j + 1] > a[j])
                {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for(int i = 0 ; i < a.length ; i ++){
        	
        	 System.out.println("a:"+"("+a.length+")"+i+","+a[i]);
        }
       
    }
    public static void page(int page1,int rows1){
    	List<String> list = new ArrayList<>();
    	List<String> list1 = new ArrayList<>();
    	for(int j = 0; j<36; j++){
    		list.add(String.valueOf(j));
    	}
    	if (list.size() <= rows1) {
    		//return new ResponseVO(res.getStatus(), res.getMessage(), list, (long) list.size());
    		System.out.println(list.size());
    	}
    	int start = (page1 - 1) * rows1;
    	int end = start + rows1;
    	if(end > list.size()){
    		end = list.size();
    	}
    	for (int i = start; i < end; i++) {
    		String rdv = list.get(i);
    		list1.add(rdv);
    	}
    	System.out.println(list1.size());
    }
	//将百分数转换为double类型
	public static double percentToDouble(String percent) {
		NumberFormat nf = NumberFormat.getPercentInstance();// 创建数字化工厂
		double d = 0;
		try {
			Number m = nf.parse(percent);
			if(m.equals(1L)){
				System.out.println("++++++++++++++++++++++");
			}
			d = (Double) m;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-----------------");
			e.printStackTrace();
		}
		return d;
	}

}
