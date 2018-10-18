package service;

import java.util.ArrayList;
import java.util.List;

import entity.Img;
import entity.Production;


public interface ProductionService {

 List<Production> searchAll();

boolean deleteById(int id);

boolean add(Production pro);

boolean deleteByIds(String ids);

void addImg(List<Img> list);

void deleteImg(String path);

Production searchProduction(int id);

void updateProduction(Production pro);

List<Production> search(String name);

boolean updateImg(Img img);

void deleteLing();

List<Img> searchImg(String ids);

int searchUser();

int searchOrderCount();

int searchPayCount();

}
