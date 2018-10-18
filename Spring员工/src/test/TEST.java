package test;

import java.util.Scanner;

public class TEST {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		String b=String.valueOf(a);
		int c=b.length();
	   char[]array1=new char[c];
		char[]array=b.toCharArray();
		if(array[0]=='-') {
	for(int i=1;i<c;i++) {
		array1[i]=array[c-i];
		  
		  
	
			
			
	}
	array1[0]='-';
	
		}
		
		
		else {
			
			for(int i=0;i<c;i++) {
				
				array1[i]=array[c-i-1];
				
			}
			
		}	
		 String str=new String(array1);
		System.err.println(Integer.parseInt(str));	}
	
	


}
	
	
	
	

