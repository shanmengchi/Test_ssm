package com.shan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shan.pojo.Person;
import com.shan.service.MyTestService;

@Controller
@RequestMapping(value="/test")
public class csGit2 {
	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	private MyTestService myTestServiceImpl=null;
	
	@ResponseBody
//	@RequestMapping(value="/ceshi",produces = {"text/plain;charset=utf-8","text/html;charset=utf-8"}) 防止 @ResponseBody乱码
	@RequestMapping(value="/ceshi")
	public Map<String ,Person> test1(){
		Person person=new Person("小明","60",'1');//{"id":"d275e64865e611ea933668f728ada465","name":"小明","grade":"60","sex":"1"}
		List<Person> list=new ArrayList<Person>();
		list.add(person);list.add(person);//[{"id":"2a3ae50665e711ea933668f728ada465","name":"小明","grade":"60","sex":"1"},{"id":"2a3ae50665e711ea933668f728ada465","name":"小明","grade":"60","sex":"1"}]
		String addPerson=null;
		Map<String ,Person> map=new HashMap<String,Person>();
		map.put("a", person);
		map.put("b", person);//{"a":{"id":"8a7f937e65e711ea933668f728ada465","name":"小明","grade":"60","sex":"1"},"b":{"id":"8a7f937e65e711ea933668f728ada465","name":"小明","grade":"60","sex":"1"}}
		try {
			addPerson = myTestServiceImpl.addPerson(person);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/redis",method=RequestMethod.GET)
	public Map<String ,Person> test_Redis(String id){
		Map<String ,Person> map=new HashMap<>();
		Person p=myTestServiceImpl.getPersonById(id);
		map.put(p.getId(), p);
		return map;
	}
	
}
