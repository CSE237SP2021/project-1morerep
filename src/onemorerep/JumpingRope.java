package onemorerep;
public class JumpingRope implements Exercises {
	
	private String name;
	private int sets;
	private int reps;
	private double duration;
	
	public JumpingRope(String name, double duration) {
		this.name = name;
		this.duration = duration;
		this.sets = 0;
		this.reps = 0;
	}
	
	@Override
	public double caloriesBurned(User person) {
		return ((this.duration*11.8*3.5*person.getWeight())/200.0);
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSets() {
		return 0;
	}

	@Override
	public int getReps() {
		return 0;
	}

	@Override
	public double getDuration() {
		return duration;
	}

	@Override
	public void setName(String Title) {
		this.name = Title ;
	}

	@Override
	public void setSets(int numSets) {
		this.sets=0;
	}

	@Override
	public void setReps(int numReps) {
		this.reps=0;
	}

	@Override
	public void setDuration(double minutes) {
		this.duration = minutes;
	}

}
