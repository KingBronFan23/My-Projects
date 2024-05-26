public class HistoryStudents extends Student {
	private double attendance = 0;
	private double project = 0;
	private double midterm = 0;
	
	public HistoryStudents (String fn, String ln, int [] grades) {
		this.firstName = fn;
		this.lastName = ln.replace(",", "");
		this.attendance = grades[1];
		this.project = grades[2];
		this.midterm = grades[3];
		this.finalExam = grades[4];
		this.subject = "History";
		
		this.average = (attendance/100) * 10 + (project/100) * 30 + (midterm/100) * 30 + (finalExam/100) * 30;

		
		if (this.average >= 90) {
			this.letterGrade = "A";
		} else if (this.average < 90 && this.average >=80) {
			this.letterGrade = "B";
		} else if (this.average <= 79 && this.average >= 70) {
			this.letterGrade = "C";
		} else if (this.average <= 69 && this.average >= 60) {
			this.letterGrade = "D";
		} else {
			this.letterGrade = "F";
		}//else
	
	
	
	
	}


}