package com.lk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_president")
public class President {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer age;

	@OneToOne(mappedBy = "president")
	private College college;

	public President(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public President(Integer id, String name, Integer age, College college) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.college = college;
	}

	public President() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "President [id=" + id + ", name=" + name + ", age=" + age + ", college=" + college + "]";
	}

}
