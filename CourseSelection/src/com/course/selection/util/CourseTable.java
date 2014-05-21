/**
 * 
 */
package com.course.selection.util;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.course.selection.domain.Course;

/**
 * @author JiHan
 *
 */
public class CourseTable extends AbstractMap<String, String> implements Serializable {
	private static final long serialVersionUID = 1321131764593931419L;
	/**
	 * 存储课程的二维数组列表，Table[周次][节次]
	 */
	private CourseGroup table[][]= new CourseGroup[7][11];
	/**
	 * 存储冲突课程及其位置
	 */
	private Map<String,CourseGroup> conflictMap = new HashMap<>();
	/**
	 * @return table
	 */
	public CourseGroup[][] getTable() {
		return table;
	}
	/**
	 * @param table 要设置的 table
	 */
	public void setTable(CourseGroup table[][]) {
		this.table = table;
	}

	/**
	 * 判断连个课程在周次上是否冲突
	 * @param c1
	 * @param c2
	 * @return有冲突返回false,无冲突返回true
	 */
	public static boolean isWeeksConflict(Course c1,Course c2){
		if((c1.getTimepoint().getWeeks()!=0)&&(c2.getTimepoint().getWeeks()!=0)){
			for(int i=0;i<20;i++){
				int temp1 = (c1.getTimepoint().getWeeks()&(int)Math.pow(2, i));
				int temp2 = (c2.getTimepoint().getWeeks()&(int)Math.pow(2, i));
				if(temp1==temp2&&temp1*temp2!=0){
					return false;
				}	
			}
		}
		return true;	
	}
	/**
	 * 判断两个课程在一周内的节次上是否冲突
	 * @param c1
	 * @param c2
	 * @return有冲突返回false,无冲突返回true
	 */
	public static boolean isPeriodConflict(Course c1,Course c2){
		for(int i=0;i<7;i++){
			if((c1.getTimepoint().getPeriod()[i]!=0&&c1.getTimepoint().getPeriod()[i]!=0))
				for(int j=0;j<11;j++){
					int temp1=c1.getTimepoint().getPeriod()[i]&(int)Math.pow(2, j);
					int temp2 = c2.getTimepoint().getPeriod()[i]&(int)Math.pow(2, j);
					if(temp1==temp2&&temp1*temp2!=0)
						return false;
				}
		}
		return true;
	}
	/**
	 * 检测两个课程在时间上是否冲突
	 * @param c1
	 * @param c2
	 * @return两个课程冲突返回false，不冲突返回true
	 */
	public static boolean isConflict(Course c1,Course c2){
		if(isWeeksConflict(c1, c2))
			return true;
		else{
			if(isPeriodConflict(c1, c2))
				return true;
		}	
		return false;
	}
	/**
	 * 往课表里添加指定课程
	 * @param course 需要被添加的指定课程
	 * @return 添加课程的结果，添加成功为true，添加失败为false
	 */
	public boolean addCourse(Course course){
		for(int i=0;i<7;i++){
			for(int j=0;j<11;j++){
				if(this.table[i][j]!=null){
					for(Course c : this.table[i][j]){
						if(!isConflict(course, c)){
							//System.out.println("添加失败");
							String key = (i+1) + "," + (j+1);
							CourseGroup cg = this.getConflictMap().get(key);
							if(cg == null){
								cg = new CourseGroup();
							}
							cg.add(course);
							//System.out.println(course);
							this.getConflictMap().put(key, cg);
							return false;
						}
					}
				}
			}
		}
		for(int i=0;i<7;i++){
			if(course.getTimepoint().getPeriod()[i]!=0){
				for(int j=0;j<11;j++){
					if(((course.getTimepoint().getPeriod()[i])&(int)Math.pow(2, j))==(int)Math.pow(2, j)){

						if(table[i][j] == null){
							this.table[i][j] = new CourseGroup();
						}
						this.table[i][j].add(course);
						//System.out.println("添加成功");
					}
				}
			}
		}
		return true;
	}
	/**
	 * 从课表中删除课程
	 * @param course
	 */
	public void rmCourse(Course course){
		for(int i=0;i<7;i++){
			for(int j=0;j<11;j++){
				if(table[i][j]!=null){
					int count =0;
					for(Course c : this.table[i][j]){
						if(c==course){
							this.table[i][j].remove(count);
							count--;
						}	
						count++;
					}
				}
			}
		}
	}
	@Override
	public Set<java.util.Map.Entry<String, String>> entrySet() {
		Set<java.util.Map.Entry<String, String>> set = new HashSet<>();
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 11; j++){
				if(table[i][j] != null){
					set.add(new CourseTableEntry(i, j));
				}
			}
		}
		return set;
	}
	
	@Override
	public boolean isEmpty() {
		boolean empty = true;
		
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 11; j++){
				if(table[i][j] != null) empty = false;
			}
		}
		
		return empty;
	}
	@Override
	public boolean containsKey(Object key) {
		
		boolean res = false;
		
		String str = (String) key;
		
		String[] array = str.split(",");
		
		if(array.length == 2){
			
			int i = Integer.parseInt(array[0]) - 1;
			
			int j = Integer.parseInt(array[1]) - 1;
			
			if(i >= 0 && i <= 6 && j >= 0 && j <= 11){
				res = true;
			}
			
		}
		
		return res;
	}
	@Override
	public String get(Object key) {

		String res = null;
		
		String str = (String) key;
		
		String[] array = str.split(",");
		
		if(array.length == 2){
			
			int i = Integer.parseInt(array[0]) - 1;
			
			int j = Integer.parseInt(array[1]) - 1;
			
			if(i >= 0 && i <= 6 && j >= 0 && j <= 11){
				
				CourseGroup cg = table[i][j];

				if(cg != null) res = cg.getDescription();
			}
			
		}
		
		return res;
	}

	public Map<String,CourseGroup> getConflictMap() {
		return conflictMap;
	}
	public void setConflictMap(Map<String,CourseGroup> conflictMap) {
		this.conflictMap = conflictMap;
	}

	public class CourseTableEntry implements java.util.Map.Entry<String, String>{

		private int i;
		
		private int j;
		
		@Override
		public String getKey() {
			return (i+1) + "," + (j+1);
		}

		@Override
		public String getValue() {
			return table[i][j].getDescription();
		}

		@Override
		public String setValue(String value) {
			return null;
		}

		public CourseTableEntry(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
}
