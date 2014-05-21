/**
 * 
 */
package com.course.selection.dao;

import java.util.List;

import com.course.selection.domain.Course;
import com.course.selection.domain.Student;

/**
 * 对Student的数据库访问层
 * @author JiHan
 *
 */
public interface StudentDAO {
	/**
	 * 根据标识属性加载Student实例
	 * @param id:需要加载的Student实例的标识属性值
	 * @return 指定标识属性对应的Student实例
	 */
	Student get(Integer id);
	
	/**
	 * 保存指定的Student实例
	 * @param 需要被保存的Student实例
	 * @return 被保存的Student实例的标识属性值
	 */
	Integer save(Student student);
	/**
	 * 批量保存Student实例到数据库
	 * @param students
	 */
	void save(List<Student> students);
	
	/**
	 * 修改指定的Student实例
	 * @param 需要被修改的Student实例
	 */
	void update(Student student);
	/**
	 * 删除指定的Student实例
	 * @param Student 需要被删除的Student实例
	 */
	void delete(Student student);
	/**
	 * 根据标识属性来删除Student实例
	 * @param id 需要被删除的Student实例的标识属性值
	 */
	void delete(Integer id);

	/**
	 * 根据课程来查找学生集合
	 * @param course 课程
	 * @return 选择指定课程的所有学生集合
	 */
	List<Student> findByCourse(Course course);
	/**
	 * 查询全部的Student实例
	 * @return 数据库中所有Student实例
	 */
	List<Student> findAll();
	/**
	 * 分页查询所有Student实例
	 * @param pq
	 * @return
	 */
	PageQuery<Student> scanStudentByPage(PageQuery<Student> pq);
	/**
	 * 分页查询所有选择Course的Student
	 * @param pq
	 * @return
	 */
	PageQuery<Student> scanCourseStudentByPage(PageQuery<Student> pq,Course course);
	
	/**
	 * 根据学号查找学生
	 * @param Account
	 * @return
	 */
	Student findStudentByAccount(String Account);
	/**
	 * 根据姓名分页查找
	 * @param pq
	 * @return
	 */
	PageQuery<Student> scanStudentByNameByPage(PageQuery<Student> pq,String name);
	/**
	 * 根据班级查找学生
	 * @param pq
	 * @return
	 */
	PageQuery<Student> scanStudentByClassByPage(PageQuery<Student> pq,String clazz);
	/**
	 * 根据院系查找学生
	 * @param pq
	 * @param department
	 * @return
	 */
	PageQuery<Student> scanStudentByDepartmentByPage(PageQuery<Student> pq,String department);
}
