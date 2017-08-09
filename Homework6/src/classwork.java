import java.util.*;
import java.lang.Object;
import java.io.*;
public class classwork {
	 public static void main(String[] arg) throws IOException {
		Scanner in=new Scanner(new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		double a,b,c;
		in.useLocale(Locale.US);
	   while(in.hasNextLine()) {
	    	String string=in.next();
	    	switch (string) {
	    	case "Box":
	    		a=in.nextDouble();
	    	    b=in.nextDouble();
	    		c=in.nextDouble();
	    	   try { Box box=new Box(a,b,c);
	    		out.println(box.area()); }
	    	   catch (MyException e) {}
	    		break; 
	    	case "Sphere":
	    		a=in.nextDouble();
	    	   try {	Sphere sphere=new Sphere(a);
	    		out.println(sphere.area());
	    	   } 
	    	   catch (MyException e) {
	    	   }
	    		break;
	    	case "Rectangle":
	    		a=in.nextDouble();
	    		b=in.nextDouble();
	    		 try {Rectangle rec=new Rectangle(a,b);
	    		out.println(rec.area()); }
	    		 catch (MyException e) {}
	    		break;
	    	case "Circle":
	    		a=in.nextDouble();
	    		 try { 
	    			 Circle circ=new Circle(a);
	    			 out.println(circ.area()); 
	    		 } 
	    		 catch (MyException e) {}
	    		
	    		break;
	    	case "Ellipse":
	    		a=in.nextDouble();
	    	    b=in.nextDouble();
	    		 try {Ellipse ell=new Ellipse(a,b);
	    		out.println(ell.area()); }
	    		 catch (MyException e) {}
	    		break;
	    	case "Square":
	    		a=in.nextDouble();
	    		 try {Square sq=new Square(a);
	    		out.println(sq.area()); }
	    		 catch (MyException e) {}
	    		break;
	    	} 
	   }
	    out.close();
	 }
}

