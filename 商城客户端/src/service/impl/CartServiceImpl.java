package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CartDao;
import entity.Commodity;
import entity.ShopCart;
import entity.ShopCartDetail;
import service.CartService;

@Service
public class CartServiceImpl implements CartService {
@Autowired
CartDao cartDao;
	@Override
	public ShopCart searchCart(int id) {
		// TODO Auto-generated method stub
		ShopCart cart= cartDao.searchCart(id);
		
		
		return cart;
	}

	@Override
	public void add(Commodity comm, int cartId,int num,double subtotal) {
		// TODO Auto-generated method stub
		cartDao.add(comm,cartId,num,subtotal);
	}

	@Override
	public int searchCartId(int uid) {
		// TODO Auto-generated method stub
		int cartId=cartDao.searchCartId(uid);
		return cartId;
	}

	@Override
	public void deleteCart(int id,int cartId) {
		// TODO Auto-generated method stub
		cartDao.deleteCart(id,cartId);
	}

	@Override
	public boolean serachCommodityId(int cartId, int id) {
		// TODO Auto-generated method stub
		int  rs=cartDao.serachCommodityId(cartId,id);
		return rs>0;
	}

	@Override
	public void updateCart(int id,int num) {
		// TODO Auto-generated method stub
		cartDao.updateCart( id,num);
		
	}

	@Override
	public int  serachCommodityIdNum(int id) {
		// TODO Auto-generated method stub
		int  rs=cartDao.serachCommodityIdNum(id);
	
		return rs;
	}

	@Override
	public int updateNum(Integer num, Integer id,double subtotal) {
		// TODO Auto-generated method stub
		int rs =cartDao.updateNum(num,id,subtotal);
		return rs;
	
	}

	@Override
	public void updateSumcount(double sumCount) {
		// TODO Aut-o-generated method stub
		
	}

	@Override
	public List<ShopCartDetail> searchSc(String ids, int cartId) {
		// TODO Auto-generated method stub
		
		 List<ShopCartDetail> sclist=cartDao.searchSc(ids,cartId);
		return sclist;
	}

	@Override
	public boolean deleteCartDetail(String ids, int cartId) {
		// TODO Auto-generated method stub
		int rs=cartDao.deleteCartDetail(ids,cartId);
		return rs>0;
	}


}
