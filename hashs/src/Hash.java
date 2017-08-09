import java.util.ArrayList;
import java.util.Hashtable;

public class Hash {

	public static void main(String[] args)  {
	 /*  Integer obj1=new Integer(2009);
	   System.out.println(obj1.hashCode());
	   String obj2=new String("2009");
	   System.out.println(obj2.hashCode());
	   StringBuffer obj3=new StringBuffer("2009");
	   System.out.println(obj3.hashCode());
	   ArrayList<Integer> obj4=new ArrayList<Integer>();
	   System.out.println(obj4.hashCode()); */
	   Hashtable<Integer,String> map=new Hashtable<Integer,String>();
	   map.put(102, "let us C");
	   map.put(103, "operating system");
	   map.put(101,"data communication and networking");
	   System.out.println(map);
	   map.remove(102);
	   System.out.print(map);
	// Java uses polynomial function with base 31
	// for string hashing
	String a = "A Test";
	String b = "B Test";
	String c = "C Test";
	long power4 = 31 * 31 * 31 * 31;
	System.out.println(a.hashCode() % power4);
	System.out.println(b.hashCode() % power4);
	System.out.println(c.hashCode() % power4);
	a = "Question.";
	b = "Question!";
	System.out.println(a.hashCode() / 31);
	System.out.println(b.hashCode() / 31);

	}
}
