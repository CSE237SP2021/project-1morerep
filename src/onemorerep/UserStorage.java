package onemorerep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class UserStorage {
	public static void writeUser(User user) {
		
		try {
			File file = new File("user.text");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			BufferedWriter bufferedWriter =  new BufferedWriter(new OutputStreamWriter(fileOutputStream));
			
			bufferedWriter.write(user.getName());
			bufferedWriter.newLine();
			bufferedWriter.write(user.getAge());
			bufferedWriter.newLine();
			bufferedWriter.write(String.valueOf(user.getWeight()));
			bufferedWriter.newLine();
			bufferedWriter.write(String.valueOf(user.getHeight()));
			bufferedWriter.newLine();
			bufferedWriter.write(user.getSex());
			bufferedWriter.newLine();
		} catch(IOException e) {
			e.printStackTrace(); 
		}
		
	}
	
	public static User readUser(){
		try {
			File file = new File("user.text");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			if(bufferedReader.readLine() == null) {
				return new User();
			} else {
				String name = bufferedReader.readLine();
				int age = Integer.parseInt(bufferedReader.readLine());
				double weight = Double.parseDouble(bufferedReader.readLine());
				double height = Double.parseDouble(bufferedReader.readLine());
				int sex = Integer.parseInt(bufferedReader.readLine());
				return new User(name, age, weight, height, sex);
			}
		} catch(IOException e) {
			e.printStackTrace(); 
		}
		return new User();
		
	}

}
