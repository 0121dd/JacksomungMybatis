package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		Member member = new Member(memberId, memberPw);
		
		MemberService service = new MemberService();
		Member loginCheck = service.selectCheckLogin(member);
		if(loginCheck != null) {
			//세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("memberId", loginCheck.getMemberId());
			session.setAttribute("memberName", loginCheck.getMemberName());
			response.sendRedirect("/index.jsp");
		}else {
			request.setAttribute("msg", "로그인 실패!");
			request.setAttribute("url", "/member/login.do");
			request.getRequestDispatcher("/WEB-INF/views/member/serviceFailed.jsp").forward(request, response);
			
		}
	}

}
