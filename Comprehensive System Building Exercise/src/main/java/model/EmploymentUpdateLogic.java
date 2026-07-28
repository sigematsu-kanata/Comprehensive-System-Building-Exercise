package model;

import dao.Employment_upDao;

public class EmploymentUpdateLogic {
	public void execute(Employment emp) {
		Employment_upDao updao = new Employment_upDao();
		updao.upList(emp);
	}
}
