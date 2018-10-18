package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StoreDao;
import entity.Commodity;
import service.StoreService;
@Service
public class StoreServiceImpl implements StoreService{
@Autowired
StoreDao dao;
public int searchCount(Commodity comm, Integer min, Integer max) {
		// TODO Auto-generated method stub
		int count=dao.searchCount(comm, min, max);
		  return count;
	}

	@Override
	public List<Commodity> search(Commodity comm, Integer min,Integer max,int begin, int empNumInPage) {
		// TODO Auto-generated method stub
		List<Commodity> commList=dao.search(comm, min, max, begin, empNumInPage);
		return commList;
	}

	@Override
	public List<Commodity> search1(Commodity comm, Integer min, Integer max, int begin, int empNumInPage) {
		// TODO Auto-generated method stub
		List<Commodity> commList=dao.search1(comm, min, max, begin, empNumInPage);
		return commList;
	}

	@Override
	public List<Commodity> searchById(Integer id) {
		// TODO Auto-generated method stub
		List<Commodity> commList=dao.searchById(id);
		return commList;
	}



	



}
