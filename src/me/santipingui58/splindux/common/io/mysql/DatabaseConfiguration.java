package me.santipingui58.splindux.common.io.mysql;

public class DatabaseConfiguration {

	private String host;
	private int port;
	private String user;
	private String password;
	private int minimumConnections;
	private int maximumConnections;
	private int connectionTimeout;
	private String testQuery;
	private String database;
	
	public DatabaseConfiguration(String host, int port, String database,String user, String password,int minimumConnections, int maximumConnections, int connectionTimeout,String testQuery) {
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
	
	
	public DatabaseConfiguration() {
		this("localhost",3306,"splindux","root",null,1,10,2000,"");
	}


	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}


	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}


	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}


	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}


	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the minimumConnections
	 */
	public int getMinimumConnections() {
		return minimumConnections;
	}


	/**
	 * @param minimumConnections the minimumConnections to set
	 */
	public void setMinimumConnections(int minimumConnections) {
		this.minimumConnections = minimumConnections;
	}


	/**
	 * @return the maximumConnections
	 */
	public int getMaximumConnections() {
		return maximumConnections;
	}


	/**
	 * @param maximumConnections the maximumConnections to set
	 */
	public void setMaximumConnections(int maximumConnections) {
		this.maximumConnections = maximumConnections;
	}


	/**
	 * @return the connectionTimeout
	 */
	public int getConnectionTimeout() {
		return connectionTimeout;
	}


	/**
	 * @param connectionTimeout the connectionTimeout to set
	 */
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}


	/**
	 * @return the testQuery
	 */
	public String getTestQuery() {
		return testQuery;
	}


	/**
	 * @param testQuery the testQuery to set
	 */
	public void setTestQuery(String testQuery) {
		this.testQuery = testQuery;
	}


	/**
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}


	/**
	 * @param database the database to set
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

}
