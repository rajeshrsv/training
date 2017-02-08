package com.training.student.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.training.student.domain.Student;
import com.training.student.util.HibernateUtil;
import com.training.student.util.LoggerUtil;

public class Service implements IService {

	Logger log = LoggerUtil.getInstance(Service.class);

	public boolean saveStudentInfo(Student student) {

		boolean status = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			System.out.println("Data strored successfully");

			log.debug("Data strored successfully");
			status = true;

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return status;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudentInfo() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.createCriteria(Student.class).list();

	}

	public Student getStudentById(int studId) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria crit = session.createCriteria(Student.class).add(Restrictions.eq("studId", studId));

		if (null == crit.list() || crit.list().isEmpty()) {
			return null;
		} else {
			return (Student) crit.list().get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> getStudentInfoByColumnName(String columnName) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria crit = session.createCriteria(Student.class);

		ProjectionList p1 = Projections.projectionList();
		p1.add(Projections.property(columnName));

		crit.setProjection(p1);

		return crit.list();
	}

}
