package exercise1;

import java.sql.*;
import java.util.*;

public class Car {
	
	List<CarRecord> carTable;
	DBAccess db;
	
	public class CarRecord{
		private String Brand;
		private String Model;

		public CarRecord(String brand, String model){
			setBrand(brand);
			setModel(model);
		}

		public String getBrand() {
			return Brand;
		}

		public void setBrand(String brand) {
			Brand = brand;
		}

		public String getModel() {
			return Model;
		}

		public void setModel(String model) {
			Model = model;
		}
		
	}
	
	public Car() throws SQLException{
		carTable = new ArrayList<CarRecord>();
		db = new DBAccess();
		Statement statement = db.connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM \"postgres\".\"Car\"");
		String databaseBrand;
		String databaseModel;
		while (resultSet.next()) {
			databaseBrand = resultSet.getString("Brand");
			databaseModel = resultSet.getString("Model");
			CarRecord carRecord = new CarRecord(databaseBrand, databaseModel);
			carTable.add(carRecord);
		}
	}
	
	public List<CarRecord> getCarList(){
		return carTable;
	}
	
	public void addCarToDatabase(String brand, String model) throws SQLException{
		CarRecord carRecord = new CarRecord(brand, model);
		carTable.add(carRecord);
		String insert = "INSERT INTO \"postgres\".\"Car\"(\"Brand\", \"Model\") VALUES('" + brand + "' ,'" + model + "')";
		Statement statement = db.connection.createStatement();
		statement.execute(insert);
	}
	
	public String toString(){
		String collectionString;
		collectionString = carTable.toString();
		return collectionString;
	}
	
	public String toHTML(){
		String htmlString = "<p>";
		String brand;
		String model;
		for(int i = 0; i < carTable.size(); i++){
			brand = carTable.get(i).getBrand();
			model = carTable.get(i).getModel();
			htmlString = htmlString + brand + " " + model + "; ";
		}
		htmlString = htmlString + "</p>";
		return htmlString;
	}
	
	public void close() {
		try {
			db.Close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
