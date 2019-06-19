package demo;

import java.util.Arrays;
import java.util.Comparator;

public class Client3 {
	
	public String[] classic(String[] series) {

		Arrays.sort(series);
//		Arrays.sort(series,new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return (o1.length() - o2.length());
//			}
//			
//		});
		
		for(String s:series) {
			System.out.println(s);
		}
		
		return series;
	}

	public String[] lambda(String[] series) {

		Arrays.sort(series,(s1,s2)-> s1.compareTo(s2));

		//Arrays.sort(series);

		for(String s:series) {
			System.out.println(s);
		}
		
		return series;
	}

	public static void main(String[] args) {

		String[] series = {"zero","eight","three","first","second"};
		
		//new Client3().classic(series);
		System.out.println("==========================");
		new Client3().lambda(series);
		
	}
	
}
