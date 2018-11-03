package com.scs.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String username;           //用户名
	private String password;           //密码
	private Integer sex;               //性别
	private Date birth;                //出生日期
	private String addr;               //住址
	private String tel;                //联系电话
	private Timestamp inTime;          //入职时间
	private Double basicSalary;        //底薪
	private Integer isDelete;          //是否删除
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Timestamp getInTime() {
		return inTime;
	}
	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}
	public Double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public Integer isDelete() {
		return isDelete;
	}
	public void setDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	
	
	
	public User() {
		super();
	}
	
	
	
	public User(String username, String password, Integer sex, Date birth, String addr, String tel, Timestamp inTime,
			Double basicSalary, Integer isDelete) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birth = birth;
		this.addr = addr;
		this.tel = tel;
		this.inTime = inTime;
		this.basicSalary = basicSalary;
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", birth="
				+ birth + ", addr=" + addr + ", tel=" + tel + ", inTime=" + inTime + ", basicSalary=" + basicSalary
				+ ", isDelete=" + isDelete + "]";
	}
	
	
	

}
