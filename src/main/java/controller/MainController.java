package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import model.Users;
import service.MainService;

@RestController
@RequestMapping("/users")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping(method=RequestMethod.GET ,produces = "application/json")
	public List<Users> getUsersNamesFromDB() {
		List<Users> users = mainService.getUsers();
		
		return users;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Integer addUsers(@RequestParam("file") MultipartFile file) {
		Integer userAddedCount = 0;
		 if (!file.isEmpty()) {
			 List<Users> users = mainService.getUsers();
			 userAddedCount = mainService.addUsers(users);
		 }
		return userAddedCount;
	}
	
	@RequestMapping(value="/fileData", method=RequestMethod.POST)
	public List<Users> getUsersNamesFromFile(@RequestParam("file") MultipartFile file) {
		 List<Users> users = new ArrayList<Users>();
		 if (!file.isEmpty()) {
			 users = mainService.getUsers();
		 }
		return users;
	}
}
