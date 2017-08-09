
public class Connection {
	private Connection() { }
	public static Connection connection=new Connection();
	public static Connection getInstance() {
		return connection;
	}
	

}
