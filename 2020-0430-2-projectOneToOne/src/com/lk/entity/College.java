package com.lk.entity;
//hello world aaa
//dddd
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * 院长和学院的映射关系，
 * 一个学院有一个院长，
 * 一个院长只管理一个学院，结合课上的方法，完成相关操作。
 */

//这是一个学生
@Entity
@Table(name = "JPA_college4")
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "college_name")
	private String collegeName;
	
	@OneToOne
	@JoinColumn(name = "president_id",unique = true)
	private President president;
	

	public College(Integer id, String collegeName) {
		super();
		this.id = id;
		this.collegeName = collegeName;
	}

	public College() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName ;
	}

	public President getPresident() {
		return president;
	}

	public void setPresident(President president) {
		this.president = president;
	}

}
