package com.udacity.jwdnd.course1.cloudstorage.model;

import lombok.Data;

@Data
public class Files {
    private int fileid;
    private String filename;
    private String contenttype;
    private Long filesize;
    private byte[] filedata;
    private Integer userid;

    public byte[] getFiledata() {
        return filedata;
    }

    public String getFilename() {
        return filename;
    }

    public Long getFilesize() {
        return filesize;
    }

    public String getContenttype() {
        return contenttype;
    }
}
