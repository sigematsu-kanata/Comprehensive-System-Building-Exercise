package syuusyokuhyou.model;

import java.util.List;

import syuusyokuhyou.dao.ReportDao;

public class GetReportLogic {
	public List<Report> execute() {
		ReportDao dao = new ReportDao();
		List<Report> ReportList = dao.findAll();
		return ReportList;
	}
}
