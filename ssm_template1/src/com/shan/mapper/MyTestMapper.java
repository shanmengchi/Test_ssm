package com.shan.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shan.pojo.Person;

@Repository
public interface MyTestMapper {

	int insert(@Param("p")Person person);

	Person selectById(String id);

}
