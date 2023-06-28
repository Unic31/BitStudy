package boot.study.controller;

import boot.study.dto.ShopDto;
import boot.study.mapper.ShopMapper;
import naver.cloud.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopMapper shopMapper;

    //버켓이름
    private String bucketName="bit701-bucket-113";//각자 자기 버켓이름
    //private String bucketName="bit701-bucket-56";//쌤꺼

    @Autowired
    private NcpObjectStorageService storageService;


    @GetMapping("/list")
    public String list(Model model){
        //총 상품갯수 출력
        int totalCount=shopMapper.getTotalCount();
        //전체 데이터 가져오기
        List<ShopDto> list=shopMapper.getAllSangpums();

        //model에 저장
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("list",list);
        return "/main/shop/shoplist";
    }
    @GetMapping("/list2")
    public String list2(Model model){
        //총 상품갯수 출력
        int totalCount=shopMapper.getTotalCount();
        //전체 데이터 가져오기
        List<ShopDto> list=shopMapper.getAllSangpums();

        //model에 저장
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("list",list);
        return "/main/shop/shoplist2";
    }
    @GetMapping("/shopform")
    public String form(){
        return "/main/shop/shopform";
    }
    @PostMapping("/insert")
    public String insert(ShopDto dto, MultipartFile upload){
        //네이버 클라우드의 버켓에 사진 업로드 하기
        String photo=storageService.uploadFile(bucketName,"shop",upload);
        //반환된 암호화된 파일명을 dto에 넣기
        dto.setPhoto(photo);

        //db insert
        shopMapper.insertShop(dto);

        return "redirect:list";
    }
    @GetMapping("/detail")
    public String detail(int num, Model model){

        ShopDto dto = shopMapper.getSangpum(num);

        model.addAttribute("dto",dto);

        return "/main/shop/shopdetail";
    }
    @PostMapping("/photochange")
    @ResponseBody public String changePhoto(MultipartFile upload, int num){
        //s3 스토리지에 업로드된 기존 파일 지우기
        String fileName=shopMapper.getSangpum(num).getPhoto();
        storageService.deleteFile(bucketName, "shop", fileName);

        //네이버 클라우드의 버켓에 사진 업로드하기
        String photo=storageService.uploadFile(bucketName, "shop", upload);
        Map<String, Object> map=new HashMap<>();
        map.put("photo", photo);
        map.put("num", num);

        shopMapper.updatePhoto(map);
        return photo;
    }
    @GetMapping("/update")
    @ResponseBody public void changeShop(ShopDto dto)
    {
        shopMapper.updateShop(dto);
    }

    @GetMapping("/delete")
    public String deleteShop(int num)
    {
        //s3 스토리지에 업로드된 기존 파일 지우기
        String fileName=shopMapper.getSangpum(num).getPhoto();
        storageService.deleteFile(bucketName, "shop", fileName);

        //db 삭제
        shopMapper.deleteShop(num);

        return "redirect:list";
    }


}
