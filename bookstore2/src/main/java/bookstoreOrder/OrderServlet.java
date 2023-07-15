package bookstoreOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstoreCart.Cart;
import bookstoreCart.CartItem;
import bookstoreUser.User;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private OrderService orderService = new OrderService();
	
	/**
	 * 添加订单
	 * 把session中的车用来生成Order对象
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 从session中得到cart
		 * 2. 使用cart生成Order对象
		 * 3. 调用service方法完成添加订单
		 * 4. 保存order到request域中，转发到/jsps/order/desc.jsp
		 */
		// 从session中获取cart
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		// 把cart转换成Order对象
		/*
		 * 创建Order对象，并设置属性
		 * 
		 * Cart --> Order
		 */
		Order order = new Order();
		order.setOid(CommonUtils.uuid());//设置编号
		order.setOrdertime(new Date());//设置下单时间
		order.setState(1);//设置订单状态为1，表示未付款
		User user = (User)request.getSession().getAttribute("session_user");
		order.setOwner(user);//设置订单所有者
		order.setTotal(cart.getTotal());//设置订单的合计，从cart中获取合计
		
		/*
		 * 创建订单条目集合
		 * 
		 * cartItemList --> orderItemList
		 */
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		// 循环遍历Cart中的所有CartItem，使用每一个CartItem对象创建OrderItem对象，并添加到集合中
		for(CartItem cartItem : cart.getCartItems()) {
			OrderItem oi = new OrderItem();//创建订单条目
			
			oi.setIid(CommonUtils.uuid());//设置条目的id
			oi.setCount(cartItem.getCount());//设置条目的数量
			oi.setBook(cartItem.getBook());//设置条目的图书
			oi.setSubtotal(cartItem.getSubtotal());//设置条目的小计
			oi.setOrder(order);//设置所属订单
			
			orderItemList.add(oi);//把订单条目添加到集合中
		}
		
		// 把所有的订单条目添加到订单中
		order.setOrderItemList(orderItemList);
		
		// 清空购物车
		cart.clear();
		
		//////////////////////////////////////////////
		
		/*
		 * 3. 调用orderService添加订单
		 */
		orderService.add(order);
		/*
		 * 4. 保存order到request域，转发到/jsps/order/desc.jsp
		 */
		request.setAttribute("order", order);
		return "/jsps/order/desc.jsp";
	}
}
