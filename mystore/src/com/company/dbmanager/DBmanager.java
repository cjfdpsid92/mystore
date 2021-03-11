package com.company.dbmanager;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class DBmanager {

	public Connection connection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource db = (DataSource)envContext.lookup("jdbc/cjfdpsin92");
			conn = db.getConnection();
			if (conn!=null) {System.out.println("CONNECT!");}
		} catch(Exception e) { e.printStackTrace(); } 
		return conn;
	}
	
}
