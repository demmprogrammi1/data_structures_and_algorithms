
public class Sphere extends Figure {
	private double radius;
	public Sphere(double rad) throws MyException {
		if(rad>0)
		radius=rad;
		else throw new MyException();
	}
	@Override
	public double area() {
		return 4*PI*radius*radius;
	}

}
