package co.za.ngwane.epms.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.repository.Dept;
import co.za.ngwane.epms.repository.Userepms;
import co.za.ngwane.epms.serviceImpl.DeptServiceImpl;
import co.za.ngwane.epms.serviceImpl.UserepmsServiceImpl;

public class UserOperations {
	private static Logger logger = Logger
			.getLogger("co.za.ngwane.epms.operation.UserOperations");

	public Userepms userLogin(Userepms user) {

		String password = user.getPassword();
		String username = user.getUsername();
		logger.info("Username is: " + username + " and password is " + password);

		try {
			user = new UserepmsServiceImpl().userLogin(username, password);

			if (user == null) {
				logger.info("User not found.");
			}

			else {
				String body = user.getName() + " " + user.getSurname()
						+ "\n\nHave logged in at " + new Date();
				logger.info(body);

				/*
				 * Eventlog eventlog = new Eventlog();
				 * eventlog.setDescription(body); eventlog.setName("LOGIN");
				 * 
				 * new EventlogServiceImpl().addEventlog(eventlog);
				 */

				logger.info("User info found.");
				logger.info("User ID: " + user.getId() + " \nUsername: "
						+ user.getName());
			}
		} catch (Exception e) {
			logger.info("Exception caught, msg: " + e.getMessage());
			e.printStackTrace();
		}

		return user;

	}

	public List<Userepms> getAll() {

		logger.info("Initiating Get All Users");

		List<Userepms> userlist = new ArrayList<Userepms>();
		try {
			userlist = new UserepmsServiceImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Failed to retrive users");
		}
		return userlist;
	}

	public Userepms getByName(String name) {

		logger.info("Initiating Get User By Name");

		Userepms user = new Userepms();
		try {
			user = new UserepmsServiceImpl().getByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Failed to retrive user");
		}
		return user;
	}

	public boolean add(Userepms userepms) {

		boolean results = false;
		logger.info("Entering Department Operations : User Name [");// TO Be
																	// Completed
		try {
			if (userepms != null) {
				results = new UserepmsServiceImpl().add(userepms);
			}
		} catch (Exception e) {
			logger.info("Exception caught : "+e.getMessage());
			e.printStackTrace();
		}

		return results;
	}

}
