package eiffel4;

import java.io.*;
import java.util.*;

public class Dem {
	public static void write_date(int a,PrintWriter out) {
		String s="",buf="",buf2="";
		int k=1;
		for(int i=1;i<=a;i++) {
			for(int j=1;j<=(i+1)/2;j++) { 
			if(j==(i+1)/2) buf+=String.valueOf(k);
			else buf+=String.valueOf(k)+" ";
			if(buf2.isEmpty()) buf2=String.valueOf(k);
			else buf2=String.valueOf(k)+" "+buf2;
			k++;
		}
			s+=buf+spaces(2*(getLength(a)-buf.length())+1)+buf2;
	        out.println(s);
	        s="";
			buf="";
			buf2="";
		}
		out.close();
					
	}
	
	public static int getLength(int a) {
		int s=0,b=0;
		for(int i=1;i<a;i++) {
		for(int j=1;j<=(i+1)/2;j++) s++;
		}
		s++;
		for(int i=1;i<=(a+1)/2;i++) {
		b+=String.valueOf(s).length();
		}
		b+=(a+1)/2-1;
		return b;
	}
	
	public static String spaces(int a) {
		String s="";
		for(int i=0;i<a;i++)
			s+=" ";
		return s;
	}
	public static int read_date() throws IOException {
		Scanner in=new Scanner(new FileReader("input.txt"));
		return in.nextInt();
		
	}
	
	public static void main(String[] arg) throws IOException {
        PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		int a=read_date();
		if(a>=0&&a<1000)
		write_date(a,out);
		out.close();
	//	keyboardModule.update();
	}
	
}
