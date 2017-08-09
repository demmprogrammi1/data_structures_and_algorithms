import java.util.*;
import java.io.*;
public class Evaluation {
	public static String current;
	
	public static int p=0;
	
	public static boolean precedence(String a,String b) {
		int fir=-1,sec=-1;
		for(int i=0;i<4;i++) {
			if(a.charAt(0)==opers[i])
			   fir=i;
			if(b.charAt(0)==opers[i])
			   sec=i;
		}
        if(fir*sec<0) return false;
		if((fir==3&&sec<2)||(fir==2&&sec<2))
			return false;
		return true;
	}
	
	public static char[] opers ={'+','-','*','/',')','('};
	
	public static boolean is_number(String t) {
		if(t.length()>1)
			return true;
		if(t.charAt(0)>='0'&&t.charAt(0)<='9')
			return true;
		return false;
	}
	public static boolean is_op(String t) {
		for(int i=0;i<4;i++)
			if(t.charAt(0)==opers[i])
				return true;
		return false;
	}
	public static String get_token(int j) {
		String temp="";
		for(int i=0;i<6;i++)
	    if(current.charAt(j)==opers[i]) 
	    	return Character.toString(opers[i]);
		while(j<current.length()&&((current.charAt(j)>='0'&&current.charAt(j)<='9')||current.charAt(j)=='.')) {
			temp=temp.concat(Character.toString(current.charAt(j)));
			j++; 
		}
			return temp;
	}
	
	public static double Result(double a,double b,String sign) {
		if(sign.charAt(0)=='+')
			return a+b;
		if(sign.charAt(0)=='-')
			return b-a;
		if(sign.charAt(0)=='*')
			return a*b;
			return b/a;
	}

	public static void main(String[] args) throws Exception {
		Scanner in=new Scanner(new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		LinkedStack<String> stack=new LinkedStack<String>();
		LinkedQueue<String> queue=new LinkedQueue<String>();
		LinkedStack<Double> ans=new LinkedStack<Double>();
	    current=in.nextLine();
	    current=current.replaceAll(" ", "");
	    String temp;
		while(p<current.length())  {
			temp=get_token(p);
			p+=temp.length();
			//out.println(temp);
		    if(is_number(temp))
				queue.add(temp);
			if(is_op(temp))  {
				while(!stack.is_empty()&&is_op(stack.peek())&&precedence(temp,stack.peek()))
					queue.add(stack.pop());
				stack.add(temp);
			}  
			if(temp.charAt(0)=='(') {
				stack.add("(");
			}
			if(temp.charAt(0)==')') {
				while(!stack.is_empty()&&stack.peek().charAt(0)!='(')
				queue.add(stack.pop());
			stack.pop();
			}	
		}  
		while(!stack.is_empty())
			queue.add(stack.pop());
		double first,second;
		temp=""; 
		while(!queue.is_empty()) {
			temp=queue.remove();
			if(is_op(temp)) {
				first=ans.pop();
			    second=ans.pop();
			    ans.add(Result(first,second,temp));
		}
			else
				ans.add(Double.parseDouble(temp));
		} 
        ans.add((double) Math.round(ans.pop() * 100) / 100);
	    temp=ans.peek().toString();
	    for(int i=0;i<temp.length();i++)
	    	if(temp.charAt(i)=='.'&&temp.length()-i-1==1)
	    		temp=temp+"0";
	    out.print(temp);
	    out.close();
	}
}