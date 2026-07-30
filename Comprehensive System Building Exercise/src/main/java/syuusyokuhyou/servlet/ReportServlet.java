package syuusyokuhyou.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import syuusyokuhyou.model.CSClass;
import syuusyokuhyou.model.GetCSClassLogic;
import syuusyokuhyou.model.GetReportLogic;
import syuusyokuhyou.model.GetSearchReportLogic;
import syuusyokuhyou.model.Report;
import syuusyokuhyou.model.ReportCount;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GETリクエストでも報告書一覧を表示したい場合は、doPostと同じ処理を実行するように呼び出します
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ビジネスロジックを呼び出して報告書データを取得
		String keyword = request.getParameter("keyword");
		int count = 0; //
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int mcount = 0;
		int mcount1 = 0;
		int mcount2 = 0;
		int mcount3 = 0;
		int wcount = 0;
		int wcount1 = 0;
		int wcount2 = 0;
		int wcount3 = 0;
		
		int test = -1;
		
		String f = "全体";
		
		if(keyword == null || keyword.isEmpty()) {
			GetReportLogic getReportLogic = new GetReportLogic();
			List<Report> reportList = getReportLogic.execute();
			for (Report report : reportList) {
				if(test != report.getStudent_id()) {
					test = report.getStudent_id();
					System.out.println(test);
					count++;
					//if(report.getEnrollment_status().equals("在籍")) {
					if(report.getJender().equals("男性")) {
						mcount++;
						if(report.getActivity_situation() == null || report.getActivity_situation().isEmpty()){
						}else {
							if(report.getActivity_situation().equals("継続中")) {
								count1++;
								mcount1++;
							}else if(report.getActivity_situation().equals("内定確定")||report.getActivity_situation().equals("内定保留")){
								count2++;
								mcount2++;
							}else if(report.getActivity_situation().equals("落ちた")||report.getActivity_situation().equals("内定後不採用")){
								count3++;
								mcount3++;
							}
						}
					}else if(report.getJender().equals("女性")) {
						wcount++;
						if(report.getActivity_situation() == null || report.getActivity_situation().isEmpty()){
						}else {
							if(report.getActivity_situation().equals("継続中")) {
								count1++;
								wcount1++;
							}else if(report.getActivity_situation().equals("内定確定")||report.getActivity_situation().equals("内定保留")){
								count2++;
								wcount2++;
							}else if(report.getActivity_situation().equals("落ちた")||report.getActivity_situation().equals("内定後不採用")){
								count3++;
								wcount3++;
							}
						}
					}
				//}
				}
			}
		}else {
			GetCSClassLogic CS = new GetCSClassLogic();
			List<CSClass> CSList = CS.execute();
			String Skey = "";
			for (CSClass CC : CSList) {
				Skey = CC.getCl();
				if(Skey.equals(keyword)) {
					Skey = CC.getSN();
					break;
				}
			}
			f = keyword;
			GetSearchReportLogic getSReportLogic = new GetSearchReportLogic();
			List<Report> reportList = getSReportLogic.execute(Skey);
			for (Report report : reportList) {
				if(test != report.getStudent_id()) {
					test = report.getStudent_id();
					System.out.println(test);
					count++;
					//if(report.getEnrollment_status().equals("在籍")) {
					if(report.getJender().equals("男性")) {
						mcount++;
						if(report.getActivity_situation() == null || report.getActivity_situation().isEmpty()){
						}else {
							if(report.getActivity_situation().equals("継続中")) {
								count1++;
								mcount1++;
							}else if(report.getActivity_situation().equals("内定確定")||report.getActivity_situation().equals("内定保留")){
								count2++;
								mcount2++;
							}else if(report.getActivity_situation().equals("落ちた")||report.getActivity_situation().equals("内定後不採用")){
								count3++;
								mcount3++;
							}
						}
					}else if(report.getJender().equals("女性")) {
						wcount++;
						if(report.getActivity_situation() == null || report.getActivity_situation().isEmpty()){
						}else {
							if(report.getActivity_situation().equals("継続中")) {
								count1++;
								wcount1++;
							}else if(report.getActivity_situation().equals("内定確定")||report.getActivity_situation().equals("内定保留")){
								count2++;
								wcount2++;
							}else if(report.getActivity_situation().equals("落ちた")||report.getActivity_situation().equals("内定後不採用")){
								count3++;
								wcount3++;
							}
						}
					}
				//}
				}
			}
		}
		
		int count4 = 0;//内定率
		int mcount4 = 0;
		int wcount4 = 0;
		int count5 = count1+count2+count3;//全体受験者
		int mcount5 = mcount1+mcount2+mcount3;
		int wcount5 = wcount1+wcount2+wcount3;
		
		if(count2 != 0) {
			if(count5 != 0) {
			count4 = (int) (((count2*100) / (count5)));
			}
		}
			
		if(mcount2 != 0) {
			if(mcount5 != 0) {
			mcount4 = (int) (((mcount2*100) / (mcount5)));
			}
		}
		
		if(wcount2 != 0) {
			if(wcount5 != 0) {
				wcount4 = (int) (((wcount2*100) / (wcount5)));
			}
		}
		ReportCount rc = new ReportCount(count,count1,count2,count3,count4,count5,mcount,mcount1,mcount2,mcount3,mcount4,mcount5,wcount,wcount1,wcount2,wcount3,wcount4,wcount5);
		// 2. リクエストスコープにデータを保存 ("reportList" という名前で保存)
		request.setAttribute("reportList", rc);
		request.setAttribute("from", f);
		// 3. 表示用のJSPへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Report.jsp");
		dispatcher.forward(request, response);
	}
}