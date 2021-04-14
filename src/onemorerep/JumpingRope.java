 package onemorerep;
public class JumpingRope implements Exercises {
	
	private String name;

	private double duration;
	
	private User person;
	
	public JumpingRope(String name, double duration, User person) {
		this.name = name;
		this.duration = duration;
		this.person = person;
	}
	
	@Override
	public double caloriesBurned() {
		return ((this.duration*11.8*3.5*person.getWeight())/200.0);
	}
	@Override
	public String getName() {
		return name;
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
	public void setDuration(double minutes) {
		this.duration = minutes;
	}
	
	@Override
	public void displayExercise() {
		System.out.println(name + " " + duration + " minutes : " + caloriesBurned());
	}

}
