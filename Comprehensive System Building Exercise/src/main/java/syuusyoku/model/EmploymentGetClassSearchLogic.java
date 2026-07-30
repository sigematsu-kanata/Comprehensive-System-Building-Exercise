package syuusyoku.model;

import java.util.List;

import syuusyoku.dao.EmploymentDao;

public class EmploymentGetClassSearchLogic {
	public List<Employment> execute(String from, String keyword) {
		EmploymentDao empdao = new EmploymentDao();
		List<Employment>list = empdao.findByClass(from,keyword);
		return list;
	}
}
