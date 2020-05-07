package com.lk.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lk.entity.College;
import com.lk.entity.President;

public class OneToOneTest {
	private static EntityManagerFactory managerFactory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	// OneToOne 更
	@Test
	public void testUpdate() {
		College college = manager.find(College.class, 3);
		college.setCollegeName("万年师范");
	}

	// OneToOne 删
	@Test
	public void testDelete() {
		College college = manager.find(College.class, 2);
		manager.remove(college);
//		President president = manager.find(President.class,1);
//		manager.remove(president);
	}

	// OneToOne 查
	@Test
	public void testQuery() {
		College college = manager.find(College.class, 2);
		System.out.println(college);
		System.out.println(college.getPresident().toString());
	}

	// OneToOne 增
	@Test
	public void testAdd() {
		College college = new College();
		college.setCollegeName("南昌学院");

		President president = new President("张三222", 24);
		college.setPresident(president);
		president.setCollege(college);

		manager.persist(president);
		manager.persist(college);
	}

	// 建表语句
	@Test
	public void createTable() {

	}

	@Before
	public void createManager() {
		managerFactory = Persistence.createEntityManagerFactory("jpa");
		manager = managerFactory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
	}

	@After
	public void destroy() {
		transaction.commit();
		manager.close();
		managerFactory.close();
	}
}
