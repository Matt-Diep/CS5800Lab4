import java.util.Observable;
import java.util.ArrayList;

/**
 * Represents a student and their scores in a class.
 * Stores the name, assignment scores and exam scores.
 * @author Jill Seaman
 *https://userweb.cs.txstate.edu/~js236/cs3354/
 */
@SuppressWarnings("deprecation")
public class Student extends Observable{

    private String name;                    // Students full name
    private ArrayList<Double> assignments;  // scores for the assignments
    private ArrayList<Double> exams;        // scores for the exams\
    private boolean dropLowestScore;
    
	/**
	 * Constructs the student from their name
	 * @param name  full name of the student.
	 */
	public Student(String name) {
		this.name = name;
        assignments = new ArrayList<Double>();
        exams = new ArrayList<Double>();
        dropLowestScore = false;
	}

	/**
	 * @return the student's full name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds an assignment score to the collection of assignment scores for the student.
	 * @param as the assignment score to add
	 */
	public void addAssignmentScore (double as) {
		assignments.add(as);
		setChanged();
		notifyObservers();
	}
	/**
	 * Adds an exam score to the collection of exam scores for the student.
	 * @param es the exam score to add
	 */
	public void addExamScore (double es) {
		exams.add(es);
		setChanged();
		notifyObservers();
	}
	
	public double getAverage() {
		if(dropLowestScore) {
			Context context = new Context(new AssignmentAvgB());
			return context.executeStrategy(assignments, exams);
		}
		else {
			Context context = new Context(new AssignmentAvgA());
			return context.executeStrategy(assignments, exams);
		}
	}
	
	public void setDropLowestAssign(boolean drop) {
		dropLowestScore = drop;
	}


}
