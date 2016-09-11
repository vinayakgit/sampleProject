package com.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp_contact")
public class EmpContact {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long contactId;
		
		@Column
		private String phone;
		
		
		@OneToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="state_id")
		private State state;

		public Long getContactId() {
			return contactId;
		}


		public void setContactId(Long contactId) {
			this.contactId = contactId;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		/*public State getState() {
			return state;
		}*/


		/*public void setState(State state) {
			this.state = state;
		}*/
		
		
}
