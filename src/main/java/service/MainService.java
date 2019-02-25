package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.Users;

@Service
public class MainService {

	@Autowired
	private UserDao userDao;
	
	public List<Users> getUsers() {
		
		List<Users> users = new ArrayList<Users>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"/UsersData.txt"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("IO Exception occurred while reading file");
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Exception occurred while reading file");
			ex.printStackTrace();
		}
		
		return users;
	}

	public Integer addUsers(List<Users> users) {
		Integer count = userDao.addUsers(users);

		return count;
	}
}
