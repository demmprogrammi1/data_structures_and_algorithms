package winner;

import java.io.*;
import java.util.*;
import java.math.*;
public class J {
	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		int n=in.nextInt();
		int m=in.nextInt();
		out.println(n+m);
		out.close();
	}

}
