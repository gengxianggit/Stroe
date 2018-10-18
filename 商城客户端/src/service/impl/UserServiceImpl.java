package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;
import service.UserService;
@Service

public class UserServiceImpl implements UserService{
@Autowired
UserDao userDao;
@Override
public boolean addUser(User user) {
	Integer rs=userDao.addUser(user);
	
		if (rs!=null) {
			return true;
			
		}else {
			
			return false;
		}
	}
@Override
public boolean doLogin(User user) {
	// TODO Auto-generated method stub
	Integer rs=userDao.doLogin(user);
	if (rs!=null) {
		return true;
		
	}else {
		
		return false;
	}
}
@Override
public int searchId(String UserName) {
	// TODO Auto-generated method stub
	int id=userDao.searchId(UserName);
	return id;
}
@Override
public void addCart(int id) {
	// TODO Auto-generated method stub
	userDao.addCart(id);
}




}
