package syuusyoku.model;

import java.util.List;

import syuusyoku.dao.EmploymentDao;

public class EmploymentGetListLogic {
	public List<Employment> execute() {
		EmploymentDao empdao = new EmploymentDao();
		List<Employment>emplist = empdao.findall();
		return emplist;
	}
}
