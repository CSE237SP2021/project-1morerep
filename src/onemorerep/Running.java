package onemorerep;

public class Running implements Exercises {

	private String name;

	private double duration;
	
	public Running(String name, double duration) {
		this.name = name;
		this.duration = duration;
	}
	
	@Override
	public double caloriesBurned(User person) {
		return ((this.duration*9.8*3.5*person.getWeight())/200.0);
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
