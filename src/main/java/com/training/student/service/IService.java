package com.training.student.service;

import java.util.List;

import com.training.student.domain.Student;

public interface IService {

	boolean saveStudentInfo(Student student);

	List<Student> getAllStudentInfo();

	Student getStudentById(int studId);

	List<String> getStudentInfoByColumnName(String columnName);

}
