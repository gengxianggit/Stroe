package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UMDao;
import entity.BmUser;
import service.UMService;
@Service
public class UMServiceImpl implements UMService {
 
@Autowired UMDao umDao;
	@Override
	public List<BmUser> searchAll() {
		// TODO Auto-generated method stub
		List<BmUser>umList=umDao.searchAll();
		return umList;
	}
	@Override
	public List<BmUser> searchName(String name) {
		// TODO Auto-generated method stub
		List<BmUser>umList=umDao.searchName(name);
		return umList;
		
	}
	@Override
	public boolean deleteUser(String ids) {
		// TODO Auto-generated method stub
		int rs=umDao.delete(ids);
		return rs>0;
	}
	@Override
	public void add(BmUser user) {
		// TODO Auto-generated method stub
		umDao.add(user);
	}

}
