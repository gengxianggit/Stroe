package service;

import java.util.List;

import entity.Commodity;
import entity.ShopCart;
import entity.ShopCartDetail;

public interface CartService {

 ShopCart searchCart(int id);

  void add(Commodity comm, int cartId,int num, double subtotal);

int searchCartId(int uid);

 void deleteCart(int id, int cartId);

boolean serachCommodityId(int cartId, int id);

void updateCart(int id,int num);

int  serachCommodityIdNum(int id);

int updateNum(Integer num, Integer id,double subtotal);

void updateSumcount(double sumCount);

List<ShopCartDetail> searchSc(String ids, int cartId);

boolean deleteCartDetail(String ids, int cartId);



}
