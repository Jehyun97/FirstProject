package com.java.service.food;

import java.util.List;

import com.java.command.Criteria;
import com.java.dto.food.FoodVO;


public interface FoodService {
	
	public List<FoodVO> getFoodList(Criteria cri)throws Exception;
	
	public FoodVO getFood(String fcode)throws Exception;

	public void regist(FoodVO food)throws Exception;

	public void modify(FoodVO food)throws Exception;
	
	public void remove(String fcode)throws Exception;
	

}
