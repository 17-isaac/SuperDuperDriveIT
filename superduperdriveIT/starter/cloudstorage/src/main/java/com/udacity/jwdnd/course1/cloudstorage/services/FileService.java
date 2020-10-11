package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    Files upload(MultipartFile file, Integer userId);

    List<Files> getAllFilesByUserId(int userId);

    Files getById (Integer fileId);

    void delete(Integer fileId);

    MultipartFile download(Integer fileid);

}
