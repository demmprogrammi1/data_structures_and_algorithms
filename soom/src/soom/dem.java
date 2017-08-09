package soom;
import java.util.*;
import java.io.*;
public class dem {
 public static void main(String[] args)  throws IOException {
	 Scanner in=new Scanner (new FileReader("input.txt"));
	 PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
	 public final int MAXGOLD=10;
	 public final int MAXMONEY=10000;
	 public final int MAX=10000;
	 Random rand=new Random();
	 
	 Rock rock=new Rock(rand.nextInt(MAX));
	 Shaxter sharxter=new Shaxter(rand.nextInt(MAXGOLD));
	 Uvelir uvelir=new Uvelir
 }
}
class Rock {
	private int gold;
	public Rock(int a) {
		gold=a;
	}
	public Rock() { 
		gold=0;
	}
	private int getGold(int a) {
		if(gold>=a)
			return a;
		return gold;
	}
}
class Shaxter {
 private int indust;
 private  Shaxter(int a) {
	 indust=a;
 }
 private int getIndust(int a) {
	 return indust; 
 }
 }
class Uvelir {
	private int[10] things;
	private void setCostofthings(Random rand) {
		for(int i=0;i<10;i++)
			things[i]=rand.nextInt(30);
	}
	
}
	
}
