package cn.jbit.house.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import cn.jbit.house.biz.IHouseBiz;
import cn.jbit.house.biz.IUserBiz;
import cn.jbit.house.biz.impl.HouseBizImpl;
import cn.jbit.house.biz.impl.UserBizImpl;
import cn.jbit.house.dao.HibernateUtil;
import cn.jbit.house.entity.House;
import cn.jbit.house.entity.HouseCondition;
import cn.jbit.house.entity.PageInfo;
import cn.jbit.house.entity.User;
import cn.jbit.house.util.Tool;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String path = request.getServletPath();
			path = path.substring(1, path.lastIndexOf('.'));
			if ("register".equals(path)) {
				IUserBiz userBiz = new UserBizImpl();
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String telephone = request.getParameter("telephone");
				User user = new User(username, password);
				user.setTelephone(telephone);
				userBiz.register(user);
				response.sendRedirect("login.jsp");
			} else if ("login".equals(path)) {
				IUserBiz userBiz = new UserBizImpl();
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				User user = userBiz.login(username, password);
				if (user != null) {
					request.getSession().setAttribute("user", user);
				}
				response.sendRedirect("list.jsp");
			} else if ("search".equals(path)) {
				// 获取表单数据
				String pageIndexStr = request.getParameter("pageIndex");
				String title = request.getParameter("title");
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");
				String startPrice = request.getParameter("startPrice");
				String endPrice = request.getParameter("endPrice");
				
				// 设定页码
				Integer pageIndex = 1;
				if (pageIndexStr != null) {
					pageIndex = new Integer(pageIndexStr);
				}
				
				// 新建 houseCondition Bean 用作筛选条件
				HouseCondition houseCondition = new HouseCondition();
				if (title != null && !title.equals("")) {
					houseCondition.setTitle("%" + title + "%");
				}
				if (startDate != null && !startDate.equals("")) {
					houseCondition.setStartDate(Tool.strToDate(startDate, "yyyy-MM-dd"));
				}
				if (endDate != null && !endDate.equals("")) {
					houseCondition.setEndDate(Tool.strToDate(endDate, "yyyy-MM-dd"));
				}
				if (startPrice != null && !startPrice.equals("")) {
					houseCondition.setStartPrice(Integer.valueOf(startPrice));
				}
				if (endPrice != null && !endPrice.equals("")) {
					houseCondition.setEndPrice(Integer.valueOf(endPrice));
				}
				// 新建 pageInfo 对象用作筛选条件和输出对象
				PageInfo<House> pageInfo = new PageInfo<House>();
				pageInfo.setPageIndex(pageIndex);
				
				// 检索页面信息
				IHouseBiz houseBiz = new HouseBizImpl();
				pageInfo = houseBiz.search(pageInfo, houseCondition);
				
				// 把检索出的页面信息转发回提交页面
				request.setAttribute("pageInfo", pageInfo);
				request.getRequestDispatcher("list.jsp").forward(request, response);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
