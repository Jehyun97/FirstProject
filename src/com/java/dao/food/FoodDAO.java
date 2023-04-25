package com.java.dao.food;

import java.sql.SQLException;
import java.util.List;

import com.java.command.Criteria;
import com.java.dto.food.FoodVO;


public interface FoodDAO {

	List<FoodVO> selectFoodList(Criteria cri) throws SQLException;

	FoodVO selectFoodByFcode(String fcode) throws SQLException;

	void insertFood(FoodVO food) throws SQLException;

	void updateFood(FoodVO food) throws SQLException;

	void deleteFood(String fcode) throws SQLException;

}
