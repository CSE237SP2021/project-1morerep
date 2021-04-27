package onemorerep;

public class Pushups implements Exercises {
	
	private String name;

	private double duration, met, constant1, constant2;
	
	private User person;
	
	public Pushups(String name, double duration, User person) {
		this.name = name;
		this.duration = duration;
		this.person = person;
		this.met = 8.0;
		this.constant1=3.5;
		this.constant2=200.0;
	}

	@Override
	public double caloriesBurned() {
		// TODO Auto-generated method stub
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
