
public class Section { 
	public Point first,second;
	public Section(Point fir,Point sec) {
	first=fir;
	second=sec;
	}
	public double getK() {
		return (first.getX()-second.getX())/(first.getY()-second.getY());
	}
	public double getB() {
		return first.getY()+getK*first.getX();
		}
}
