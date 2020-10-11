package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("insert into files (filename, contenttype, filesize, filedata, userid) values " +
            "(#{file.filename}, #{file.contenttype}, #{file.filesize}, #{file.filedata},#{file.userid})")
    Integer save(@Param("file") Files file);

    @Select("select * from files where files.userid = #{userId}")
    List<Files> findAllByUserId(@Param("userId") Integer userId);

    @Delete("delete from files where fileid = #{fileid}")
    void deleteById(@Param("fileid") Integer fileid);

    @Select("select * from files where fileid = #{fileid}")
    Files findById(@Param("fileid") Integer fileid);
}
