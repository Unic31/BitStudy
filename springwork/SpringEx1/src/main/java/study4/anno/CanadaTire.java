package study4.anno;

import org.springframework.stereotype.Component;

//@Component : xml없이 자동으로 bean등록(id는 자동으로 canadaTire //클래스명과 똑같지만 첫글자가 소문자)
//@Component("cTire") : id가 cTire가 된다
@Component
public class CanadaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "캐나다타이어";
		
	}

}
