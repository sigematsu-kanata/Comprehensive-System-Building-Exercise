package syuusyoku.model;

import java.util.List;

import syuusyoku.dao.EmploymentDao;

public class GetCSClassLogic {
	public List<CSClass> execute() {
		EmploymentDao dao = new EmploymentDao();
		List<CSClass> cstList = dao.getCSClass();
		return cstList;
	}
}
