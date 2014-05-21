package com.course.selection.service;

import com.course.selection.dao.PageQuery;
import com.course.selection.domain.ClassRoom;
import com.course.selection.domain.Course;
import com.course.selection.domain.Role;
import com.course.selection.domain.Student;
import com.course.selection.domain.Teacher;
import com.course.selection.domain.User;
import com.course.selection.exception.RoleExistException;

/**
 * 管理员业务层接口
 * @author Administrator
 *
 */
public interface AdminService {
	/**
	 * 搜索全部教室，第一页
	 * @return
	 */
	PageQuery<ClassRoom> searchClassRoomByAll();
	
	/**
	 * 搜索全部教室，其它页
	 * @param pq
	 * @return
	 */
	PageQuery<ClassRoom> searchClassRoomByAll(PageQuery<ClassRoom> pq);	
	
	/**
	 * 搜索全部教师，第一页
	 * @return
	 */
	PageQuery<Teacher> searchTeacherByAll();
	
	/**
	 * 搜索全部教师，其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Teacher> searchTeacherByAll(PageQuery<Teacher> pq);	
	/**
	 * 根据名字搜索教师,第一页
	 * @param name
	 * @return
	 */
	PageQuery<Teacher> searchTeacherByName(String name);
	/**
	 * 根据名字搜索教师，其它页
	 * @param pq
	 * @param name
	 * @return
	 */
	PageQuery<Teacher> searchTeacherByName(PageQuery<Teacher> pq,String name);
	/**
	 * 搜索全部学生，第一页
	 * @return
	 */
	PageQuery<Student> searchStudentByAll();
	
	/**
	 * 搜索全部学生，其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Student> searchStudentByAll(PageQuery<Student> pq);	
	/**
	 * 根据名字搜索学生,第一页
	 * @param name
	 * @return
	 */
	PageQuery<Student> searchStudentByName(String name);
	/**
	 * 根据名字搜索学生，其它页
	 * @param pq
	 * @param name
	 * @return
	 */
	PageQuery<Student> searchStudentByName(PageQuery<Student> pq,String name);

	/**
	 * 根据班级搜索学生,第一页
	 * @param name
	 * @return
	 */
	PageQuery<Student> searchStudentByClass(String clazz);
	/**
	 * 根据班级搜索学生，其它页
	 * @param pq
	 * @param name
	 * @return
	 */
	PageQuery<Student> searchStudentByClass(PageQuery<Student> pq,String clazz);
	/**
	 * 根据院系搜索学生,第一页
	 * @param name
	 * @return
	 */
	PageQuery<Student> searchStudentByDepartment(String department);
	/**
	 * 根据院系搜索学生，其它页
	 * @param pq
	 * @param name
	 * @return
	 */
	PageQuery<Student> searchStudentByDepartment(PageQuery<Student> pq,String department);
	/**
	 * 删除课程
	 * @param course
	 */
	void deleteCourse(Course course);
	
	/**
	 * 新增一门课程
	 * @param course
	 * @return
	 */
	void addCourse(Course course);
	
	/**
	 * 把课程添加到教室
	 * @param course
	 * @param classroom
	 * @return
	 */
	boolean addCourseToClassRoom(Course course,ClassRoom classroom);
	
	/**
	 * 修改课程信息
	 * @param course
	 * @return
	 */
	void alterCourse(Course course);
	
	/**
	 * 创造一种角色
	 * @param role
	 * @return
	 * @throws RoleExistException 
	 */
	Integer createRole(Role role) throws RoleExistException;
	/**
	 * 修改管理员实例
	 * @param user
	 */
	void modifyAdmin(User user);
	/**
	 * 通过标识属性获得实例
	 * @param id
	 * @return
	 */
	User getAdminByID(Integer id);
	
}
