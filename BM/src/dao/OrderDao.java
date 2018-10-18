package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Order;

public interface OrderDao {

	List<Order> searchAll();

	Order search(int id);

	List<Order> searchNN(@Param("num")String num, @Param("time")String time);

	int updateFauo(int id);

	
	
}
