import java.util.ArrayList;

public class AssignmentAvgA implements AverageStrategy {

	@Override
	public double avg(ArrayList<Double> assignments, ArrayList<Double> exams) {
		// TODO Auto-generated method stub
		double assignmentTotal = 0.0;
		double examTotal = 0.0;
		int i = 0;
		while(i < assignments.size()) {
			assignmentTotal += assignments.get(i);
			i++;
		}
		int j = 0;
		while(j < exams.size()) {
			examTotal += exams.get(j);
			j++;
		}
		return (((assignmentTotal/i)*0.40) + ((examTotal/j)*0.60));
	}

}
