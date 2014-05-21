/**
 * 
 */
package com.course.selection.service;

import java.util.List;

import com.course.selection.dao.PageQuery;
import com.course.selection.domain.Course;
import com.course.selection.domain.Student;
import com.course.selection.domain.Teacher;

/**
 * 教师业务接口
 * @author JiHan
 *
 */
public interface TeacherService {

	/**
	 * 存储新的teacher实例
	 * @param teacher
	 * @return
	 */
	Integer addTeacher(Teacher teacher);
	/**
	 * 根据标识属性删除教师实例
	 * @param ids
	 */
	void deleteTeachers(List<Integer> ids);
	
	/**
	 * 教师查看自己所教的课程
	 * @return 课程列表
	 */
	List<Course> TeaCourses(Teacher teacher);
	
	/**
	 * 教师查看所有上指定课程的学生
	 * @param course 指定的课程
	 * @return 学生列表
	 */
	List<Student> CouStudents(Course course);
	/**
	 * 分页查看选指定课程的学生， 第一页
	 * @param course 指定课程
	 * @return 学生列表
	 */
	PageQuery<Student> lookStudentsByCourse(Course course);
	/**
	 * 分页查看选指定课程的学生，其它页
	 * @param course 指定课程
	 * @return 学生列表
	 */
	PageQuery<Student> lookStudentsByCourse(PageQuery<Student> pq,Course course);
	/**
	 * 分页查看所有教师，第一页
	 * @param pq
	 * @return
	 */
	PageQuery<Teacher> scanTeacherByPage();
	
	/**
	 * 分页查看所有教师，其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Teacher> scanTeacherByPage(PageQuery<Teacher> pq);
	/**
	 * 创建教师记录
	 * @param teacher
	 * @return
	 */
	Integer createTeacher(Teacher teacher);
	/**
	 * 批量创建教师记录
	 * @param teacher
	 * @return
	 */
	void createTeachers(List<Teacher> teachers);
	/**
	 * 根据教职工号查找教师
	 * @param account
	 * @return
	 */
	Teacher getTeacherByAccount(String account);
	/**
	 * 通过标识属性查找教师
	 * @param id
	 * @return
	 */
	Teacher getTeacherByID(Integer id);
	/**
	 * 修改教师实例
	 * @param teacher
	 */
	void modifyTeacher(Teacher teacher);
}
