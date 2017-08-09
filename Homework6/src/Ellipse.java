
public class Ellipse extends Figure {
	 private double radius1,radius2;
	 public Ellipse(double r1,double r2) throws MyException {
		 if(r1>0&&r2>0) {
			 super();
		 radius1=r1;
		 radius2=r2;
		 } else throw new MyException();
	 }
	 @Override
	 public double area() {
		 return PI*radius1*radius2;
	 }
}
