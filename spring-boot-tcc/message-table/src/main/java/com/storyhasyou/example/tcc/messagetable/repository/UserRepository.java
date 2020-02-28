package com.storyhasyou.example.tcc.messagetable.repository;

import com.storyhasyou.example.tcc.messagetable.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fangxi
 * @date 2020/2/28
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}
