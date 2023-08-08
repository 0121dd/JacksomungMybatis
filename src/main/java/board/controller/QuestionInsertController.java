package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.service.QuestionService;
import board.model.vo.QuestionBoard;

/**
 * Servlet implementation class QuestionInsertController
 */
@WebServlet("/board/insert.do")
public class QuestionInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/qInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String boardSubject = request.getParameter("board-subject");
		String boardContent = request.getParameter("board-content");
		String boardWriter = (String) session.getAttribute("memberName");
		QuestionBoard qboard = new QuestionBoard(boardSubject, boardContent, boardWriter);
		QuestionService service = new QuestionService();
		int result = service.questionInsert(qboard);
		if(result > 0) {
			response.sendRedirect("/board/questionList.do");
		}else { 
			request.setAttribute("msg", "글 등록에 실패하였습니다.");
			request.setAttribute("url", "/board/insert.do");
			request.getRequestDispatcher("/WEB-INF/views/member/serviceFailed.jsp").forward(request, response);
		}
		
		
		
	}

}
