
public class AvgIterator implements AvgDispenser {
	private Roster roster;
	private int currentPosition = 0;
	
	public AvgIterator(Roster roster){
		this.roster = roster;
	}
	
	@Override
	public double getNextAvg() {
		// TODO Auto-generated method stub
		double temp = roster.getStudents().get(currentPosition).getAverage();
		currentPosition++;
		return temp;
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return (currentPosition >= roster.getStudents().size());
	}

}
