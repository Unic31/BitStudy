package boot.study.service;

import boot.study.dto.GuestDto;
import boot.study.dto.GuestPhotoDto;

import java.util.List;

public interface GuestServiceInter {
    public void insertGuest(GuestDto dto);
    public void insertPhoto(GuestPhotoDto dto);
    public List<GuestDto> getAllGuest();
    public List<GuestPhotoDto> getPhotos(int guest_idx);

    public void deletePhoto(int photo_idx);
    public void deleteAllPhoto(int guest_idx);
    public void deleteGuest(int guest_idx);
    public String getSelectPhoto(int photo_idx);
    public List<String> getAllPhoto(int guest_idx);
}
