package syuusyoku.model;

import syuusyoku.dao.EmploymentDao;

public class EmploymentCheckLogic {
	public boolean execute(Employment emp) {
		EmploymentDao checkdao = new EmploymentDao();
		boolean check = checkdao.checkall(emp);
		return check;
	}
}
