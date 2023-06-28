package data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Service;

import data.dto.FoodDto;
import data.mapper.FoodMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FoodService implements FoodServiceinter {
	
	private FoodMapper foodMapper;

	@Override
	public void insertFood(FoodDto dto) {
		// TODO Auto-generated method stub
		foodMapper.insertFood(dto);
	}


//	@Override
//	public List<FoodDto> getlist() {
//		// TODO Auto-generated method stub
//		List<FoodDto> list = foodMapper.getlist();
//		for(FoodDto dto : list) {
//			StringTokenizer st = new StringTokenizer(dto.getFphoto(),",");
////			dto.setFphoto(dto.getFphoto().split(",")[0]);
//			dto.setFphoto(st.nextToken());
//		}
//		return list;
//	}
	
	@Override
	public List<FoodDto> getlist() {
		// TODO Auto-generated method stub
		return foodMapper.getlist();
	}


	@Override
	public FoodDto getData(int num) {
		// TODO Auto-generated method stub
		return foodMapper.getData(num);
	}


	@Override
	public void updatePhoto(String fphoto, int num) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<>();
		map.put("fphoto", fphoto);
		map.put("num", num);
		foodMapper.updatePhoto(map);
		//foodMapper.updatePhoto(fphoto, num);
		
	}


	@Override
	public void updateInfo(FoodDto dto) {
		// TODO Auto-generated method stub
		foodMapper.updateInfo(dto);
	}


	@Override
	public void deleteData(int num) {
		// TODO Auto-generated method stub
		foodMapper.deleteData(num);
	}

}
