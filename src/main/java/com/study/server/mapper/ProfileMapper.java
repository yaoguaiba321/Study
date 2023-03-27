package com.study.server.mapper;


import com.study.server.controllers.profile.ProfileRes;
import com.study.server.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileRes toProfileRes(User user);
}
