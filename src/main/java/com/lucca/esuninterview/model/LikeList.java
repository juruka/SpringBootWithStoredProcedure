package com.lucca.esuninterview.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "like_list")
public class LikeList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sn")
	private Integer sn;

	@Column(name = "order_numbers")
	private Integer orderNumbers;

	@Column(name = "account")
	private String account;

	@Column(name = "total_fee")
	private BigDecimal totalFee;

	@Column(name = "total_amount")
	private BigDecimal totalAmount;

	@Column(name = "status")
	private Integer status;

	@Column(name = "product_no")
	private Integer productNo;

}
