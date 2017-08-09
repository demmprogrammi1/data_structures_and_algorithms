
public class rrr{
static void f(String... args) {
for(String s:args) 
	System.out.print(s+" ");
System.out.println();
}
static void f(String[] s) {
for(int i=0;i<s.length;i++)
	System.out.print(s[i]+" ");
}
public static void main(String[] args) {
//f("sdsad","sffff");
String[] s={"tt","ss" };
//f(s);
determin d=new determin();
d.apply();
System.out.print(s[1]);
}
}