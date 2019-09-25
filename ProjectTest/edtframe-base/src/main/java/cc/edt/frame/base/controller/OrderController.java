package cc.edt.frame.base.controller;

import cc.edt.frame.base.service.OrderService;
import cc.edt.frame.common.controller.BaseController;
import cc.edt.frame.model.entity.base.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Resource
	private OrderService orderService;

	@RequestMapping("/getOrderById")
	public String getOrderById(Order order, Model model){
		System.out.println("getOrderById:"+order.getOrderId());
		order = orderService.getOrderById(order.getOrderId());
		System.out.println(order.toString());
		model.addAttribute(order);
		return "order/orderInfo";
	}

	@RequestMapping("/saveOrder")
	public String saveOrder(Order order, Model model) {
		System.out.println("新增页面提交取值："+order.toString());
		//主键自增
		order.setOrderId(0);
		orderService.saveOrder(order);
		model.addAttribute("success","true");
		model.addAttribute("message","新增成功！");
		model.addAttribute("order",order);
		writerToPageByJson(model);
		return "order/orderInfo";
	}

	@RequestMapping("/deleteOrder")
	public String deleteOrder(Order order, Model model) {
		orderService.deleteOrder(order.getOrderId());
		model.addAttribute("message","删除成功！");
		writerToPageByJson(model);
		return "order/order";
	}

	@RequestMapping("/updateOrder")
	public String updateOrder(Order order, Model model) {
		System.out.println("--------------updateOrder-------");
		System.out.println(order.toString());
		orderService.updateOrder(order);
		order = orderService.getOrderById(order.getOrderId());
		model.addAttribute("message","修改成功！");
		model.addAttribute("order",order);
		writerToPageByJson(model);
		return "order/orderInfo";
	}

    @ResponseBody
	@RequestMapping("/getAllOrder")
	public void getAllOrder() {
		List<Order> list = orderService.getAllOrder();
		for(Order order:list){
			System.out.println(order.getOrderId()+","+order.getOrderName()+","+order.getOrderTime()+","+order.getOrderMoney()+","+order.getOrderDescription());
		}
		/*return new ModelAndView("redirect:order","allOrderList",list);*/
		Map<String, Object> map = new HashMap<>();
		map.put("data",list);
		writerToPageByJson(map);
	}

}
