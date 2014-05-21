package com.course.selection.service;

import java.util.List;

import com.course.selection.dao.PageQuery;
import com.course.selection.domain.ClassRoom;
import com.course.selection.domain.Course;
import com.course.selection.domain.Student;
import com.course.selection.domain.Teacher;
import com.course.selection.util.CourseTable;

public interface CourseService {
	
	/**
	 * 创建课程
	 * @param course
	 * @return
	 */
	Integer createCourse(Course course);
	/**
	 * 创建课程
	 * @param course
	 * @return
	 */
	void createCourse(List<Course> courses);
	/**
	 * 修改课程
	 * @param course
	 */
	void modifyCourse(Course course);

	/**
	 * 分页查询所有课程 第一页
	 * @return
	 */
	PageQuery<Course> scanCourse();

	/**
	 * 分页查询所有课程 其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> scanCourse(PageQuery<Course> pq);

	/**
	 * 按课程号分页查询所有课程 第一页
	 * @return
	 */
	PageQuery<Course> scanCourseByCourseNumber(String courseNumber);

	/**
	 * 按课程号分页查询所有课程 其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> scanCourseByCourseNumber(PageQuery<Course> pq,String courseNumber);

	/**
	 * 按课程名分页查询所有课程 第一页
	 * @return
	 */
	PageQuery<Course> scanCourseByCourseName(String courseName);

	/**
	 * 按主讲教师分页查询所有课程 其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> scanCourseByCourseName(PageQuery<Course> pq,String courseName);
	
	/**
	 * 按主讲教师分页查询所有课程 第一页
	 * @return
	 */
	PageQuery<Course> scanCourseByTeacher(Teacher teacher);

	/**
	 *  按主讲教师分页查询所有课程 其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> scanCourseByTeacher(PageQuery<Course> pq,Teacher teacher);
	
	/**
	 * 按主讲教师分页查询所有课程 第一页
	 * @return
	 */
	PageQuery<Course> scanCourseByTeacherName(String teacherName);

	/**
	 *  按主讲教师分页查询所有课程 其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> scanCourseByTeacherName(PageQuery<Course> pq,String teacherName);
	/**
	 * 按选课学生分页查询所有课程 第一页
	 * @return
	 */
	PageQuery<Course> scanCourseByStudent(Student student);

	/**
	 * 按选课学生分页查询所有课程 其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> scanCourseByStudent(PageQuery<Course> pq,Student student);
	/**
	 * 分页查询所有未删除的课程，第一页
	 * @return
	 */
	PageQuery<Course> scanNotDeletedCourse();
	
	/**
	 * 分页查询所有未删除的课程，其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> scanNotDeletedCourse(PageQuery<Course> pq);
	/**
	 * 分页查询所有已删除的课程，第一页
	 * @return
	 */
	PageQuery<Course> scanDeletedCourse();
	
	/**
	 * 分页查询所有已删除的课程，其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> scanDeletedCourse(PageQuery<Course> pq);

	/**
	 * 分页查询所有可选可课程，第一页
	 * @return
	 */
	PageQuery<Course> scanPickableCourse();

	/**
	 * 分页查询所有可选的课程，其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> scanPickableCourse(PageQuery<Course> pq);
	
	/**
	 * 分页查询所有已创建还未准备好的课程，第一页
	 * @return
	 */
	PageQuery<Course> scanUnReadyCourse();
	
	/**
	 * 分页查询所有已创建还未准备好的课程，其它页
	 * @param pq
	 * @return
	 */
	PageQuery<Course> scanUnReadyCourse(PageQuery<Course> pq);
	
	/**
	 * 生成教室的课表
	 * @param classRoom
	 * @return
	 */
	CourseTable generateCourseTableByClassRoom(ClassRoom classRoom);
	
	/**
	 * 生成学生的课表
	 * @param student
	 * @return
	 */
	CourseTable generateCourseTableByStudent(Student student);

	/**
	 * 生成教师课表
	 * @param teacher
	 * @return
	 */
	CourseTable generateCourseTableByTeacher(Teacher teacher);
	/**
	 * 删除课程，将课程状态标注为DELETED
	 */
	void deleteCourse(Integer id);
	void deleteCourse(List<Integer> list);
	/**
	 * 删除所有状态为DELETED的课程
	 */
	void removeAllDeletedCourse();
	
	/**
	 * 通过标识属性获得Course实例
	 */
	Course getCourseByID(Integer id);
	/**
	 * 判断课程是否存在
	 * @param courseNumber
	 * @param classNumber
	 * @return
	 */
	boolean isExist(String courseNumber,String classNumber);
	/**
	 * 开放选课
	 */
	void openSelectCourse();
	/**
	 * 结束选课
	 */
	void closeSelectCourse();
}
