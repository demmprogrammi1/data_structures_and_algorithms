
import java.util.*;
import java.io.*;
public class clas {
	public static void main(String[] arg) throws IOException {
	File file=new File("input.bin");
	InputStream stream=new FileInputStream(file);
	byte[] buffer=new byte((int)file.length());
	int bytesRead=stream.read(buffer,0,buffer.length);
	
	Scanner in=new Scanner(new FileReader("input.txt"));
	PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
	String ch=in.nextLine();
	int max=0;
	String string=in.nextLine();
	String[] spl=string.split(ch);
	String curmax="";
	for(int i=0;i<spl.length;i++)
		if(spl[i].length()>max) { 
			max=spl[i].length();
			curmax=spl[i];
		}
    out.write(curmax);
	out.close();
	}
}
