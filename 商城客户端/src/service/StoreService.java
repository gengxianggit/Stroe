package service;

import java.util.List;

import entity.Commodity;

public interface StoreService {

	int searchCount(Commodity comm,Integer min,Integer max);

	

	List<Commodity> search(Commodity comm,Integer min,Integer max, int begin, int empNumInPage);
	List<Commodity> search1(Commodity comm,Integer min,Integer max, int begin, int empNumInPage);



	List<Commodity> searchById(Integer id);




}
