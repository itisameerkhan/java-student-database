package StudentDatabase;

import java.sql.*;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Student Database-----");
		while(true)
		{
			int choice;
			System.out.println("----------------------");
			System.out.println("1. Add Student Info");
			System.out.println("2. Display Student Name");
			System.out.println("3. display entire Students info");
			System.out.println("4. Delete Student data");
			System.out.println("5. Update Student Name");
			System.out.println("6. Exit");
			System.out.println("-----------------------");
			System.out.print("Enter the choice: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				StudentDatabase.AddInfo(new Student());
				break;
				
			case 2:
				System.out.print("Enter the roll no: ");
				int roll = sc.nextInt();
				String ans = StudentDatabase.findName(roll);
				System.out.println(ans);
				break;
				
			case 3:	
				StudentDatabase.DisplayAllInfo();
				break;
			
			case 4:
				System.out.print("Enter the roll no: ");
				int r = sc.nextInt();
				StudentDatabase.DeleteStudentInfo(r);
				break;
			
			case 5:
				System.out.print("Enter the name: ");
				String n = sc.next();
				System.out.print("Enter the rollno: ");
				int rl = sc.nextInt();
				StudentDatabase.UpdateStudentName(rl,n);
				break;
				
			case 6:
				System.exit(0);
				
			default:
				System.out.println("not found");
			}
		}
	}
}