package data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.dto.TestDto;
import data.mapper.TestMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin
public class TestController {
	
	private TestMapper testMapper;
	
	@PostMapping("/test/insert")
	public String insert(@RequestBody TestDto dto)//json->dto로 변환
	{
		System.out.println("react>>"+dto); //Data썻기때문에 toString생략해도 출력된다
		testMapper.testInsert(dto);
		return "success";
	}
	
	@GetMapping("/test/list")
	public List<TestDto> list(){
		System.out.println("react>>list");
		return testMapper.getAllDatas();
	}
	
	//파라미터로 num값 받을때
//	@DeleteMapping("/test/delete")
//	public String delete(@RequestParam int num) {
//		System.out.println("delete>>"+num);
//		testMapper.testDelete(num);
//		return "success";
//	}
	
	//url로 num값 받을때
	@DeleteMapping("/test/delete/{num}")
	public String delete(@PathVariable int num) {
		System.out.println("delete>>"+num);
		testMapper.testDelete(num);
		return "success";
	}
}
