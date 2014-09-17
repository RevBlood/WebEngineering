package exercise1;

import java.sql.SQLException;
import java.util.List;

public class PersonTableAsHTML {
	private String stringTable;
	
	public PersonTableAsHTML() throws SQLException{
		stringTable = "";
		PersonTable personTable = new PersonTable();
		List<Person> list = personTable.getPersonTable();
		stringTable += "<table><tr><td>Name</td><td>Surname</td><td>Work</td></tr>";
		
		String firstName;
		String lastName;
		String type;
		
		for (int i = 0; i < list.size(); i++) {
			firstName = list.get(i).getFirstName();
			lastName = list.get(i).getLastName();
			type = list.get(i).getType();
			stringTable += "<tr><td>" + firstName + "</td><td>" + lastName + "</td><td>" + type + "</td></tr>";
		}
		
		stringTable += "</table>";
		personTable.closeDb();
		
	}
	
	public String getPersonTable(){
		return stringTable;
	}
}