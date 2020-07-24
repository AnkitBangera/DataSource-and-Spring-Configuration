package org.Spring.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.Spring.Model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DaoImpl {
	@Autowired
	private DataSource dataSource;
	
	public Circle getCircle(int circleid) {
		Connection connection = null;
		try {
			connection =dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM circle where num= ?");
			ps.setInt(1, circleid);

			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				circle = new Circle(circleid, rs.getString("name"));

			}
			
			rs.close();
			ps.close();
			return circle;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
