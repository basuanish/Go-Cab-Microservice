/**
 * Repository interface to connection with database and data transfer
 */
package com.capgemini.GoCab.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.GoCab.entity.UserEntity;

/**

 *
 */
@Repository
public interface IUserDao extends JpaRepository<UserEntity, Integer> {
	
//	@Query("SELECT u FROM UserEntity u WHERE u.userEmailAddress=:username")
//	public UserEntity findUserByUserName(@Param("username")String username);
//	
//	@Query("SELECT u.userEmailAddress FROM UserEntity u WHERE u.userId=:userId")
//	public String findUserEmailByUserId(@Param("userId") int userId);
}
