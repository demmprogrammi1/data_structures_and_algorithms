package test;
import java.io.*;
import java.util.*;
public class test {
	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		int n=in.nextInt();
		int m=in.nextInt();
		out.println(n+m);
		out.close();
	}

}
