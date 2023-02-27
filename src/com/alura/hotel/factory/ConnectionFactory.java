package com.alura.hotel.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private DataSource dataSource;

	public ConnectionFactory() {
		var comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_53dd5e65957083f?useTimeZone=true&serverTimeZone=UTC");
		comboPooledDataSource.setUser("b621a565476abd");
		comboPooledDataSource.setPassword("1a01b8d6");
		comboPooledDataSource.setMaxPoolSize(20);
		this.dataSource = comboPooledDataSource;

	}

	public Connection recuperaConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
