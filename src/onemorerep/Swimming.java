package onemorerep;

public class Swimming implements Exercises {

	private String name;

	private double duration, met, constant1, constant2;
	
	private User person;
	
	public Swimming(String name, double duration, User person) {
		this.name = name;
		this.duration = duration;
		this.person = person;
		this.met = 5.8;
		this.constant1=3.5;
		this.constant2=200.0;
	}
	
	@Override
	public double caloriesBurned() {
		return ((this.duration*met*constant1*person.getWeight())/constant2);
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
		System.out.println(name + " " + duration + " minutes : " + caloriesBurned() + " calories");
	}

}
