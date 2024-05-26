public class MathStudents extends Student {
	private double quizAverage = 0;
	private double test1 = 0;
	private double test2 = 0;
	
	public MathStudents (String fn, String ln, int [] grades) {
		this.firstName = fn;
		this.lastName = ln.replace(",", "");
		this.quizAverage = (grades[1] + grades[2] + grades[3] + grades[4] + grades[5])/5.0;
		this.test1 = grades[6];
		this.test2 = grades[7];
		this.finalExam = grades[8];
		this.subject = "Math";
		
		this.average = (quizAverage/100.0) * 15 + (test1/100.0) * 25 + (test2/100.0) * 25 + (finalExam/100.0)*35;

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
	}//MathStudents

}//MathStudents
