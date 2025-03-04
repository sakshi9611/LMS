package com.lms.entities;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "members")
public class Members {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberId")
	private long memberId;
	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phoneNo")
	private long phoneNo;

	@Column(name = "address")
	private String address;

	@Column(name = "gender")
	private String gender;

	@Column(name = "membershipDate")
	private String membershipDate;

	@Column(name = "membershipType")
	private String membershipType;

	@Column(name = "isActive")
	private boolean isActive;

	@Column(name = "roleId")
	private long role_id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "roleId", insertable = false, updatable = false)
	private Role role;

	@CreationTimestamp
	@Column(name = "timeStamp")
	private Timestamp timeStamp;

	@UpdateTimestamp
	@Column(name = "updatedTime")
	private Timestamp updatedTime;

}
