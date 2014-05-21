/**
 * 
 */
package com.course.selection.dao;

import java.util.List;

import com.course.selection.domain.Teacher;

/**
 * 对Teacher的数据库访问层
 * @author JiHan
 *
 */
public interface TeacherDAO {
	/**
	 * 根据标识属性加载Teacher实例
	 * @param id:需要加载的Teacher实例的标识属性值
	 * @return 指定标识属性对应的Teacher实例
	 */
	Teacher get(Integer id);
	
	/**
	 * 保存指定的Teacher实例
	 * @param 需要被保存的Teacher实例
	 * @return 被保存的Teacher实例的标识属性值
	 */
	Integer save(Teacher teacher);
	/**
	 * 批量保存Teacher实例到数据库
	 * @param teachers
	 */
	void save(List<Teacher> teachers);
	
	/**
	 * 修改指定的Teacher实例
	 * @param 需要被修改的Teacher实例
	 */
	void updata(Teacher teacher);
	/**
	 * 删除指定的Teacher实例
	 * @param teacher 需要被删除的Teacher实例
	 */
	void delete(Teacher teacher);
	/**
	 * 根据标识属性来删除Teacher实例
	 * @param id 需要被删除的Teacher实例的标识属性值
	 */
	void delete(Integer id);
	/**
	 * 查询全部的Teacher实例
	 * @return 数据库中所有Teacher实例
	 */
	List<Teacher> findAll();
	/**
	 * 分页查询全部的Teacher实例
	 * @param pq
	 * @return
	 */
	PageQuery<Teacher> scanTeacherByPage(PageQuery<Teacher> pq);
	/**
	 * 根据教师编号查找教师
	 * @param account
	 * @return
	 */
	Teacher findTeacherByAccount(String account);
	
	/**
	 * 通过姓名查找教师
	 * @param name 指定的姓名
	 * @return
	 */
	List<Teacher> findAllTeacherByName(String name);
	/**
	 * 根据教师姓名分页查找教师
	 * @param pq
	 * @return
	 */
	PageQuery<Teacher> scanTeacherByNameByPage(PageQuery<Teacher> pq ,String name);
	/**
	 * 根据院系分页查找教师
	 * @param pq
	 * @return
	 */
	PageQuery<Teacher> scanTeacherByDepartmentPage(PageQuery<Teacher> pq,String department);
}
