import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import java.util*;

public class Main {
	
public static void main(String[] arg) throws IOException {
	Scanner in=new Scanner(new FileReader("input.txt"));
	PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
	in.useLocale(Locale.US);

	BigInteger ans=1;
	int n=in.nextInt();
	int m=in.nextInt();
	for(int i=n;i>n-m;i--)
		ans*=i;
	out.print(ans);
}
}
