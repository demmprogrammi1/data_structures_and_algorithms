import java.io.*;
import java.util.*;

public class Prog {
	
	public static void main(String[] arg) throws IOException {
          Scanner in=new Scanner(new FileReader("input.txt"));
          PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
          int seed=in.nextInt();
          MyRandom rand=new MyRandom(seed);
          AVLtree tree=new AVLtree();
          int counter=0;
          double numb;
          int answer=0;
          int a=5;
          while(true) {
             numb=rand.nextDouble();
             if(tree.search(numb)>=0) {
            	 answer=counter-tree.search(numb);
            	 break;
             }
             else
            	 tree.insert(numb,counter);
             counter++;
          } 
          out.print(answer);
          out.close();
  }
}
