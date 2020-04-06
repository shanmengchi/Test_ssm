package com.shan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shan.mapper.MyTestMapper;
import com.shan.pojo.Person;
import com.shan.service.MyTestService;

@Service
public class MyTestServiceImpl implements MyTestService{
	@Autowired
	private MyTestMapper myTestMapper;
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@CachePut(value="redisCacheManager",key="'redis_role_'+#person.id")
	public String addPerson(Person person) throws RuntimeException{
		System.out.println("呵呵");
		int insert = myTestMapper.insert(person);
		if(insert<1){
			throw new RuntimeException("用户数据插入失败！");
		}
		return "插入成功";
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Cacheable(value="redisCacheManager",key="'redis_role_'+#id")
	public Person getPersonById(String id) throws RuntimeException {
		Person p=myTestMapper.selectById(id);
		return p;
	}

}
