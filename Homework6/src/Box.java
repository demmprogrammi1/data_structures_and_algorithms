
public class Box extends Figure {
	private double heigth,length,width;
	public Box(double h,double l,double w) throws MyException {
		 if(h>0&&l>0&&w>0) {
		heigth=h;
		length=l;
		width=w;
	} else  throw new MyException(); 
	}
	@Override
	public double area() {
		return 2*((heigth+width)*length+width*heigth);
	}
}
