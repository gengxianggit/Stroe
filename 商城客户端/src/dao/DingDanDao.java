package dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Address;
import entity.Area;
import entity.City;
import entity.Order;
import entity.Province;
import entity.ShopCart;
import entity.ShopCartDetail;

public interface DingDanDao {



	ShopCart searchByIds(@Param("ids")String ids, @Param("userId")int userId);

	   List<Province> searchP();

 	 List<City> searchCity(String name);

	List<Area> searchCounty(String city);

	List<Address> searchAddress(int userId);

	int addAdress(@Param("ad")Address adr, int userId);

	List<Order> searchOrder(int userId);

	int addOrder(Order order);

	int addOrderDetail(@Param("sc")ShopCartDetail sc, int oid);

	void deleteAddress(int id);

	void deleteorder(int id);

	void deleteorderdetail(int id);

}
