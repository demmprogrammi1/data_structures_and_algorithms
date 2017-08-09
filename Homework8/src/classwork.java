import java.util.*;
import java.io.*;

public class classwork {
	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner (new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		in.useLocale(Locale.US);
		double[] d=new double[4];
		double[] d2=new double[4];
	     String lin=in.nextLine();
	     String[] sp=lin.split(" ");

	   try {  for(int i=0;i<4;i++) if(isDouble(sp[i])&&sp.length==4) d[i]=Double.parseDouble(sp[i]); else throw new IException();	}
	   catch (IException ex) { out.write("INPUT ERROR"); }
	   try { if(in.hasNextLine()) {String lin2=in.nextLine();
	     String[] sp2=lin2.split(" "); for(int i=0;i<4;i++) if(isDouble(sp2[i])&&sp2.length==4) d2[i]=Double.parseDouble(sp2[i]); else throw new IException(); } else throw new IException();	}
	     catch (Exception ex) { out.write("INPUT ERROR"); }
		Point point1=new Point(d[0],d[1]);
		Point point2=new Point(d[2],d[3]); 
		Point point3=new Point(d2[0],d2[1]);
		Point point4=new Point(d2[2],d2[3]);
		Section sec1=new Section(point1,point2); 
		 Section sec2=new Section(point3,point4);
	   try {  if(point1.equals(point2)||point3.equals(point4)) throw new IException();  
		 if(sec1.getK()==(sec2.getK())&&sec1.getB()==sec2.getB()) throw new IException(); }
	   catch (IException ew) { out.write("dege"); }
	   
				 out.close();
	}
	 static  boolean isDouble(String str) {
	        try {
	            Double.parseDouble(str);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
	 /*public static boolean isIntersect(Section s1,Section s2) {
		double k1=s1.getV();
		double k2=s2.getV();
		
	} */

}
