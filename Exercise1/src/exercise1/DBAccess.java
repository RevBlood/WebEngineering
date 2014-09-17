package exercise1;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

public class DBAccess {

	public Connection connection;
	public DBAccess() throws SQLException{
		try{
			Context context = new InitialContext();
			DataSource datasource = (DataSource)(context).lookup("java:comp/env/jdbc/postgres");
	
			if (datasource != null) {
				connection = datasource.getConnection();
				}
			}
		catch(Exception e){
			e.printStackTrace();
			}
		}

	public void Close() throws SQLException{
		connection.close();
		}
	}