package com.lucca.esuninterview.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lucca.esuninterview.model.LikeList;

@Repository
public interface LikeListDao extends JpaRepository<LikeList, Integer> {

	@Procedure(procedureName = "add_like_list")
	public void addLikeList(@Param("n_order_numbers") Integer orderNumber, @Param("n_account") String account,
			@Param("n_total_fee") BigDecimal totalFee, @Param("n_total_amount") BigDecimal totalAmount,
			@Param("n_product_no") Integer productsNo);

	@Procedure(procedureName = "update_like_list")
	public void updateLikeList(@Param("n_sn") Integer sn, @Param("n_order_numbers") Integer orderNumber, @Param("n_account") String account,
			@Param("n_total_fee") BigDecimal totalFee, @Param("n_total_amount") BigDecimal totalAmount,
			@Param("n_status") Integer status);

}
