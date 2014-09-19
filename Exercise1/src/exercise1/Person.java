package exercise1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Person {

	DBAccess db;
	private String LastName;
	private String FirstName;
	private String Type;
	private List<Work> Works;
	
	public Person(String FirstName, String LastName, String Type) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Type = Type;
		this.Works = new ArrayList<Work>();
	}
	
	public Person(String FirstName, String LastName, String Type, Work work) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Type = Type;
		this.Works = new ArrayList<Work>();
		this.Works.add(work);
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
	
	public List<Work> getWorks(){
		return Works;
	}
	
	public void addWorks(Work work){
		this.Works.add(work);
	}
	
	
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + " " + getType();
	}
	
	public void addPersonToDatabase() throws SQLException{
		db = new DBAccess();
		String insertPerson = "INSERT INTO \"postgres\".\"Person\"(\"FirstName\", \"LastName\", \"Type\") VALUES('" + FirstName + "' ,'" + LastName + "' ,'" + Type +"') RETURNING \"Id\"";
		//String fetchID = "SELECT @@Id AS ID";
		Statement statement = db.connection.createStatement();
		//statement.execute(insertPerson);
		ResultSet resultSet = statement.executeQuery(insertPerson);
		int id = 0;
		while (resultSet.next()) {
			id = resultSet.getInt("id");
		}
		
		for (Work w : Works) {
			if(w instanceof Album) {
				String insertWork = "INSERT INTO \"postgres\".\"Album\"(\"Name\", \"Id\") VALUES('" + w.getWorkName() + "' ,'" + id + "')";
				statement = db.connection.createStatement();
				statement.execute(insertWork);
			} else if(w instanceof Movie) {
				String insertWork = "INSERT INTO \"postgres\".\"Movie\"(\"Name\", \"Id\") VALUES('" + w.getWorkName() + "' ,'" + id + "')";
				statement = db.connection.createStatement();
				statement.execute(insertWork);
			} else {
				
			}
		}
		
		db.Close();
	}
}
