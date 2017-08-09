
public class Circle  extends Ellipse{
	private double radius;
	public Circle(double rad) throws MyException {
		if(rad>0) {
		super(rad,rad);
		radius=rad;
		} else
			throw new MyException();
	}
	public double area() {
		return PI*radius*radius;
	}

}
