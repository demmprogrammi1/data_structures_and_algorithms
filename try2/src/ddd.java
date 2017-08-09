import java.awt.Point;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;
public class ddd {
	public static char[][] field=new char[7][7];
	public static int[] movex={0,1,-1,0};
	public static int[] movey={1,0,0,-1};
	public static Point begin=new Point(0,0);
	public static Stack<Point> points=new Stack<Point>();
	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		for(int i=0;i<7;i++)
		{
			field[0][i]='1';
			field[6][i]='1';
			field[i][0]='1';
			field[i][6]='1';
		}
		for(int i=1;i<6;i++) {
			String buf=in.nextLine();
			for(int j=1;j<6;j++) {
             field[i][j]=buf.charAt(j-1);
             if(buf.charAt(j-1)=='S')
            	 begin=new Point(i,j);
			}
	}
		points.add(begin);
		boolean flag=true;
		int k=15;
		while(!points.isEmpty()&&flag) {
			Point p=points.peek();
			k--;
			switch(is_leaf(p)) {
			case 3 :
			flag=false;
			break;
			case 2 : points.add(choose(p));
			break;
			case 1 :
			field[p.x][p.y]='1';
			points.pop();
			break;
			default:
				out.print("NO WAY");
				out.close();
				System.exit(0);
				break;
			}
		}
		//begin=new Point(3,5);
		//out.print(choose(begin).x);
		//out.print(choose(begin).y);
		Stack<Point> buffer=new Stack<Point>();
		while(!points.isEmpty()) {
			buffer.add(points.pop());
		}
		while(!buffer.isEmpty()) {
			char buf=(char)(buffer.peek().x+'A'-1);
			out.print(buf);
			out.print(buffer.peek().y);
			out.print(" ");
			buffer.pop();
		} 
		out.close();

	}
	public static int is_leaf(Point p) {
        int count=0;
 		for(int i=0;i<4;i++)
			if(field[p.x+movex[i]][p.y+movey[i]]!='1') {
				if(field[p.x+movex[i]][p.y+movey[i]]=='F') {
					points.add(new Point(p.x+movex[i],p.y+movey[i]));
					return 3;
				}
				else count++;
			}
		if(count>1||(count==1&&p.x==begin.x&&p.y==begin.y))
			return 2;
		if(count==1)
			return 1;
		return 0;
	}
	public static Point choose(Point p) {
		for(int i=0;i<4;i++)
			if(field[p.x+movex[i]][p.y+movey[i]]!='1') {
				if(points.size()>=2&&points.elementAt(points.size()-2).x==p.x+movex[i]&&points.elementAt(points.size()-2).y==p.y+movey[i]) {} else
						return new Point(p.x+movex[i],p.y+movey[i]); }
		return null;

	}
}
