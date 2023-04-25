package com.java.service.food;

import java.util.List;

import com.java.command.Criteria;
import com.java.dao.food.FoodDAO;
import com.java.dao.food.FoodDAOImpl;
import com.java.dto.food.FoodVO;

public class FoodServiceImpl implements FoodService {

	private FoodDAO foodDAO = new FoodDAOImpl();

	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}

	@Override
	public List<FoodVO> getFoodList(Criteria cri) throws Exception {
		List<FoodVO> foodList = foodDAO.selectFoodList(cri);
		return foodList;
	}

	@Override
	public FoodVO getFood(String fcode) throws Exception {
		FoodVO food = foodDAO.selectFoodByFcode(fcode);
		return food;
	}

	@Override
	public void regist(FoodVO food) throws Exception {
		foodDAO.insertFood(food);

	}

	@Override
	public void modify(FoodVO food) throws Exception {
		foodDAO.updateFood(food);

	}

	@Override
	public void remove(String fcode) throws Exception {
		foodDAO.deleteFood(fcode);

	}

}
