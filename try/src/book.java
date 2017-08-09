
public class book {
	private String name;
    private int countOfPages;
    private book() {
    	name="Book";
    	countOfPages=0;
    }
    private book(int n,String s) {
    	name=s;
    	countOfPages=n;
    }
    public static book BOOK=new book();
    public static book access() {
    	return BOOK;
    }
    
    public void setName(String s) {
    	name=s;
    }
    public String getName() {
    	return name;
    }
    

}
