package com.course.selection.dao;

import java.util.List;

import com.course.selection.domain.User;

/**
 * 对于User的数据库访问层
 * @author Administrator
 *
 */
public interface UserDAO {

	/**
	 * 根据标识属性加载User实例
	 * @param id 需要加载的User实例的标识属性值
	 * @return 指定标识属性对应的User实例
	 */
	User get(Integer id);
	
	/**
	 * 持久化指定的User实例
	 * @param user 需要被持久化的User实例
	 * @return User实例被持久化后的标识属性值
	 */
	Integer save(User user);
	
	/**
	 * 修改指定的User实例
	 * @param user 需要被修改的User实例
	 */
	void update(User user);
	
	/**
	 * 删除指定的User实例
	 * @param user 需要被删除的User实例
	 */
	void delete(User user);
	
	/**
	 * 通过实例标识属性id删除User实例
	 * @param id
	 */
	void delete(Integer id);
	/**
	 * 根据用户名和密码加载User列表
	 * @param name 用户名
	 * @param passwd 密码
	 * @return 符合条件的User列表
	 */
	List<User> findByNameAndPasswd(String name,String passwd);
	
	/**
	 * 查找所有用户
	 * @return
	 */
	List<User> findAllUser();
	/**
	 * 查看所有用户，通过分页的方式
	 * @param pq
	 * @return
	 */
	PageQuery<User> scanUserByPage(PageQuery<User> pq);
}
