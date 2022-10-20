package com.example.www.shopping.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.bind.Name;

@Entity
@Table(name = "member")
public class MemberBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberid;
	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;
	@Column(name = "tel")
	private String tel;
	@Column(name = "memmail")
	private String memmail;
	@Column(name = "birth")
	private String birth;

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMemmail() {
		return memmail;
	}

	public void setMemmail(String memmail) {
		this.memmail = memmail;
	}

	@Override
	public String toString() {
		return "MemberBean [memberid=" + memberid + ", name=" + name + ", password=" + password + ", tel=" + tel + "]";
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
