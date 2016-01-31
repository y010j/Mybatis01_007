package com.yjj.mapper;


import java.util.List;

import com.yjj.domain.Student;

public interface StudentMapper {
	public Student getById(int id);
	public List<Student> getAll();
	public int add(Student student);
	public int delById(int id);
	public int update(Student student);

}
