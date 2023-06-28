package data.service;

import java.util.HashMap;
import java.util.List;

import data.dto.FoodDto;

public interface FoodServiceinter {
	public void insertFood(FoodDto dto);
	public List<FoodDto> getlist();
	public FoodDto getData(int num);
	public void updatePhoto(String fphoto, int num);
	public void updateInfo(FoodDto dto);
	public void deleteData(int num);
}
