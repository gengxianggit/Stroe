package service;

import java.util.List;

import entity.Order;

public interface OrderService {

	List<Order> searchAll();

	Order search(int id);

	List<Order> searchNN(String num, String time);

	boolean updateFauo(int id);

}
