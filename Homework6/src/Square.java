
public class Square extends Rectangle {
	private double side;

	public Square(double sid) throws MyException {
		if(side>0) {
		super(sid,sid);
		side=sid;
		} else throw new MyException();
	}
	@Override
	public double area() {
		return side*side
	}

}
