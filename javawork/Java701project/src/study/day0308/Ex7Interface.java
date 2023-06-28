package study.day0308;

//데이타 클래스(data transfer object)
class BoardDTO {
	private String writer;
	private String subjetc;

	BoardDTO() {

	}

	public BoardDTO(String writer, String subjetc) {
		super();
		this.writer = writer;
		this.subjetc = subjetc;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubjetc() {
		return subjetc;
	}

	public void setSubjetc(String subjetc) {
		this.subjetc = subjetc;
	}

}

//dao class(Data Access Object:데이터 로직 처리를 이한 클래스:CRUD)
class BoardDAO implements BoardDAOInter {

	@Override
	public void insert(BoardDTO dto) {
		// TODO Auto-generated method stub
		System.out.println(dto.getWriter()+" 님의 글 "+dto.getSubjetc()+"를 DB에 추가함");
	}

	@Override
	public void delete(String writer) {
		// TODO Auto-generated method stub
		System.out.println(writer+"님의 글을 삭제함");
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("전체 게시글 조회");
	}

	@Override
	public void update(String writer) {
		// TODO Auto-generated method stub
		System.out.println(writer+"님의 글을 수정함");
	}

}

//데이터 처리에 대한 할 일을 미리 인터페이스로 만든다
interface BoardDAOInter {
	public void insert(BoardDTO dto);

	public void delete(String writer);

	public void list();

	public void update(String wirter);
}

public class Ex7Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDAOInter dao=new BoardDAO();
		
		dao.insert(new BoardDTO("이영자","안녕하세요"));
		dao.delete("이영자");
		dao.update("이영자");
		dao.list();
	}

}
