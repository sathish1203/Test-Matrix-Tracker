package com.portal.daos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.portal.models.Testcase;


public class TestcaseDAOImpl{

SessionFactory testcaseSessionFactory;

public SessionFactory getTestcaseSessionFactory() {
	return testcaseSessionFactory;
}

public void setTestcaseSessionFactory(SessionFactory testcaseSessionFactory) {
	this.testcaseSessionFactory = testcaseSessionFactory;
}

@SuppressWarnings("unchecked")
public List<Testcase> getTestcasesByDevice(String DeviceId){
	List<Testcase> data=null;
	try{
		Session session = testcaseSessionFactory.openSession();
	    session.beginTransaction();
	    @SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Testcase.class).add(Restrictions.eq("deviceid", DeviceId));
	    data= (List<Testcase>)criteria.list();
	    session.getTransaction().commit();
	    session.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return data;
}

@SuppressWarnings("unchecked")
public List<Testcase> getTestcases(){
	List<Testcase> data=null;
	try{
	Session session = testcaseSessionFactory.openSession();
    session.beginTransaction();
    @SuppressWarnings("deprecation")
	Criteria criteria = session.createCriteria(Testcase.class);
    data= (List<Testcase>)criteria.list();
    session.getTransaction().commit();
    session.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return data;
}

public Testcase getTestcaseById(String id){
	Testcase client=null;
	try{
	Session session = testcaseSessionFactory.openSession();
    session.beginTransaction();
    @SuppressWarnings("deprecation")
	Criteria criteria = session.createCriteria(Testcase.class).add(Restrictions.eq("id", id));
	client = (Testcase)criteria.uniqueResult();
    session.getTransaction().commit();
    session.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return client;
}


public boolean addTestcase(Testcase u){
	boolean commit = false;
	try{
	Session session = testcaseSessionFactory.openSession();
    session.beginTransaction();
    session.saveOrUpdate(u);
    session.getTransaction().commit();
    session.close();
    commit = true;
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return commit;
}


public boolean UpdateTestcase(Testcase u){
	boolean commit = false;
	try{
	Session session = testcaseSessionFactory.openSession();
    session.beginTransaction();
    session.update(u);
    session.getTransaction().commit();
    session.close();
    commit = true;
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return commit;
}

public boolean RemoveTestcase(Testcase u){
	boolean commit = false;
	try{
	Session session = testcaseSessionFactory.openSession();
    session.beginTransaction();
    session.remove(u);
    session.getTransaction().commit();
    session.close();
	commit = true;
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return commit;
}

}
