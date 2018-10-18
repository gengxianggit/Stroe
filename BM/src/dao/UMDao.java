package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.BmUser;

public interface UMDao {

	List<BmUser> searchAll();

	List<BmUser> searchName(@Param("name")String name);

	int delete(@Param("ids")String ids);

	void add(BmUser user);

}
