package onemorerep;

public class Walking implements Exercises {

	private String name;

	private double duration;
	
	public Walking(String name, double duration) {
		this.name = name;
		this.duration = duration;
	}
	
	@Override
	public double caloriesBurned(User person) {
		return ((this.duration*4.3*3.5*person.getWeight())/200.0);
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
}
