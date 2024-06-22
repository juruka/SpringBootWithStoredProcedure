package com.lucca.esuninterview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lucca.esuninterview.model.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer>{
	@Procedure(procedureName = "get_user_by_id")
	public Users getById(@Param("userId") Integer id);
}
