package service;

import java.util.List;

import entity.Address;
import entity.Area;
import entity.City;
import entity.Order;
import entity.Province;
import entity.ShopCart;
import entity.ShopCartDetail;

public interface DingDanService {

	int add(Order order);

	ShopCart searchByIds(String ids, int userId);

	List<Province> searchP();

	List<City> searchCity(String name);

	List<Area> searchCounty(String city);

	List<Address> searchAddress(int userId);

	boolean addAdress(Address adr, int userId);

	List<Order> searchOrder(int userId);

	boolean addOrderDetail(List<ShopCartDetail> sclist, int oid);

	

	void deleteAddress(int id);

	void deleteod(int id);






}
