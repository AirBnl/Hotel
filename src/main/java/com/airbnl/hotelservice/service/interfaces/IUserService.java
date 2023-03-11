package com.airbnl.hotelservice.service.interfaces;

import com.airbnl.hotelservice.model.User;

public interface IUserService {
    User save(User user);
    User getByUserName(String username,String password);
}
