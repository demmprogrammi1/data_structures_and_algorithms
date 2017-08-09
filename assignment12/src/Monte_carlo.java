import java.util.*;
import java.io.*;
public class Monte_carlo {
	
	public static ArrayList<Point> arr=new ArrayList<Point>();
	
	public static Point current_point;
	
	public static final int inf=5000000;
	
	public static double max(double a,double b){
		if(a>b) return a;
		return b;
	}

	public static double min(double a,double b) {
		if(a>b) return b;
		return a;
	}
	

	public static boolean intersect(Point a, Point b, Point c, Point d) {
		// We describe the section AB as A+(B-A)*u and CD as C+(D-C)*v
		// then we solve A + (B-A)*u = C + (D-C)*v
		// let's use Kramer's rule to solve the task (Ax = B) were x = (u, v)^T
		// build a matrix for the equation
		double[][] A = new double[2][2];
		A[0][0] = b.getX() - a.getX();
		A[1][0] = b.getY() - a.getY();
		A[0][1] = c.getX() - d.getX();
		A[1][1] = c.getY() - d.getY();
		// calculate determinant
		double det0 = A[0][0] * A[1][1] - A[1][0] * A[0][1];
		// substitute columns and calculate determinants
		double detU = (c.getX() - a.getX()) * A[1][1] - (c.getY() - a.getY()) * A[0][1];
		double detV = A[0][0] * (c.getY() - a.getY()) - A[1][0] * (c.getX() - a.getX());
		// calculate the solution
		// even if det0 == 0 (they are parallel) this will return NaN and comparison will fail -> false
		double u = detU / det0;
		double v = detV / det0;
		return u > 0 && u < 1 && v > 0 && v < 1;
	}

	public static boolean inside_polygon(Point cur) {
		int count=0;
		for(int i=0;i<arr.size()-1;i++)
			if(intersect(cur,new Point(cur.getX()+5,cur.getY()-inf),arr.get(i),arr.get(i+1))) 
				count++;
		if(intersect(cur,new Point(cur.getX()+5,cur.getY()-inf),arr.get(0),arr.get(arr.size()-1))) count++;
		if(count%2==1)
			return true;
		return false;
	}
	
	public static void main(String[] arg) throws Exception {
		Scanner in=new Scanner(new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		double xx,yy,min_x=inf,max_x=-inf,min_y=inf,max_y=-inf;
		in.useLocale(Locale.US);
		while(in.hasNextDouble()) {
		    xx=in.nextDouble();
		    min_x=min(min_x,xx);
		    max_x=max(max_x,xx);
			yy=in.nextDouble();
			min_y=min(min_y,yy);
			max_y=max(max_y,yy);
			arr.add(new Point(xx,yy));
		}
		int inside=0,outside=0;
	    for(int i=0;i<inf;i++) {
			current_point=new Point(min_x+Math.random()*(max_x-min_x),min_y+(max_y-min_y)*Math.random());
			if(inside_polygon(current_point)) {
				//System.out.println("in"+current_point.getX()+" "+current_point.getY());
				inside++;
			}
			else {
		       // System.out.println(current_point.getX()+" "+current_point.getY());
				outside++;
			}
		} 
		double ratio=(double)inside/(inside+outside);
		double ans=ratio*(max_x-min_x)*(max_y-min_y);
		ans=(double)Math.round(ans*100)/100;
		String temp=Double.toString(ans);
		 for(int i=0;i<temp.length();i++)
		    	if(temp.charAt(i)=='.'&&temp.length()-i-1==1)
		    		temp=temp+"0";
	    out.println(temp); 
		out.close();			
	}
}
