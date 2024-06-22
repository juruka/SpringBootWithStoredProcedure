package com.lucca.esuninterview.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.lucca.esuninterview.dao.LikeListDao;
import com.lucca.esuninterview.dao.LikeListRepository;
import com.lucca.esuninterview.dao.ProductsDao;
import com.lucca.esuninterview.dao.UsersDao;
import com.lucca.esuninterview.model.LikeList;
import com.lucca.esuninterview.model.Products;
import com.lucca.esuninterview.model.Users;
import com.lucca.esuninterview.vo.LikeListRequestVO;

@Service
public class LikeListService {
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private LikeListDao likeListDao;
	@Autowired
	private LikeListRepository likeListRepo;
	@Autowired
	private ProductsDao productsDao;

	@Transactional
	public void addNewLikeList(LikeListRequestVO likeListVO) {
		Integer productsNo = productsDao.addProduct(likeListVO.getProductName(), likeListVO.getProductPrice(),
				likeListVO.getProductFeeRate());
		Integer orderNumber = likeListVO.getProductNumbers();
		String account = likeListVO.getAccount();
		BigDecimal totalAmount = getTotalPrice(orderNumber, likeListVO.getProductPrice());
		BigDecimal totalFee = getTotalFee(orderNumber, likeListVO.getProductPrice(), likeListVO.getProductFeeRate());
		likeListDao.addLikeList(orderNumber, account, totalFee, totalAmount, productsNo);

	}

	public void disableLikeList(Integer likeSN) {
		LikeList model = likeListDao.getById(likeSN);
		likeListDao.updateLikeList(likeSN, model.getOrderNumbers(), model.getAccount(), model.getTotalFee(),
				model.getTotalAmount(), 0);
	}

	@Transactional
	public void updateLikeList(LikeListRequestVO likeListVO) {
		BigDecimal totalAmount = getTotalPrice(likeListVO.getProductNumbers(), likeListVO.getProductPrice());
		BigDecimal totalFee = getTotalFee(likeListVO.getProductNumbers(), likeListVO.getProductPrice(),
				likeListVO.getProductFeeRate());
		productsDao.updateProduct(likeListVO.getProductNO(), likeListVO.getProductName(), likeListVO.getProductPrice(),
				likeListVO.getProductFeeRate());
		likeListDao.updateLikeList(likeListVO.getLikeListSN(), likeListVO.getProductNO(), likeListVO.getAccount(),
				totalFee, totalAmount, 1);
	}

	public String showUsersLikeList(Integer userId) {
		Gson gson = new Gson();
		Map<String, String> jsonMap = new HashMap<String, String>();

		Users user = usersDao.getById(userId);
		String account = user.getAccount();
		List<LikeList> list = likeListRepo.getUserLikeList(account);

		for (LikeList likeList : list) {
			Map<String, String> tempMap = new HashMap<String, String>();
			Products product = productsDao.getById(likeList.getProductNo());
			tempMap.put("product_name", product.getProductName());
			tempMap.put("account", account);
			tempMap.put("total_amount", likeList.getTotalAmount().toString());
			tempMap.put("total_fee", likeList.getTotalFee().toString());
			tempMap.put("email", user.getEmail());
			tempMap.put("likelist_sn", likeList.getSn().toString());
			tempMap.put("product_no", product.getNo().toString());

			jsonMap.put(likeList.getSn().toString(), gson.toJson(tempMap));
		}
		return gson.toJson(jsonMap);
	}

	private BigDecimal getTotalFee(Integer number, BigDecimal price, BigDecimal feeRate) {
		BigDecimal totalPrice = getTotalPrice(number, price);
		return totalPrice.multiply(feeRate).divide(BigDecimal.valueOf(100));
	}

	private BigDecimal getTotalPrice(Integer number, BigDecimal price) {
		BigDecimal quantity = new BigDecimal(number);
		return price.multiply(quantity);
	}

}
