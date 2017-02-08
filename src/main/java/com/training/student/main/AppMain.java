package com.training.student.main;

import com.training.student.service.IService;
import com.training.student.service.Service;

public class AppMain {

	public static void main(String[] args) {

		IService service = new Service();

		/*Address address1 = new Address("3/69", "east street, periyapatti", "namakkal", "TN", "INDIA", 637002);
		Student student = new Student("RAJESHKUMAR", "1225028", "SCIENCE", address1);
		service.saveStudentInfo(student);*/
		
		System.out.println("--------- STUDENT LIST----------\n");
		service.getAllStudentInfo().forEach(System.out::println);
		
		System.out.println("--------- SELECT BY COLUMN----------\n");
		service.getStudentInfoByColumnName("name").forEach(System.out::println);
		
		System.out.println(service.getStudentById(2).toString());
		
	}

}
