import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] arg) throws IOexception {
Scanner in=new Scanner(new FileReader("input.txt"));
PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
int a=in.nextInt();
out.print(a);
out.close();
	}
}
