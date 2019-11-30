import java.util.ArrayList;

public class Context {
	private AverageStrategy strategy;
	
	public Context(AverageStrategy strategy) {
		this.strategy = strategy;
	}
	
	public double executeStrategy(ArrayList<Double> assignments, ArrayList<Double> exams) {
		return strategy.avg(assignments, exams);
	}
}
