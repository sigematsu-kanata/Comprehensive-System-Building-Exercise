package syuusyoku.model;

import java.util.List;

import syuusyoku.dao.EmploymentDao;

public class EmploymentGetNameSearchLogic {
	public List<Employment> execute(String from, String keyword) {
		EmploymentDao empdao = new EmploymentDao();
		List<Employment>list = empdao.findByName(from,keyword);
		return list;
	}
}
