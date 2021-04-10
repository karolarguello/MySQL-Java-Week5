package coffeeShop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coffeeShop.entity.CoffeeShop;
/**
 * This method creates a coffeeShop
 * @param coffeeShop_Id
 * @throws SQLException
 * 		thrown if unsuccessful
 */

public class CoffeeShopDAO {
	public void createCoffeeShop(String name) throws SQLException {
		String sql = "INSERT INTO coffeeShop (name) VALUES (?)";
		Connection connection = null;
		PreparedStatement statement = null;
	
	try {
		connection = DbConnection.getInstance().getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, name);
		statement.executeUpdate();

	}
	finally{
		if(statement != null) {
			statement.close();	
		}
		if (connection != null)
		connection.close();
	}
}
/**
 * This method selects a coffee shop 
 * @return
 * @throws SQLException 
 */
	public List<CoffeeShop> fetchCoffeeShop() throws SQLException{
		String sql = "SELECT * FROM coffee_shops";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<CoffeeShop> coffeeShops = new ArrayList<>();
	
	try {
		connection = DbConnection.getInstance().getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			long coffeeShop_Id = resultSet.getLong("coffeeShop_Id");
			String name = resultSet.getString("name");
			CoffeeShop coffeeShop = new CoffeeShop(coffeeShop_Id, name);
			coffeeShops.add(coffeeShop);
		}
		return coffeeShops;
	}
	finally{
		if(resultSet != null) {
			resultSet.close();
		}
		if(statement != null) {
		statement.close();	
		}
		if (connection != null)
		connection.close();
		}
		
}
/**
 * This method updates a coffeeShop
 * @param name
 * @param id
 * @throws SQLException
 */
	
	public void modifyCoffeeShop(String name, long id) throws SQLException {
			String sql = "UPDATE coffeeShop SET name = ? WHERE coffeeShop_Id = ?";
			Connection connection = null;
			PreparedStatement statement = null;
		
		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setLong(2, id);
			
			statement.executeUpdate();

		}
		finally{
			if(statement != null) {
				statement.close();	
			}
			if (connection != null)
			connection.close();
		}
}
/**
 * This method deletes a coffeeShop
 * @param coffeeShop_Id
 * @throws SQLException
 */
	public void deleteCoffeeShop(long coffeeShop_Id) throws SQLException {
		String sql = "DELETE FROM coffeeShop WHERE coffeeShop_ID = ?";
		Connection connection = null;
		PreparedStatement statement = null;
			
		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, coffeeShop_Id);
			
			statement.executeUpdate();

		                     }
		finally{
			if(statement != null) {
				statement.close();	
			}
			if (connection != null)
			connection.close();
		}
	}
	
}
