package com.thd.reactexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thd.reactexample.entity.SysUser;
import com.thd.reactexample.repository.SysUserRepository;

@RestController
@RequestMapping(value="/sysUser")
public class SysUserController {
	@Autowired
	private SysUserRepository sysUserRepository;
	
	
	
	/**
	 * 根据ID查询 SysUser
	 * url : http://127.0.0.1:8899/react/sysUser/queryById/1
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/queryById/{id}")
	public SysUser queryById(@PathVariable String id){
		return sysUserRepository.getOne(id);
	}
	
	/**
	 * 查询所有 SysUser
	 * url : http://127.0.0.1:8899/react/sysUser/queryAll
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/queryAll")
	public List<SysUser> queryAll(){
		return sysUserRepository.findAll();
	}
	
	/**
	 * 根据姓名模糊匹配查询SysUser - 带有分页信息
	 * url : http://127.0.0.1:8899/react/sysUser/pageByNameLike/devil13th/1/2
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/pageByNameLike/{name}/{page}/{size}",method=RequestMethod.GET)
	public Page<SysUser> pageByNameLike(@PathVariable String name,@PathVariable Integer page,@PathVariable Integer size){
		return sysUserRepository.pageByNameLike("%" + name + "%", PageRequest.of(page, size));
	}
	
	/**
	 * 根据姓名精确SysUser
	 * url : http://127.0.0.1:8899/react/sysUser/queryByName/devil13th_23
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/queryByName/{name}")
	public List<SysUser> queryByName(@PathVariable String name){
		return sysUserRepository.findByUserName(name);
	}
	
	/**
	 * 根据姓名模糊匹配查询SysUser
	 * url : http://127.0.0.1:8899/react/sysUser/queryByNameLike/devil13th_2
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/queryByNameLike/{name}")
	public List<SysUser> queryByNameLike(@PathVariable String name){
		return sysUserRepository.findByUserNameLike("%" + name + "%");
	}
	
	
}
