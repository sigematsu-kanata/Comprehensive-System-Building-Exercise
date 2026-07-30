package syuusyoku.model;

import syuusyoku.dao.Employment_upDao;

public class EmploymentUpdateLogic {
	public void execute(Employment emp, Employment old) {
		Employment_upDao updao = new Employment_upDao();
		updao.upList(emp,old);
	}
}
