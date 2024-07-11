import java.util.ArrayList;

public class Student {
	private ArrayList <Course> primaryCourses = new ArrayList <Course> ();
	private ArrayList <Course> alternateCourses = new ArrayList <Course> ();
	private ArrayList <Course> timetable = new ArrayList <Course>();
	private boolean [] blockIsFilled = new boolean[9];
	private int id;
	
	
	public Student () {
	}
	
	public Student (int identifier) {
		this.id = identifier;
	}
	
	public ArrayList <Course> getPrimaryCourses() {
		return primaryCourses;
	}
	public void setPrimaryCourses(ArrayList <Course> primaryCourses) {
		this.primaryCourses = primaryCourses;
	}
	public void addPrimaryCourses(Course newCourse) {
		primaryCourses.add(newCourse);
	}
	public ArrayList <Course> getAlternateCourses() {
		return alternateCourses;
	}
	public void setAlternateCourses(ArrayList <Course> alternateCourses) {
		this.alternateCourses = alternateCourses;
	}
	public void removeAlternateCourse() {
		alternateCourses.remove(0);
	}
	public void addAlternateCourses(Course newCourse) {
		alternateCourses.add(newCourse);
	}
	public void addCourseToTimetable(Course newCourse) {
		timetable.add(newCourse);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void fillBlock(int index) {
		blockIsFilled[index] = true;
	}
	public boolean isFilled(int index) {
		return blockIsFilled[index];
	}
	public ArrayList<Course> getTimetable(){
		return timetable;
	}
	public void removeCourseFromTimeTable (String courseName) {
		for (int i = 0; i < this.timetable.size(); i++) {
			if (timetable.get(i).getName().equals(courseName)) {
				timetable.remove(i);
			}
		}
	}
	public boolean hasCourse (String courseName) {
		for (int i = 0; i < this.timetable.size(); i++) {
			if (timetable.get(i).getName().equals(courseName)) {
				return true;
			}
		}
		return false;
	}
	public void printTimetable() {
		System.out.println("---------- Student Number: " + this.id + "----------") ;
		for (int i = 0; i < timetable.size(); i++) {
//			int 
//			for (int j = i; j < timetable.size(); j++) {
//				
//			}
			System.out.println("Course " + (i+1) + ": " + timetable.get(i).getName() + " at block " + timetable.get(i).getBlock());
		}
		System.out.println("---------- End of Timetable ----------") ;
	}
}