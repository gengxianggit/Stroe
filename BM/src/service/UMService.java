package service;

import java.util.List;

import entity.BmUser;

public interface UMService {

	List<BmUser> searchAll();

	List<BmUser> searchName(String name);

	boolean deleteUser(String ids);

	void add(BmUser user);



}
