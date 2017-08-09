import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(Strig[] args) throws IOException {
		Scanner in=new Scanner(new FileReader("input.txt")):
		PrintWriter out=new PrintWriter(new FileWriter("out.txt"));
		int[] movex={0,0,1,-1};
		int[] movey={1,-1,0,0};
		int begx,begy,endx,endy;
		char[][] mas=new char[5][5];
		for(int i=0;i<5;i++) {
			String cur=in.nextLine();
		    for(int j=0;j<5;j++) {
		    	if(cur.charAt(j)=='S') {
		    		begx=i;
		    		begy=j;
		    		break;
		    	}
		        if(cur.charAt(j)=='F') {
		        	endx=i;
		        	endy=j;
		        	break;
		        }
				mas[i][j]=cur.charAt(j);
		    }
	     }
		out.print(begx+ " "+begy);
		out.close();
	}
}
