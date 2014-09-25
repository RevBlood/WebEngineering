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
		boolean musician = false;
		boolean actor = false;
		Statement statement = db.connection.createStatement();
		ResultSet result = null;
		works = new ArrayList<String>();
		
		ResultSet typeOfPerson = statement.executeQuery("SELECT \"postgres\".\"Person\".\"Type\" FROM \"postgres\".\"Person\" WHERE \"postgres\".\"Person\".\"FirstName\" =  '" + firstName + "'  ");
		while (typeOfPerson.next()) {
			
			type = typeOfPerson.getString("Type");
			if(type.equals("Musician")) {
				musician = true;
			} else {
				actor = true;
			}
		
		}
		
		if (musician) {
			result = statement.executeQuery("SELECT \"postgres\".\"Album\".\"Name\" FROM \"postgres\".\"Person\" JOIN \"postgres\".\"Album\" ON \"Person\".\"Id\"=\"Album\".\"Id\" WHERE \"Person\".\"FirstName\" =  '" + firstName + "'  ");
			
			while (result.next()) {
				works.add(result.getString("Name"));
			}
		}

		if (actor) {
			result = statement.executeQuery("SELECT \"postgres\".\"Movie\".\"Name\" FROM \"postgres\".\"Person\" JOIN \"postgres\".\"Movie\" ON \"Person\".\"Id\"=\"Movie\".\"Id\" WHERE \"Person\".\"FirstName\" =  '" + firstName + "'  ");
			while (result.next()) {
				works.add(result.getString("Name"));
			}
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

