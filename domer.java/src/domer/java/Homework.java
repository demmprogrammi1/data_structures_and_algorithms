package domer.java;
import java.util.*;
import java.io.*;
public class Homework {
 public static void main(String[] args) throws IOException
 {
	 Scanner in=new Scanner(new BufferedReader(new FileReader("input.txt")));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
	 int a= in.nextInt();
	 out.print(a);
	 out.close(); 
	 
 }
}
