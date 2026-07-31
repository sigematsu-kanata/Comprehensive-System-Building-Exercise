package syuusyoku.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import syuusyoku.classpackage.Option;
import syuusyoku.dao.EmploymentDao;
import syuusyoku.model.Employment;
import syuusyokuhyou.model.CSClass;
import syuusyokuhyou.model.GetCSClassLogic;

/**
 * Servlet implementation class EmploymentListServlet
 */
@WebServlet("/EmploymentListServlet")
public class EmploymentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmploymentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String keyword = request.getParameter("keyword");
    	String From = "student_id";
    	EmploymentDao dao = new EmploymentDao();
    	if (keyword == null || keyword.isEmpty()) {
    		System.out.println("キーワードなし");
    		List<Employment> list = dao.findall();
    		System.out.println(list.get(0).getCompanyId());
    		request.setAttribute("Employment", list);
    		}else{
    			System.out.println("キーワードあり");
    			List<Employment> list = null;
    			String Search = request.getParameter("search");
    			if(Search.equals("name")) {
    				GetCSClassLogic CS = new GetCSClassLogic();
    				List<CSClass> CSList = CS.execute();
    				String Skey = "";
    				for (CSClass CC : CSList) {
    					Skey = CC.getCl();
    					if(Skey.equals(keyword)) {
    						Skey = CC.getSN();
    						From = "class";
    						System.out.println(From);
    						list = dao.findByClass(From,Skey);
    						break;
    					}
    				}
    				if(!From.equals("class")) {
    					String fromcheck = Option.zenkakuToHankakuNum(keyword);
    					if(fromcheck.equals("error")) {
    						From="name";
    						list = dao.findByName(From,keyword);
    						System.out.println(From);
    					}else {
    						From="studentid";
    						list = dao.findById(From,keyword);
    						System.out.println(From);
    					}
    				}
    				
    			}else if(Search.equals("date")) {
    				From = "date";
    				list = dao.findByDate(From,keyword);
    				System.out.println(From);
    			}
		   request.setAttribute("Employment", list);
		   System.out.println(list.get(0));
	   }
    	

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/EmploymentList.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
    	String From = "student_id";
    	EmploymentDao dao = new EmploymentDao();
    	if (keyword == null || keyword.isEmpty()) {
    		List<Employment> list = dao.findall();
    		request.setAttribute("Employment", list);
    		}else{
    			List<Employment> list = null;
    			String Search = request.getParameter("search");
    			if(Search.equals("name")) {
    				GetCSClassLogic CS = new GetCSClassLogic();
    				List<CSClass> CSList = CS.execute();
    				String Skey = "";
    				for (CSClass CC : CSList) {
    					Skey = CC.getCl();
    					if(Skey.equals(keyword)) {
    						Skey = CC.getSN();
    						From = "class";
    						System.out.println(From);
    						list = dao.findByClass(From,Skey);
    						break;
    					}
    				}
    				if(!From.equals("class")) {
    					String fromcheck = Option.zenkakuToHankakuNum(keyword);
    					if(fromcheck.equals("error")) {
    						From="name";
    						list = dao.findByName(From,keyword);
    						System.out.println(From);
    					}else {
    						From="studentid";
    						list = dao.findById(From,keyword);
    						System.out.println(From);
    					}
    				}
    				
    			}else if(Search.equals("date")) {
    				From = "date";
    				list = dao.findByDate(From,keyword);
    				System.out.println(From);
    			}
		   request.setAttribute("Employment", list);
	   }
        

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/EmploymentList.jsp");
        dispatcher.forward(request, response);
    }
}
