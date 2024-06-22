package com.lucca.esuninterview.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lucca.esuninterview.model.Products;

@Repository
public interface ProductsDao extends JpaRepository<Products, Integer> {

	@Procedure(procedureName = "get_products")
	public Products getProductsByNo(@Param("n_no") Integer no);

	@Procedure(procedureName = "add_new_product")
	public Integer addProduct(@Param("n_name") String productsName, @Param("n_price") BigDecimal price,
			@Param("n_fee_rate") BigDecimal feeRate);

	@Procedure(procedureName = "update_products")
	public void updateProduct(@Param("n_no") Integer no, @Param("n_name") String productsName,
			@Param("n_price") BigDecimal price, @Param("n_fee_rate") BigDecimal feeRate);

}
