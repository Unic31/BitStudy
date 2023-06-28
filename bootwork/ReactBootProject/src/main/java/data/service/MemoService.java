package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.MemoDto;
import data.mapper.MemoMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemoService implements MemoServiceinter {
	
	MemoMapper memoMapper;

	@Override
	public void insertMemo(MemoDto dto) {
		// TODO Auto-generated method stub
		memoMapper.insertMemo(dto);
	}

	@Override
	public List<MemoDto> getAllMemos(String keyword) {
		// TODO Auto-generated method stub
		return memoMapper.getAllMemos(keyword);
	}

	@Override
	public void updateMemo(MemoDto dto) {
		// TODO Auto-generated method stub
		memoMapper.updateMemo(dto);
	}

	@Override
	public void deleteMemo(int num) {
		// TODO Auto-generated method stub
		memoMapper.deleteMemo(num);
	}

}
