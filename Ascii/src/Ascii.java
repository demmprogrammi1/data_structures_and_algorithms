import java.io.*;
import java.util.*;
public class Ascii {
    private static String readString() {
    	 try  {
         Scanner sc = new Scanner(new FileReader("input.txt")); 
         String s; //declaration
         String xs="";
         while (sc.hasNextLine()) {
         	s=sc.nextLine();
         	xs +=s + "\n";
         }
         return xs;
    	 }
    	 catch (IOException ex) { return null;
    	 }
    }
    private static void writeString(String s) {
        try  { 
        	//Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "ascii"));
        	PrintWriter writer=new PrintWriter(new FileWriter("output.txt"));
        		 writer.write(s); 
        		 writer.close();
        		 }
        catch (IOException ex) {
        }
    }
public static void main(String[] args) {
        String str=readString();           
        String result = "";
        int x=str.length();
        int c=0;
        while (c < x) {
            char ch = str.charAt(c);
           switch (ch) {
           case 'o':
           case 'O':
           case '.':
           case '`':
           case '\'':
                result+='X';
           break;
           case ' ': result+=' ';
           break;
            default :
            	result+="\n";
            break;
           }
           c++;
        }
        writeString(result);
       
    
    }
}
