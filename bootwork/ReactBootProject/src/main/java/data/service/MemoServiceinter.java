package data.service;

import java.util.List;

import data.dto.MemoDto;

public interface MemoServiceinter {
	public void insertMemo(MemoDto dto);
	public List<MemoDto> getAllMemos(String keyword);
	public void updateMemo(MemoDto dto);
	public void deleteMemo(int num);
}
