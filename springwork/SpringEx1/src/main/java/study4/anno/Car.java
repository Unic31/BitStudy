package study4.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	//Tire tire;

	//���� Ÿ���� ã�Ƽ� �ڵ� �������ش�
	@Autowired
	KoreaTire tire;
	
	
	public void myCarTire() {
		System.out.println("�� ���� Ÿ�̾�� "+tire.getTireName());
	}
	
}
