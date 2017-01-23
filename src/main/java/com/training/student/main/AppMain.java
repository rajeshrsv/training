package com.training.student.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.student.domain.Address;
import com.training.student.domain.Student;
import com.training.student.util.HibernateUtil;

public class AppMain {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Address address1 = new Address("3/69", "east street, periyapatti", "namakkal", "TN", "INDIA", 637002);
			Address address2 = new Address("45C/9", "Ring Road", "Banglore", "KN", "INDIA", 560000);

			Student student1 = new Student("RAJESHKUMAR", "1225028", "SCIENCE", address1);
			Student student2 = new Student("SUBHASH", "1225024", "MATHS", address2);
			session.save(student1);
			session.save(student2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
