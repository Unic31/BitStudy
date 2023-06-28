package data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.InfoDto;
import data.service.InfoServiceinter;
import naver.cloud.NcpObjectStorageService;

@RestController
@CrossOrigin
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	private InfoServiceinter infoService;
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	//버켓이름지정
	private String bucketName="bit701-bucket-113";
	
	//버켓 경로
	//String bucketPath="https://kr.object.ncloudstorage.com/bit701-bucket-113/react/";
	
	@PostMapping("/insert")
	public InfoDto insertInfo(@RequestBody InfoDto dto) {
		System.out.println("insert>>"+dto);
		infoService.insertInfo(dto);
		System.out.println("insert된 num값="+dto.getNum());
		return dto;
	}
	
	@PostMapping("/photo")
	public String updatePhoto(@RequestParam int num, @RequestParam MultipartFile upload) {
		System.out.println("update>>"+num+">>"+upload.getOriginalFilename());
		//스토리지에 사진을 업로드 후 업로드된 이름을 반환
		String uploadName=storageService.uploadFile(bucketName, "react", upload);
		//사진 수정
		infoService.updatePhoto(num, uploadName);
		//사진 경로 반환
		return uploadName;
		
	}
	@GetMapping("/list")
	public List<InfoDto> list(){
		System.out.println("list>>");
		return infoService.list();
	}
	@DeleteMapping("/delete/{num}")
	public void deleteInfo(@PathVariable int num) {
		System.out.println("delete>>"+num);
		//num에 해당하는 이미지명 얻기
		String photo=infoService.getData(num).getPhoto();
		//bucket에서 삭제
		storageService.deleteFile(bucketName, "react", photo);
		//db에서 데이터 삭제
		infoService.deleteInfo(num);
	}
	
	@PostMapping("/update")
	public void updateInfo(@RequestBody InfoDto dto) {
		System.out.println("update>>"+dto);
		infoService.updateData(dto);
	}
	
}
