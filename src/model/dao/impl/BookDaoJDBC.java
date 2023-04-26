package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.BookDao;
import model.entities.Book;

public class BookDaoJDBC implements BookDao {

    private Connection conn;

    public BookDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Book obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                "INSERT INTO book "
                + "(title, author, publication_year) "
                + "VALUES "
                + "(?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getTitle());
            st.setString(2, obj.getAuthor());
            st.setInt(3, obj.getPublicationYear());

            int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
    }

    @Override
    public void update(Book obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Book findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Book> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
