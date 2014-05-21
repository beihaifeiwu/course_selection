package com.course.selection.dao;

import java.util.List;

import com.course.selection.domain.ClassRoom;
import com.course.selection.domain.Course;
import com.course.selection.domain.CourseStateType;
import com.course.selection.domain.Student;
import com.course.selection.domain.Teacher;

/**
 * 对于课程的数据库访问接口
 * @author Administrator
 *
 */
public interface CourseDAO {

	/**
	 * 存储Course的实例到数据库
	 * @param course 待存储的Course实例
	 * @return 存储的Course实例的标识属性
	 */
	Integer save(Course course);
	/**
	 * 批量存储Course实例
	 * @param course
	 */
	void save(List<Course> course);
	
	/**
	 * 从数据库加载Course实例
	 * @param id 待加载的Course实例标识属性
	 * @return 加载完成的Course实例
	 */
	Course get(Integer id);
	
	/**
	 * 更新Course实例
	 * @param course
	 */
	void update(Course course);
	
	/**
	 * 删除Course实例
	 * @param course
	 */
	void delete(Course course);
	
	/**
	 * 通过实例标识属性删除Course实例
	 * @param id
	 */
	void delete(Integer id);
	/**
	 * 通过实例标识属性从数据库中移除课程
	 * @param id
	 */
	void removeFromDatabase(Integer id);
	/**
	 * 从数据库中移除course实例
	 * @param course
	 */
	void removeFromDatabase(Course course);
	
	/**
	 * 查询全部课程
	 */
	List<Course> findAll();
	
	/**
	 * 通过分页查询所有课程
	 * @param pg
	 * @return
	 */
	PageQuery<Course> scanCourseByPage(PageQuery<Course> pg);
	
	/**
	 * 查询所有课程状态为type的课程
	 * @param type 指定的课程状态
	 * @return 课程列表 
	 */
	List<Course> findByType(CourseStateType type);
	
	/**
	 * 分页查询所有课程状态为type的课程
	 * @param pg
	 * @param type
	 * @return
	 */
	PageQuery<Course> scanCourseByType(PageQuery<Course> pg,CourseStateType type);

	/**
	 * 分页查询所有课程状态不为type的课程
	 * @param pg
	 * @param type
	 * @return
	 */
	PageQuery<Course> scanCourseByNotThatType(PageQuery<Course> pg,CourseStateType type);	
	/**
	 * 查询所有由teacher讲授的课程
	 * @param teacher 指定的教师
	 * @return 课程列表
	 */
	List<Course> findByTeacher(Teacher teacher);
	
	/**
	 * 分页查询所有teacher开设的课程
	 * @param pg
	 * @param teacher
	 * @return
	 */
	PageQuery<Course> scanTeacherCourseByPage(PageQuery<Course> pg,Teacher teacher);
	/**
	 * 分页查询所有主讲教师为teacherName的课程
	 * @param pq
	 * @param teacherName
	 * @return
	 */
	PageQuery<Course> scanCourseByTeacherName(PageQuery<Course> pq,String teacherName);
	
	/**
	 * 查询所有上课地点在room的课程
	 * @param room
	 * @return
	 */
	List<Course> findByClassRoom(ClassRoom room);
	
	/**
	 * 分页查询所有上课地点在room的课程
	 * @param pg
	 * @param room
	 * @return
	 */
	PageQuery<Course> scanClassRoomCourseByPage(PageQuery<Course> pg,ClassRoom room);
	
	/**
	 * 查询所有课程号为courseNumber的课程
	 * @param coursenumber
	 * @return
	 */
	List<Course> findByCourseNumber(String coursenumber);
	/**
	 * 查询课程号为courseNumber，课序号为classNumber的课程
	 * @param courseNumber
	 * @param classNumber
	 * @return
	 */
	Course findByCourseNumberAndClassNumber(String courseNumber,String classNumber);
	
	/**
	 * 分页查询所有课程号为courseNumber的课程
	 * @param pg
	 * @param CourseNumber
	 * @return
	 */
	PageQuery<Course> scanCourseByCourseNum(PageQuery<Course> pg,String courseNumber);
	
	/**
	 * 查询所有课程名为courseName的课程
	 * @param coursename
	 * @return
	 */
	List<Course> findByCourseName(String coursename);
	

	/**
	 * 分页查询所有课程名为courseName的课程
	 * @param pg
	 * @param courseName
	 * @return
	 */
	PageQuery<Course> scanCourseByCourseName(PageQuery<Course> pg,String courseName);
	/**
	 * 分页查询学生student所选的课程
	 * @param pq
	 * @param student
	 * @return
	 */
	PageQuery<Course> scanCourseByStudent(PageQuery<Course> pq, Student student);
	
}
