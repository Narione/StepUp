package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import board.BoardVO;
import common.PaginationInfo;
import common.SearchVO;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
	
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
		this.service = new MemberService(session);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 페이징 관련 코드
		String pageNo = request.getParameter("currentPageNo");
		int currentPageNo = pageNo == null ? 1 : Integer.parseInt(pageNo);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo);
		paginationInfo.setRecordCountPerPage(3);
		paginationInfo.setPageSize(5);
		SearchVO vo = new SearchVO(null, null);
		int totalCount = service.getMemberTotalCount(vo);
		paginationInfo.setTotalRecordCount(totalCount);
		// 페이징된 게시글 목록을 가져오기 위해
		vo.setFirstRecordIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastRecordIndex(paginationInfo.getLastRecordIndex());
		List<MemberVO> list = service.getMemberList(vo);

		request.setAttribute("pagination", paginationInfo);
		
		request.setAttribute("members", list);
		request.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(request, response);
	}

}






