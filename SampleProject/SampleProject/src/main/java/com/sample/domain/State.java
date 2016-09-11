package com.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class State {

	@Id
	@GeneratedValue
	private Long stateId;
	
	@Column
	private String name;
}
