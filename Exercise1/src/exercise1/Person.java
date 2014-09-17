package exercise1;

import java.sql.SQLException;
import java.sql.Statement;

public class Person {

	DBAccess db;
	private String LastName;
	private String FirstName;
	private String Type;
	
	public Person(String FirstName, String LastName, String Type) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Type = Type;
	}
	
	public String getLastName(){
		return LastName;
	}
	
	public void setLastname(String LastName) {
		this.LastName = LastName;
	}
	
	public String getFirstName(){
		return FirstName;
	}
	
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public String getType(){
		return Type;
	}
	
	public void setType(String Type) {
		this.Type = Type;
	}
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + " " + getType();
	}
	
	public void addPersonToDatabase() throws SQLException{
		db = new DBAccess();
		String insert = "INSERT INTO \"postgres\".\"Person\"(\"FirstName\", \"LastName\", \"Type\") VALUES('" + FirstName + "' ,'" + LastName + "' ,'" + Type +"')";
		Statement statement = db.connection.createStatement();
		statement.execute(insert);
		db.Close();
	}
}
