package board.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.QuestionService;
import board.model.vo.PageData;
import board.model.vo.QuestionBoard;

/**
 * Servlet implementation class QuestionListController1
 */
@WebServlet("/board/questionList.do")
public class QuestionListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionService service = new QuestionService();
		// currentPage값이 없으면 값을 1로 넣어라.(삼항연산자)
		String page = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "1";
		int currentPage = Integer.parseInt(page);
		PageData pd = service.selectAllQuestion(currentPage);
		List<QuestionBoard> qList = pd.getnList();
		String pageNavi = pd.getPageNavi();
		request.setAttribute("qList", qList);
		request.setAttribute("pageNavi", pageNavi);
		request.getRequestDispatcher("/WEB-INF/views/board/board.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
