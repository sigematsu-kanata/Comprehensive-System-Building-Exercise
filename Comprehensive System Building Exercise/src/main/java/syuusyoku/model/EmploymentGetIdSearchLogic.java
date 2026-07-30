package syuusyoku.model;

import java.util.List;

import syuusyoku.dao.EmploymentDao;

public class EmploymentGetIdSearchLogic {
	public List<Employment> execute(String from, String keyword) {
		EmploymentDao empdao = new EmploymentDao();
		List<Employment>list = empdao.findById(from,keyword);
		return list;
	}
}
