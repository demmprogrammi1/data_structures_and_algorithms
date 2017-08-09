import java.io.*;
import java.util.*;

public class M {
	public static void main(String[] args)  throws IOException {
		Scanner in=new Scanner(new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		BST tree=new BST();
		tree.insert(1);
		tree.insert(2);
		tree.insert(5);
		tree.delete(2);
		tree.insert(4);
		tree.insert(9);
		tree.delete(3);
		tree.print(tree.root);
		out.close();
}
}
