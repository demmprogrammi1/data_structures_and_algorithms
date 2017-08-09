
public  class Rectangle extends Figure {
	private double width,length;
	public Rectangle(double wid,double leng) throws MyException {
		if(wid>0&&leng>0) {
		width=wid;
		length=leng;
		} else throw new MyException();
	}
	@Override 
	public double area() {
		return width*length;
	}

}
