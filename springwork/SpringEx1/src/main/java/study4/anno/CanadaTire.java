package study4.anno;

import org.springframework.stereotype.Component;

//@Component : xml���� �ڵ����� bean���(id�� �ڵ����� canadaTire //Ŭ������� �Ȱ����� ù���ڰ� �ҹ���)
//@Component("cTire") : id�� cTire�� �ȴ�
@Component
public class CanadaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "ĳ����Ÿ�̾�";
		
	}

}
