package com.portal.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.portal.models.Device;


public class DeviceDAOImpl{

SessionFactory deviceSessionFactory;
	

public SessionFactory getDeviceSessionFactory() {
	return deviceSessionFactory;
}

public void setDeviceSessionFactory(SessionFactory deviceSessionFactory) {
	this.deviceSessionFactory = deviceSessionFactory;
}

@SuppressWarnings("unchecked")
public List<Device> getDevices(){
	List<Device> data=null;
	try{
	Session session = deviceSessionFactory.openSession();
    session.beginTransaction();
    @SuppressWarnings("deprecation")
	Criteria criteria = session.createCriteria(Device.class);
    data= (List<Device>)criteria.list();
    session.getTransaction().commit();
    session.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return data;
}

public Device getDeviceById(String id){
	Device client=null;
	try{
	Session session = deviceSessionFactory.openSession();
    session.beginTransaction();
    @SuppressWarnings("deprecation")
	Criteria criteria = session.createCriteria(Device.class).add(Restrictions.eq("id", id));
	client = (Device)criteria.uniqueResult();
    session.getTransaction().commit();
    session.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return client;
}


public boolean addDevice(Device u){
	boolean commit = false;
	try{
	Session session = deviceSessionFactory.openSession();
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


public boolean UpdateDevice(Device u){
	boolean commit = false;
	try{
	Session session = deviceSessionFactory.openSession();
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


public boolean RemoveDevice(Device u){
	boolean commit = false;
	try{
	Session session = deviceSessionFactory.openSession();
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
