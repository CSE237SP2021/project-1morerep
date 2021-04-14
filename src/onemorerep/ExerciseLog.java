package onemorerep;

import java.util.ArrayList;
import java.util.List;

public class ExerciseLog {
	private List<Exercises> exerciseList;
	
	public ExerciseLog() {
		this.exerciseList = new ArrayList<>();
	}
	
	public void addExercise(Exercises exercise) {
		exerciseList.add(exercise);
	}
	
	public int getNumberOfExercise() {
		return exerciseList.size();
	}
	
	public int getTotalCalories() {
		int totalCalories = 0;
		for(Exercises exercise : exerciseList) {
			totalCalories += Math.round(exercise.caloriesBurned());
		}
		return totalCalories;
	}
	
	public void displayExerciseLog() {
		System.out.println("There are " + getNumberOfExercise() + " kinds of exercises done today.");
		System.out.println("There are " + getTotalCalories() + " calories burned today.");
		for(int i = 0; i < exerciseList.size(); i++) {
			System.out.print((i+1) + ". ");
			exerciseList.get(i).displayExercise();
		}
	}
}
