import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Naive_set {
	public static int max(int a,int b) {
		if(a>b) return a;
		return b;
	}

	public static void main(String[] arg) throws IOException {
		Scanner in=new Scanner(new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		int max_v=0,rt=0,count=0,t=0;
		String temp=in.nextLine();
		if(!temp.trim().isEmpty()) {
		String[] values=temp.split(" ");
		int[] conv_values=new int[values.length];
		for(int i=0;i<values.length;i++) {
			conv_values[i]=Integer.parseInt(values[i]);
			max_v=max(max_v,conv_values[i]);
		} 
		my_Bitset arr=new my_Bitset();
		for(int i=0;i<conv_values.length;i++)
			arr.set(conv_values[i],true); 
		while(in.hasNextInt()) {
			 rt=in.nextInt();
	         if(arr.get(rt))
	        	 out.print("true ");
	         else
	        	 out.print("false ");
		}  }
	else
	{
		while(in.hasNext()) {
		    t=in.nextInt();
			count++;
		}
		for(int i=0;i<count;i++)
			out.print("false ");
	}
		
		out.close();
	}
}
