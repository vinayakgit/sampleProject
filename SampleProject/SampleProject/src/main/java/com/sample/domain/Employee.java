package com.sample.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long empId;
	
	@Column
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contact_id")
	private EmpContact cont;
	
	@Column
	private String phone;

	@Override
	public String toString() {
		return String.format(
				"Employee [empId=%s, name=%s, address=%s, phone=%s]", empId,
				name, cont, phone);
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmpContact getCont() {
		return cont;
	}

	public void setCont(EmpContact cont) {
		this.cont = cont;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	
}
