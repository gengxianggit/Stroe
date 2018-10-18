package service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DingDanDao;
import entity.Address;
import entity.Area;
import entity.City;
import entity.Order;
import entity.Province;
import entity.ShopCart;
import entity.ShopCartDetail;
import service.DingDanService;
@Service
public class DingDanServiceImpl implements DingDanService {
@Autowired
DingDanDao dao;
	
	@Override
	public ShopCart searchByIds(String ids, int userId) {
		// TODO Auto-generated method stub
		ShopCart dd= dao.searchByIds(ids,userId);
		return dd;
	}
	@Override
	public List<Province> searchP() {
		// TODO Auto-generated method stub
		List<Province> plist=dao.searchP();
		return plist;
	}
	@Override
	public List<City> searchCity(String name) {
		// TODO Auto-generated method stub
		List<City>clist=dao.searchCity(name);
		
		
		return clist;
	}
	@Override
	public List<Area> searchCounty(String city) {
		// TODO Auto-generated method stub
		 List<Area>alist=dao.searchCounty(city);
		 return alist;
	}
	@Override
	public List<Address> searchAddress(int userId) {
		// TODO Auto-generated method stub
		List<Address> alist=dao.searchAddress(userId);
		return alist;
	}
	@Override
	public boolean addAdress(Address adr,int userId) {
		// TODO Auto-generated method stub
		int rs=dao.addAdress(adr,userId);
		return rs>0;
	}
	@Override
	public  List<Order> searchOrder(int userId) {
		// TODO Auto-generated method stub
		
		 List<Order>order=dao.searchOrder(userId);
		return order;
	}

	@Override
	public int add(Order order) {
		// TODO Auto-generated method stub
	int rs=	dao.addOrder(order);
		return rs;
	}
	@Override
	public boolean addOrderDetail(List<ShopCartDetail> sclist,int oid) {
		// TODO Auto-generated method stub
		int rs=0;
		for(ShopCartDetail sc:sclist) {
			rs=dao.addOrderDetail(sc,oid);
			
			
		}
		
		return rs>0;
	}
	@Override
	public void deleteAddress(int id) {
		// TODO Auto-generated method stub
		dao.deleteAddress(id);
	}
	@Override
	public void deleteod(int id) {
		// TODO Auto-generated method stub
		dao.deleteorder(id);
		dao.deleteorderdetail(id);
		
		
		
	}
	
	
	
	
	
	

}
