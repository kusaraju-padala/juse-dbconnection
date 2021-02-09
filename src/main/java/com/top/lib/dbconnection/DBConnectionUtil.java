package com.top.lib.dbconnection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnectionUtil {
	
	private static Logger log = LogManager.getLogger(DBConnectionUtil.class.getName());

    private static DataSource datasource;
    
    private static HikariConfig config;
    
    private static final String SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    static {
    	config = new HikariConfig();
    	String dbUrl = System.getenv("SQL_JDBC_URL");
		String userName = System.getenv("SQL_DB_USERNAME");
		log.info("DB URL :"+dbUrl);
		log.info("DB Username :"+userName);
		config.setJdbcUrl(dbUrl);			
		config.setUsername(userName);
		config.setPassword(System.getenv("SQL_DB_PASSWORD"));
		
		config.setDriverClassName(SQL_DRIVER);
		config.setMaximumPoolSize(30);
		config.setAutoCommit(true);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		datasource = new HikariDataSource(config);
    }
    
    
    private DBConnectionUtil() {
    	
    }
    
    public static Connection getConnection() throws SQLException {
    	return datasource.getConnection();
    }
    

}
