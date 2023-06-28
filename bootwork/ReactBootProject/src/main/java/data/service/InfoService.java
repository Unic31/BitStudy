package data.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.InfoDto;
import data.mapper.InfoMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InfoService implements InfoServiceinter {

	private InfoMapper infoMapper;
	
	@Override
	public void insertInfo(InfoDto dto) {
		// TODO Auto-generated method stub
		infoMapper.insertInfo(dto);
	}

	@Override
	public void updatePhoto(int num, String photo) {
		// TODO Auto-generated method stub
		HashMap<String, Object>map=new HashMap<>();
		map.put("num", num);
		map.put("photo", photo);
		infoMapper.updatePhoto(map);
	}

	@Override
	public List<InfoDto> list() {
		// TODO Auto-generated method stub
		return infoMapper.list();
	}

	@Override
	public void deleteInfo(int num) {
		// TODO Auto-generated method stub
		infoMapper.deleteInfo(num);
	}

	@Override
	public InfoDto getData(int num) {
		// TODO Auto-generated method stub
		return infoMapper.getData(num);
	}

	@Override
	public void updateData(InfoDto dto) {
		// TODO Auto-generated method stub
		infoMapper.updateData(dto);
	}

}
