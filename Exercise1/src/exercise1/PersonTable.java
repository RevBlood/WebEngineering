package exercise1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonTable {
	
	List<Person> personTable;
	DBAccess db;

	public PersonTable() throws SQLException{
		personTable = new ArrayList<Person>();
		db = new DBAccess();
		Statement statement = db.connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM \"postgres\".\"Person\"");
		String databaseFirstName;
		String databaseLastName;
		String databaseType;
		while (resultSet.next()) {
			databaseFirstName = resultSet.getString("FirstName");
			databaseLastName = resultSet.getString("LastName");
			databaseType = resultSet.getString("Type");
			
			Person person = new Person(databaseFirstName, databaseLastName, databaseType);
			personTable.add(person);
		}
	}
	
	public List<Person> getPersonTable(){
		return personTable;
	}
	
	public String toString(){
		String stringTable;
		stringTable = personTable.toString();
		return stringTable;
	}

	public void closeDb() {
		try {
			db.Close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
