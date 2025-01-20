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
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stockId")
	private long stockId;

	@Column(name = "isbn")
	private long ISBN;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "isbn", insertable = false, updatable = false)
	private Books books;

	@Column(name = "originalQuantity")
	private int originalQuantity;

	@Column(name = "currentQuantity")
	private int currentQuantity;

	@CreationTimestamp
	@Column(name = "timeStamp")
	private Timestamp timeStamp;

	@UpdateTimestamp
	@Column(name = "updatedTime")
	private Timestamp updatedTime;

}
