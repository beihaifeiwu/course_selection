/**
 * 
 */
package com.course.selection.service;

import java.util.List;

import com.course.selection.dao.PageQuery;
import com.course.selection.domain.Course;
import com.course.selection.domain.Student;

/**
 * 学生业务接口
 * @author JiHan
 *
 */
public interface StudentService {
	/**
	 * 修改学生实例信息
	 * @param student
	 */
	void modifyStudent(Student student);
	/**
	 * 批量删除学生实例
	 * @param list
	 */
	void deleteStudent(List<Integer> list);
	/**
	 * 创建一个学生实例
	 * @param student
	 * @return
	 */
	Integer createStudent(Student student);
	/**
	 * 批量创建学生实例
	 * @param student
	 */
	void createStudent(List<Student> students);
	/**
	 * 通过学号查找学生
	 * @param account
	 * @return
	 */
	Student getStudentByAccount(String account);
	/**
	 * 通过标识属性查找学生
	 * @param id
	 * @return
	 */
	Student getStudentByID(Integer id);
	/**
	 * 分页浏览学生，第一页
	 * @return
	 */
	PageQuery<Student> scanStudent();
	/**
	 * 分页浏览学生，其它页 
	 * @param pq
	 * @return
	 */
	PageQuery<Student> scanStudent(PageQuery<Student> pq);
	
	/**
	 * 分页浏览课程course的学生，第一页
	 * @return
	 */
	PageQuery<Student> scanStudentByCourse(Course course);
	/**
	 * 分页浏览课程course的学生，其它页 
	 * @param pq
	 * @return
	 */
	PageQuery<Student> scanStudentByCourse(PageQuery<Student> pq,Course course);
	
	/**
	 * 分页查看所有的课程,其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> lookCourseAll(PageQuery<Course> pq);
	/**
	 * 分页查看所有的课程,第一页
	 * @return
	 */
	PageQuery<Course> lookCourseAll();
	
	/**
	 * 通过课程名查找课程
	 * @param coursename
	 * @return
	 */
	List<Course> searchCourseByCourseName(String coursename);
	
	/**
	 * 通过课程号查询课程
	 * @param coursenumber
	 * @return
	 */
	List<Course> searchCourseByCourseNmber(String coursenumber);
	
	/**
	 * 通过教师姓名查询课程
	 * @param teachername
	 * @return
	 */
	List<Course> searchCourseByTeacherName(String teachername);
	
	/**
	 * 选择课程
	 * @param course
	 * @param student
	 * @return 选课成功返回true，选课失败返回false
	 */
	boolean addCourse(Course course,Student student);
	

	
	/**
	 * 删除已选课程
	 * @param course
	 */
	void rmCourse(Course course,Student student);
}
