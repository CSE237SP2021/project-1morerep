package onemorerep;

public class User {

	private String name;
	private int age;
	private int weight; // kg as unit
	private int height; // cm as unit
	private int sex; // 1 stands for male, 2 stands for female
	
	public User(String name, int age, int weight, int height, int sex) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.sex = sex;
	}
	
	/**
	 * Calculate BMR based on Mifflin-St Jeor Equation
	 * @return BMR value
	 */
	public int calculateBMR() {
		double bmr = 10 * weight + 6.25 * height - 5 * age;
		if (sex == 1) {
			bmr += 5;
		} else {
			bmr -= 161;
		}
		int result = (int) Math.round(bmr);
		return result;
	}
}
