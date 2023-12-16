package StudentDatabase;

import java.util.Scanner;

public class Student
{
	int rollno;
	String sname;
	Scanner sc = new Scanner(System.in);
	Student()
	{
		System.out.print("Enter the Rollno: ");
		rollno = sc.nextInt();
		System.out.print("Enter the Name: ");
		sname = sc.next();
	}
}