package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.glassfish.gmbal.ParameterNames;

import entity.Commodity;
import entity.ShopCart;
import entity.ShopCartDetail;

public interface CartDao {

  ShopCart searchCart(int id);
   int searchCartId(int uid);

  void add(@Param("comm")Commodity comm, int cartId,int num, @Param("subtotal")double subtotal);
   void deleteCart(int id, int cartId);
 int  serachCommodityId(int cartId, int id);
  void updateCart(int id,int num);
   int serachCommodityIdNum(int id);
  int  updateNum(Integer num, Integer id,double subtotal);
List<ShopCartDetail> searchSc(@Param("ids")String ids, int cartId);
int deleteCartDetail(@Param("ids")String ids, int cartId);


	
	 
	
	
	
}
