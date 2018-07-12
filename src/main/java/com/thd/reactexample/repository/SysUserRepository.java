package com.thd.reactexample.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thd.reactexample.entity.SysUser;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser,String> {
	
	public List<SysUser> findByUserName(String name);
	
	public List<SysUser> findByUserNameLike(String name);
	
	@Query(value = "SELECT * FROM SYS_USER WHERE USER_NAME like ?1",
		   countQuery = "SELECT count(*) FROM SYS_USER WHERE USER_NAME like ?1",
		   nativeQuery = true)
	public Page<SysUser> pageByNameLike(String name, Pageable pageable);
}
