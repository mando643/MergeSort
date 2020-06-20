import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentSortMain {

	public static void main(String[] args) 
	{
		List<Student> studentList = new ArrayList<Student>();
		
		// Read in file
		try {
			Scanner fileIn = new Scanner(new File("Students.txt"));
			String firstName;
			String lastName;
			String birthday;
			String major;
			double gpa;
			
			while(fileIn.hasNext()) {
				firstName = fileIn.next();
				lastName = fileIn.next();
				birthday = fileIn.next();
				major = fileIn.next();
				gpa = fileIn.nextDouble();
				
				studentList.add(new Student(firstName, lastName, birthday, major, gpa));
			}
			
			fileIn.close();
		
		} catch (Exception ex) {
			System.out.println("Error reading file");
			return;
		}
		
		Student[] students = new Student[studentList.size()];
		students = studentList.toArray(students);
		
		System.out.println("NOT SORTED");
		System.out.println("==========");
		printArray(students);
		sortArray(students);
		
		System.out.println();
		System.out.println();
		System.out.println("SORTED");
		System.out.println("======");
		printArray(students);
	}
	
	public static void printArray(Student [] students) {
		for (Student student : students) {
			System.out.println(student.getFullName() + ", " + student.getGpa());
		}
	}
	
	public static void sortArray(Student[] students) 
	{
		if (students.length <= 1)
		{
			return;
		}
		
		Student[] leftArray = new Student [(students.length + 1)/2];
		Student[] rightArray = new Student [students.length - leftArray.length];
		
		for (int i = 0; i < students.length; i++)
		{
			if (i < leftArray.length)
			{
				leftArray[i]= students[i];
			}
			else 
			{
				rightArray[i - leftArray.length] = students[i];
			}
		}
		
		sortArray(leftArray);
		sortArray(rightArray);
		
		int leftIndex = 0;
		int rightIndex = 0;
		
		for (int i = 0; i < students.length; i++)
		{
			if (rightIndex == rightArray.length)
			{
				students[i] = leftArray[leftIndex];
				leftIndex++;
			}
			else if (leftIndex == leftArray.length)
			{
				students[i] = rightArray[rightIndex];
				rightIndex++;
			}
			else if (leftArray[leftIndex].getGpa() > rightArray[rightIndex].getGpa())
			{
				students[i] = leftArray[leftIndex];
				leftIndex++;
			}
			else if (leftArray[leftIndex].getGpa() < rightArray[rightIndex].getGpa())
			{
				students[i] = rightArray[rightIndex];
				rightIndex++;
			}
			else 
			{
				return;
			}
		}
	}
}