package boot.study.mapper;

import boot.study.dto.GuestDto;
import boot.study.dto.GuestPhotoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuestMapper {
    public void insertGuest(GuestDto dto);
    public void insertPhoto(GuestPhotoDto dto);
    public List<GuestDto> getAllGuest();
    public List<GuestPhotoDto> getPhotos(int guest_idx);

    public void deletePhoto(int photo_idx);
    public void deleteAllPhoto(int guest_idx); //on delete cascade 설정시 필요없음
    public void deleteGuest(int guest_idx);
    public String getSelectPhoto(int photo_idx);
    public List<String> getAllPhoto(int guest_idx);



}
