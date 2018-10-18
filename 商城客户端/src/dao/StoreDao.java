package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Commodity;


public interface StoreDao {
	
	
int searchCount(@Param("c")Commodity comm,@Param("min")Integer min,@Param("max")Integer max);
List<Commodity> search(@Param("c")Commodity comm,@Param("min")Integer min,@Param("max")Integer max ,int begin, int empNumInPage);
List<Commodity> search1(@Param("c")Commodity comm,@Param("min")Integer min,@Param("max")Integer max ,int begin, int empNumInPage);
List<Commodity> searchById(Integer id);

}
