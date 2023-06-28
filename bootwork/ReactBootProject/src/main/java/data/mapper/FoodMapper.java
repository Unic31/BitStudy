package data.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.FoodDto;

@Mapper
public interface FoodMapper {
	public void insertFood(FoodDto dto);
	public List<FoodDto> getlist();
	public FoodDto getData(int num);
	//public void updatePhoto(String fphoto, int num);
	public void updatePhoto(HashMap<String, Object> map);
	public void updateInfo(FoodDto dto);
	public void deleteData(int num);
}
