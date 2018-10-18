package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductionDao;
import entity.Img;
import entity.Production;
import service.ProductionService;
@Service
public class ProductionServiceImpl implements ProductionService{
@Autowired ProductionDao pDao;

@Override
public List<Production> searchAll() {
	// TODO Auto-generated method stub
	List<Production> pList=pDao.searchAll();

	
	return pList;
}

@Override
public boolean deleteById(int id) {
	// TODO Auto-generated method stub
	int rs=pDao.deleteById(id);
	rs=pDao.deleteByIdImg(id);
	return rs>0;
}

@Override
public boolean add(Production pro) {
	
	// TODO Auto-generated method stub
	int rs=pDao.add(pro);
	rs=pDao.addImgPId(pro.getId());
	return rs>0;
}

@Override
public boolean deleteByIds(String ids) {
	// TODO Auto-generated method stub
	int rs=pDao.deleteByIds(ids);
	rs=pDao.deleteByIdsImg(ids);
	return rs>0;
}

@Override
public void addImg(List<Img> list) {
	// TODO Auto-generated method stub
	for(Img img:list) {
		pDao.addImg(img);	
		
	}
	
}

@Override
public void deleteImg(String path) {
	// TODO Auto-generated method stub
	pDao.deleteImg(path);
}

@Override
public Production searchProduction(int id) {
	// TODO Auto-generated method stub
	Production pro=pDao.searchProduction(id);
	return pro;
}

@Override
public void updateProduction(Production pro) {
	// TODO Auto-generated method stub
	pDao.updateProduction(pro);
	pDao.addImgPId(pro.getId());
	
}

@Override
public List<Production> search(String name) {
	// TODO Auto-generated method stub
	List<Production> pList=pDao.search(name);
	return pList;
	
}

@Override
public boolean updateImg(Img img) {
	// TODO Auto-generated method stub
	int rs=pDao.updateImgOrder(img);
	
	return rs>0;
}

@Override
public void deleteLing() {
	// TODO Auto-generated method stub
	pDao.deleteLing();
}

@Override
public List<Img> searchImg(String ids) {
	// TODO Auto-generated method stub
	List<Img> list=pDao.searchImg(ids);
	return list;
}

@Override
public int searchUser() {
	// TODO Auto-generated method stub
	int count=pDao.searchAllUser();
	return count;
}

@Override
public int searchOrderCount() {
	int count=pDao.searchAllOrder();
	return count;
}

@Override
public int searchPayCount() {
	int count=pDao.searchAllPay();
	return count;
}

}
