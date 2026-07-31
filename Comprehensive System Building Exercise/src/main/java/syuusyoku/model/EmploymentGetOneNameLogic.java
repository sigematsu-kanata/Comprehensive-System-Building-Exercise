package syuusyoku.model;

import syuusyoku.dao.EmploymentDao;

public class EmploymentGetOneNameLogic {
	public String execute(String key) {
		EmploymentDao onename = new EmploymentDao();
		String check = onename.findByOneName(key);
		return check;
	}
}
