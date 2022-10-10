package me.santipingui58.splindux.common.io.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import me.santipingui58.splindux.common.io.Connection;

public class DatabaseConnection implements Connection {
	 
	    private String host;
		private int port;
	    private String database;
	    private String user;
	    private String password;
	    
	    private int minimumConnections;
	    private int maximumConnections;
	    private long connectionTimeout;
	    private String testQuery;
	    private HikariDataSource dataSource;
	    
	    public DatabaseConnection(String host, int port,String database,String user, String password,int minimumConnections, int maximumConnections, int connectionTimeout, String testQuery) {
	    	this.host = host;
	    	this.port = port;
	    	this.database = database;
	    	this.user = user;
	    	this.password = password;
	    	this.minimumConnections = minimumConnections;
	    	this.maximumConnections = maximumConnections;
	    	this.connectionTimeout = connectionTimeout;
	    	this.testQuery = testQuery;
	    }
	

		@Override
		public void connect() {
			 HikariConfig config = new HikariConfig();
		        config.setDriverClassName("com.mysql.jdbc.Driver");
		        config.setJdbcUrl(
		                "jdbc:mysql://" +
		                        host +
		                        ":"+port+"" +
		                        "/" +
		                        database+"?useSSL=false&allowMultiQueries=true"
		        );
		        config.setUsername(user);
		        config.setPassword(password);
		        config.setMinimumIdle(minimumConnections);
		        config.setMaximumPoolSize(maximumConnections);
		        config.setConnectionTimeout(connectionTimeout);
		        config.setConnectionTestQuery(testQuery);
		        dataSource = new HikariDataSource(config);
			
		}

		@Override
		public void close() {
			if (dataSource != null && !dataSource.isClosed()) {
	            dataSource.close();
	        }
			
		}
	

	
	
	
	 public java.sql.Connection getConnection() throws SQLException {
	        return dataSource.getConnection();
	    }

	 
	 public void close(java.sql.Connection conn, PreparedStatement ps, ResultSet res) {
	        if (conn != null) try { conn.close(); } catch (SQLException ignored) {}
	        if (ps != null) try { ps.close(); } catch (SQLException ignored) {}
	        if (res != null) try { res.close(); } catch (SQLException ignored) {}
	    }
	 

	
}
