import java.util.Scanner;

public class Reader{
	private Scanner in;
	try {
	  in=new Scanner(new FileReader("input.txt"));   
	}
	catch (IOexception e) {}
	public double nextD() throws IOException {
		try {double d=in.nextDouble(); }
		catch(IOException e) { 
	}
}
