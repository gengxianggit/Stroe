package service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.BmUser;
import service.UserService;
@Service
public class UserServiceImpl implements UserService {
@Autowired UserDao dao;
	@Override
	public boolean search(BmUser user) {
		
		// TODO Auto-generated method stub
		Integer rs=dao.search(user);
		if(rs!=null) {
		return true;}
		else {
			return false;
		}
	}

}
