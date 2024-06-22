package com.lucca.esuninterview.vo;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Data;

@Data
public class LikeListRequestVO {
	public LikeListRequestVO(Map<String, String> map) {
		this.setProductName(map.get("product_name"));
		this.setProductPrice(new BigDecimal(map.get("product_price")));
		this.setProductFeeRate(new BigDecimal(map.get("product_fee_rate")));
		this.setAccount(map.get("product_account"));
		this.setProductNumbers(new Integer(map.get("product_numbers")));
		if (map.containsKey("likelist_sn")) {
			this.setLikeListSN(new Integer(map.get("likelist_sn")));;
		}
		if (map.containsKey("product_no")) {
			this.setProductNO(new Integer(map.get("product_no")));;
		}
	}

	private String productName;
	private BigDecimal productPrice;
	private BigDecimal productFeeRate;
	private String account;
	private Integer productNumbers;
	private Integer likeListSN;
	private Integer productNO;
}
