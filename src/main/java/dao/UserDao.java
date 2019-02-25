package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import model.Users;

@Repository
public class UserDao {
	JdbcTemplate jdbcTemplate;

	private final String SQL_GET_ALL = "select * from Users";
	private final String SQL_INSERT_Users = "insert into Users(username) values(?)";

	@Autowired
	public UserDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Users> getAllUsers() {
		return jdbcTemplate.query(SQL_GET_ALL, new ResultSetExtractor<List<Users>>(){  
		    public List<Users> extractData(ResultSet rs) throws SQLException, DataAccessException {
		        List<Users> list=new ArrayList<Users>();  
		        while(rs.next()){  
		        Users u=new Users(rs.getString(1)); 
		        list.add(u);  
		        }  
		        return list;  
		        }  
		    });  
	}

	public Integer addUsers(List<Users> users) {
		Integer count = 0;
		for (Users user : users) {
			count = count + jdbcTemplate.update(SQL_INSERT_Users, user.getUsername());
		}

		return count;
	}
}
