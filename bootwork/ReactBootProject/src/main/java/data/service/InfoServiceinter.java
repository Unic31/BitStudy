package data.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.InfoDto;

public interface InfoServiceinter {
		public void insertInfo(InfoDto dto);
		public void updatePhoto (int num, String photo);
		public List<InfoDto> list();
		public void deleteInfo(int num);
		public InfoDto getData(int num);
		public void updateData(InfoDto dto);
}
