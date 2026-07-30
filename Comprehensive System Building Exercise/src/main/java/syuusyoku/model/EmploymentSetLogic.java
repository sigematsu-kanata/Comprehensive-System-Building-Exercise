package syuusyoku.model;

import syuusyoku.dao.Employment_newDao;

public class EmploymentSetLogic {
	public void execute(Employment emp) {
		Employment_newDao userdao = new Employment_newDao();
		userdao.setList(emp);
	}
}
