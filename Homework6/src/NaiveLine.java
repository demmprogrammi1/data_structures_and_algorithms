import java.awt.Graphics;
import java.lang.Object;
public class NaiveLine extends Figure{
private int x1,y1,x2,y2;
public NaiveLine(int x1,int y1,int x2,int y2) {
	super();
	this.x1=x1;
	this.y1=y1;
	this.x2=x2;
	this.y2=y2;
}
public NaiveLine() {
	super();
}
public void drawLine() {
	Graphics g=new Graphics();
	g.drawLine(x1, y2, x2, y2);
	
}
@Override
public double area() {
}
}
