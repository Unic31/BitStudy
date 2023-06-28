package mycar.controller;

import mycar.data.MyCarDao;
import mycar.data.MyCarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyCarRestController {

    @Autowired
    MyCarDao mycarDao;

    @GetMapping("/list")
    public List<MyCarDto> list(int idx){
        //idx-1:고가순, 2:저가순, 3:등록순
        return mycarDao.getSortCars(idx);

    }
}
