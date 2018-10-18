package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrderDao;
import entity.Order;
import service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
@Autowired OrderDao od;
	@Override
	public List<Order> searchAll() {
		// TODO Auto-generated method stub
		List<Order>olist=od.searchAll();
		return olist;
	}
	@Override
	public Order search(int id) {
		// TODO Auto-generated method stub
		Order order=od.search(id);
		return order;
		
	}
	@Override
	public List<Order> searchNN(String num, String time) {
		// TODO Auto-generated method stub
		List<Order>olist=od.searchNN(num,time);
		return olist;
	}
	@Override
	public boolean updateFauo(int id) {
		// TODO Auto-generated method stub
		
		int rs=od.updateFauo(id);
		return rs>0;
	}

}
