package com.tireshoppingmall.home.admin.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.tireshoppingmall.home.admin.tire.AdminTireMapper;
import com.tireshoppingmall.home.admin.tire.TireDTO;

@Service
public class OrderDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private OrderOption oo;

	private int allOrderCount;

	public int getAllOrderCount() {
		return allOrderCount;
	}

	public void setAllOrderCount(int allOrderCount) {
		this.allOrderCount = allOrderCount;
	}

	public void searchOrder(OrderSearchDTO osDTO, HttpServletRequest req) {
		req.getSession().setAttribute("orderSearchDTO", osDTO);
	}

	public void calcAllOrderCount() {
		OrderSearchDTO ost = new OrderSearchDTO(null, null, "", "", "", "", "");
		allOrderCount = ss.getMapper(AdminOrderMapper.class).getOrderCount(ost);
		System.out.println(allOrderCount);
	}

	public void getOrder(int pageNo, HttpServletRequest req) {
		
		try {
			
		int count = oo.getOrderCountPerPage();
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		OrderSearchDTO orderSearch = (OrderSearchDTO) req.getSession().getAttribute("orderSearchDTO");
		int orderCount = 0;
		if (orderSearch == null) {
			orderSearch = new OrderSearchDTO(new BigDecimal(start), new BigDecimal(end), "", "", "", "", "");
			orderCount = allOrderCount;
			System.out.println("null이면---" + allOrderCount);
		} else {
			orderSearch.setStart(new BigDecimal(start));
			orderSearch.setEnd(new BigDecimal(end));
			orderCount = ss.getMapper(AdminOrderMapper.class).getOrderCount(orderSearch);
		}

		List<OrderDTO> orders = ss.getMapper(AdminOrderMapper.class).getOrder(orderSearch);
		for (OrderDTO order : orders) {
			ArrayList<TireDTO> order_tires = new ArrayList<TireDTO>();
//			order.getO_product(); 4/2, 6/2
			String splitProduct[] = order.getO_product().split(","); // 1/2,2/2
			for (String product : splitProduct) {
				int tirePK = Integer.parseInt(product.charAt(0) + ""); // 4 , 6
				int tireCount = product.charAt(2);
				List<TireDTO> tireListDto = ss.getMapper(AdminTireMapper.class).getTireGroupforDetail(tirePK);
					for (TireDTO tDto : tireListDto) {
						tDto.setTi_count(Integer.parseInt(product.charAt(2) + ""));
						order_tires.add(tDto);
						
						System.out.println(tDto);
					}
					System.out.println(tireCount);
				
			}
			order.setO_products(order_tires);
			
		}

		int pageCount = (int) Math.ceil(orderCount / (double) count);
		req.setAttribute("orders", orders);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("curPage", pageNo);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("실패---------------------");
		}
	}

	public void updateOrder(HttpServletRequest req, String o_no,String o_step) {
		OrderUpdateDTO ouDTO = new OrderUpdateDTO(o_no, o_step);
		
		if (ss.getMapper(AdminOrderMapper.class).updateOrder(ouDTO) == 1) {
			System.out.println(ouDTO.getO_no());
			System.out.println(ouDTO.getO_step());
			System.out.println("성공!!!!!");
			
		} else {
			System.out.println("실패~~~~~~~");
		}
	}

	public int deleteOrder(HttpServletRequest req, String o_no) {
		if (ss.getMapper(AdminOrderMapper.class).deleteOrder(o_no) == 1) {
			System.out.println("성공!!!!!");
			allOrderCount--;
			/* reg 할때 allOrderCount++; 해주세용 */
			return 1;
		} else {
			System.out.println("실패~~~~~~~");
			return 0;
		}
	}
}
