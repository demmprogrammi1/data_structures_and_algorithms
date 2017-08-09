package lafore26;
import java.io.*;
public class Dem {
	public static void main(String[] arg) throws IOException {

	ownM a=new ownM(10);
	ownM b=new ownM(10);
	a.full();
	b.full();
	a.print();
	b.print();
	a.merge(a,b).print();
	
	}

}
