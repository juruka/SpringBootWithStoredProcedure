package com.lucca.esuninterview.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.lucca.esuninterview.model.LikeList;

@Repository
public class LikeListRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<LikeList> getUserLikeList(String account) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("get_user_like_list", LikeList.class);
		query.registerStoredProcedureParameter("n_account", String.class, javax.persistence.ParameterMode.IN);
		query.setParameter("n_account", account);
		return query.getResultList();
	}
}
