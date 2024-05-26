
public class Student  implements Comparable<Student> {
     protected String firstName = "";
	 protected String lastName = "";
	 protected String subject = "";
	 
	 protected double finalExam = 0;
	 protected double average = 0;
	 protected String letterGrade = "";
	 private int [] gradesArray;
	
	
	public Student () {
		this.firstName = "";
		this.lastName = "";
		this.subject = "";
	}//Student
	
	public Student (String fn, String ln, String topic, int [] grades) {
		gradesArray = new int [grades.length];
		this.firstName = fn;
		this.lastName = ln.replace(",", "");
		this.subject = topic;
		for (int i = 0; i < grades.length; i++) {
			gradesArray[i] = grades[i];
		}
	}//Student
	
	
	public String getFirstName () {
		return this.firstName;
	}
	
	public String getLastName () {
		return this.lastName;
	}
	
	public String getSubject () {
		return this.subject;
	}
	
	public double  getFinalExamMark () {
		return this.finalExam;
	}
	
	public double getFinalAverage() {
		average = Math.round(average * 100.0) / 100.0;
		return this.average;
	}
	
	public String getLetterGrade() {
		return this.letterGrade;
	}
	
	// Method
    // Sorting in ascending order of name
    public int compareTo(Student a)    {
        if (lastName.compareToIgnoreCase(a.getLastName()) == 0 && firstName.compareToIgnoreCase(a.getFirstName()) == 0) {
        	return 0;
        }else if ((lastName.compareToIgnoreCase(a.getLastName()) > 0) || lastName.compareToIgnoreCase(a.getLastName()) == 0 && firstName.compareToIgnoreCase(a.getFirstName()) > 0) {
        	return 1;
        } else {
        	return -1;
        } //else
        
    }//compareTo

	
}//Student
