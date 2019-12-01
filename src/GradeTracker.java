import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class GradeTracker implements Observer {
	private double avg;
	
	public GradeTracker(Student s) {
		s.addObserver(this);
		avg = s.getAverage();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Student s = (Student)o;
		
		if(avg != s.getAverage()) {
			avg = s.getAverage();
		}
	}
	
	public String getLetterGrade() {
		if(avg >= 90) {
			return "A";
		}
		else if(avg >= 80) {
			return "B";
		}
		else if(avg >= 70) {
			return "C";
		}
		else if(avg >= 60) {
			return "D";
		}
		else {
			return "F";
		}
	}

}
