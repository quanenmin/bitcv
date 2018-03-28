package com.scrapy.mapper;

import com.scrapy.entity.Social;

public interface SocialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Social record);

    int insertSelective(Social record);

    Social selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Social record);

    int updateByPrimaryKey(Social record);
}