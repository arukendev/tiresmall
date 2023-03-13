package com.tireshoppingmall.home.admin.order;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tireshoppingmall.home.admin.board.SearchDTO;
import com.tireshoppingmall.home.admin.AdminMenuSession;

@Controller
public class AdminOrderController {
	
	private boolean orderFirstReq;
	
	@Autowired
	private OrderDAO oDAO;
	
	public AdminOrderController() {
		orderFirstReq = true;
	}
	
	//admin.order.go
	@RequestMapping(value = "/admin.order.go", method = RequestMethod.GET)
	public String orderGo(AdminMenuSession menuSession, HttpServletRequest req) {
		if(orderFirstReq) {
			oDAO.calcAllOrderCount();
			orderFirstReq = false;
		}
		OrderSearchDTO.clearsearch(req);
		oDAO.getOrder(1, req);
		oDAO.menuSession(menuSession,req);
		req.setAttribute("contentPage", "order/order.jsp");
		return "admin/master";
	}
	
	@RequestMapping(value = "/search.order.do", method = RequestMethod.GET)
	public String search(HttpServletRequest req, OrderSearchDTO osDTO) {
		
		oDAO.searchOrder(osDTO, req);
		oDAO.getOrder(1, req);
		req.setAttribute("contentPage", "order/order.jsp");
		return "admin/master";
	}

	@RequestMapping(value = "/update.order.do", method = RequestMethod.GET)
	public String updateOrder(HttpServletRequest req, OrderSearchDTO osDTO) {
		
		oDAO.updateOrder(osDTO, req);
		oDAO.getOrder(1, req);
		req.setAttribute("contentPage", "order/order.jsp");
		return "admin/master";
	}

	@RequestMapping(value = "/delete.order.do", method = RequestMethod.GET)
	public String deleteOrder(HttpServletRequest req, OrderSearchDTO osDTO) {
		
		oDAO.deleteOrder(osDTO, req);
		oDAO.getOrder(1, req);
		req.setAttribute("contentPage", "order/order.jsp");
		return "admin/master";
	}
	
	@RequestMapping(value = "/order.page.change", method = RequestMethod.GET)
	public String pagingOrder(HttpServletRequest req, @RequestParam int p) {
		System.out.println(p);
		oDAO.getOrder(p, req);
		req.setAttribute("contentPage", "order/order.jsp");
		return "admin/master";
	}
	
	@ResponseBody
	@RequestMapping(value = "/order.get", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public String getOrder(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "order/order.jsp");
		return "admin/master";
	}
	
	
}
