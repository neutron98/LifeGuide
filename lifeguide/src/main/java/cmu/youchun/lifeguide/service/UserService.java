package cmu.youchun.lifeguide.service;

import cmu.youchun.lifeguide.BusinessException;
import cmu.youchun.lifeguide.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface UserService {
    UserModel getUser(Integer id);

    UserModel register(UserModel registerUser) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;

    Integer countAll();

    UserModel login(String phone, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException;

}
