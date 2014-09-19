package exercise1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkTable {

	List<String> works;
	DBAccess db;

	public WorkTable(String firstName) throws SQLException{
		db = new DBAccess();
		String type = "";
		Statement statement = db.connection.createStatement();
		ResultSet typeOfPerson = statement.executeQuery("SELECT \"postgres\".\"Person\".\"Type\" FROM \"postgres\".\"Person\" WHERE \"postgres\".\"Person\".\"FirstName\" =  '" + firstName + "'  ");
		while (typeOfPerson.next()) {
			type = typeOfPerson.getString("Type");
		}
		
		if(type.equals("Musician")) {
			type = "Album";
		} else {
			type = "Movie";
		}
		
		ResultSet set = statement.executeQuery("SELECT \"postgres\".\"" + type + "\".\"Name\" FROM \"postgres\".\"Person\" JOIN \"postgres\".\"" + type + "\" ON \"Person\".\"Id\"=\"" + type + "\".\"Id\" WHERE \"Person\".\"FirstName\" =  '" + firstName + "'  ");
		
		works = new ArrayList<String>();
		while (set.next()) {
			works.add(set.getString("Name"));
		}
	}
	
	public List<String> getWorkTable(){
		return works;
	}
	
	public void closeDb() {
		try {
			db.Close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

