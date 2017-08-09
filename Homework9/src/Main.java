import java.io.*;
import java.util.*;
import java.lang.*;
import java.nio.*;
public class Main {
	public static void main(String[] args) throws IOException {
		File file=new File("input.bin");
		InputStream stream=new FileInputStream(file);
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		byte[] buffer=new byte[4];
		while(stream.available()>0) {
			stream.read(buffer, 0,4);
     
		int asInt = (buffer[3] & 0xFF) 
	            | ((buffer[2] & 0xFF) << 8) 
	            | ((buffer[1] & 0xFF) << 16) 
	            | ((buffer[0] & 0xFF) << 24);
		
		Float f = Float.intBitsToFloat(asInt);
		out.print(Math.round(f)+" ");
		} 
        out.close();
		}
	}