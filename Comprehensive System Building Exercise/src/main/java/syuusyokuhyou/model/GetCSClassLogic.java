package syuusyokuhyou.model;

import java.util.List;

import syuusyokuhyou.dao.ReportDao;

public class GetCSClassLogic {
	public List<CSClass> execute() {
		ReportDao dao = new ReportDao();
		List<CSClass> cstList = dao.getCSClass();
		return cstList;
	}
}
