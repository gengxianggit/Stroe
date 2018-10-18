package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Img;
import entity.Production;

public interface ProductionDao {

	public List<Production>searchAll();

	public int deleteById(int id);

	public int deleteByIdImg(int id);

	public int add(Production pro);

	

	public int deleteByIdsImg(@Param("ids")String ids);

	public int deleteByIds(@Param("ids")String ids);

	public void addImg(Img img);
	public int addImgPId(int id);
	public void deleteImg(@Param("path")String path);

	public Production searchProduction(int id);

	public void updateProduction(Production pro);

	public List<Production> search(@Param("name")String name);

	public int updateImgOrder(Img img);

	public void dleteLing();

	public void deleteLing();

	public List<Img> searchImg(@Param("ids")String ids);

	public int searchAllUser();

	public int searchAllOrder();

	public int searchAllPay();
	
}
