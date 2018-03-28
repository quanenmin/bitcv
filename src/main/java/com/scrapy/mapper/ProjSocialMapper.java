package com.scrapy.mapper;

import com.scrapy.entity.ProjSocial;

public interface ProjSocialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjSocial record);

    int insertSelective(ProjSocial record);

    ProjSocial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjSocial record);

    int updateByPrimaryKeyWithBLOBs(ProjSocial record);

    int updateByPrimaryKey(ProjSocial record);
}