package model;

import dao.Employment_dropDao;

public class EmploymentDropListLogic {
	public void execute(Employment emp) {
		Employment_dropDao userdao = new Employment_dropDao();
		userdao.dropList(emp);
	}
}
