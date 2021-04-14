package onemorerep;

public class Situps implements Exercises {

	private String name;

	private double duration;
	
	public Situps(String name, double duration) {
		this.name = name;
		this.duration = duration;
	}
	
	@Override
	public double caloriesBurned(User person) {
		// TODO Auto-generated method stub
		return ((this.duration*8.0*3.5*person.getWeight())/200.0);
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
