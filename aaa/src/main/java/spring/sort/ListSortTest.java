package spring.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest {
	
	static List<NumberHomeVO> list = new ArrayList<>();
	
	private static void mai() {
		
		for(int i = 0; i< 5 ; i ++){
			NumberHomeVO n = new NumberHomeVO();
			n.setValue(i);
			list.add(n);
		}
		Collections.sort(list);
		for(NumberHomeVO n :list){
			System.out.println(n.getValue());
		}
	}
	public static void main(String[] args) {
		mai();
	}

}
