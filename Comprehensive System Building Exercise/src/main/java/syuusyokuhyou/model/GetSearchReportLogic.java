package syuusyokuhyou.model;

import java.util.List;

import syuusyokuhyou.dao.ReportDao;

public class GetSearchReportLogic {
	public List<Report> execute(String a) {
		ReportDao dao = new ReportDao();
		List<Report> ReportList = dao.find(a);
		return ReportList;
	}
}
