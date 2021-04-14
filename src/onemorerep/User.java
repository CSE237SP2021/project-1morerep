package onemorerep;

public class User {

	private String name;
	private int age;
	private double weight; // kg as unit
	private double height; // cm as unit
	private int sex; // 1 stands for male, 2 stands for female
	
	public User() {
		this.name = "";
		this.age = 0;
		this.weight = 0;
		this.height = 0;
		this.sex = 0;
		
	}
	public User(String name, int age, double weight, double height, int sex) {
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
	
	
	/*
	 * Getters and Setters
	 */
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public int getSex() {
		return this.sex;
	}
	
	public void setSex(int sex) {
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", weight=" + weight + ", height=" + height + ", sex=" + sex
				+ "]";
	}
	
}
