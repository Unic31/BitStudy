package boot.study.service;

import boot.study.dto.BoardDto;

import java.util.List;
import java.util.Map;

public interface BoardServiceInter {
    public int getMaxNum();
    public int getTotalCount();
    public void updateStep(int ref, int step); //ref, step
    public void insertBoard(BoardDto dto);
    public List<BoardDto> getPagingList(int start, int perpage); //map:start,perpage
    public void updateReadcount(int num);
    public BoardDto getData(int num);
    public boolean isEqualPass(int num, String pass);
    public void deleteBoard(int num);
    public void updateBoard(BoardDto dto);

}
