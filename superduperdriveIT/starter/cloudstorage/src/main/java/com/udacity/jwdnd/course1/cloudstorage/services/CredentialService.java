package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;

import java.util.List;

public interface CredentialService {
    Integer save(Credentials credential, Integer userid);

    Integer update(Credentials credential);

    Credentials getById(Integer credentialid);

    void deleteById(Integer credentialid);

    List<Credentials> getAllByUserid(Integer userid);

    String getDecryptedPW(Integer credentialid);

}