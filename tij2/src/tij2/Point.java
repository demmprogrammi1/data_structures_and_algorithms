package tij2;

public class Point {
private int x,y;
static int g;
public Point() {}
public Point(int x,int y) {
	this.x=x;
	this.y=y;
} 
public Point(int x) {
	this(x,x);
}
public  double distance() {
	return Math.sqrt(x*x+y*y);
}
public boolean check() {
	if(x*y>0) return true;
	return false;
}
protected void finalize() {
 System.out.print("finalize method is called");	
}
}
