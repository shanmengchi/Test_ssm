package com.shan.service;

import com.shan.pojo.Person;

public interface MyTestService {

	public String addPerson(Person person) throws RuntimeException;

	public Person getPersonById(String id) throws RuntimeException;

}
