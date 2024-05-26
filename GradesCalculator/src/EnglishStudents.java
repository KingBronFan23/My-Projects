public class EnglishStudents extends Student {
	private double termPaperMark = 0;
	private double midterm = 0;
	
	public EnglishStudents (String fn, String ln, int [] grades) {
		this.firstName = fn;
		this.lastName = ln.replace(",", "");
		this.termPaperMark = grades[1];
		this.midterm = grades[2];
		this.finalExam = grades[3];
		this.subject = "English";
		
		this.average = (termPaperMark/100) * 25 + (midterm/100) * 35 + (finalExam/100)*40;

		
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
		}
	}

}