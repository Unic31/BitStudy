package mycar.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyCarDao{

    @Autowired
    MycarDaoInter carDao;

    //전체 갯수 반환
    public Long getTotalCount(){
        return carDao.count();
    }

    //insert
    public void insertCar(MyCarDto dto){
        carDao.save(dto);//num값 유무에 따라 insert 또는 update 실행
    }

    //list
    public List<MyCarDto> getAllCars(){
        //return carDao.findAll();//입력 순서대로 출력

        //가격이 비싼거부터 출력
        return  carDao.findAll(Sort.by(Sort.Direction.DESC,"carprice"));
    }

    //detail
    public MyCarDto getMyCar(Long num){
        return carDao.getReferenceById(num);
    }

    //update
    public void updateCar(MyCarDto dto){
        carDao.save(dto); //이번엔 num이 포함되므로 수정해준다
    }

    //delete
    public void deleteCar(Long num){
        carDao.deleteById(num);
    }

    //list
    public List<MyCarDto> getSortCars(int idx) {
        if (idx == 1)
            return carDao.findAll(Sort.by(Sort.Direction.DESC, "carprice"));
        else if (idx == 2)
            return carDao.findAll(Sort.by(Sort.Direction.ASC, "carprice"));
        else
            return carDao.findAll();
    }
}
