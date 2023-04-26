package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if(conn == null) {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "admin");
            } 
            return conn;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }


    public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
