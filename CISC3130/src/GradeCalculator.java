import java.util.Scanner;

public class GradeCalculator {
	public static double Calculate(int SumOfL,int SumOfP,int SumOfE, int Final) {
		double x = SumOfL, y = SumOfP, z = SumOfE, q = Final;
		double Finalgrade = x+y+z+q;
		return Finalgrade;	
	}
	public static char letterGrade(double grade) {
		char letter;
		if(grade < 60)
			letter = 'F';
		else if(grade >= 60 && grade <= 69)
			letter = 'D';
		else if(grade >= 70 && grade <= 79)
			letter = 'C';
		else if(grade >= 80 && grade <= 89)
			letter = 'B';
		else
			letter = 'A';
		return letter;
	}
	public static void main(String args[]) {
		int lab[] = new int [7], ProblemSet[] = new int [8], Exam[] = new int [2], Final;
		int SumOfL = 0, SumOfP = 0, SumOfE = 0; 
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to CISC 3130 Grade Calculator!");
		System.out.print("Enter your 7 labs grades: ");
		for(int i = 0; i < lab.length; i++) {
			lab[i] = sc.nextInt();
			SumOfL = SumOfL + lab[i];
		}
		System.out.print("Enter your 8 Problem set grades: ");
		for(int i = 0; i < ProblemSet.length; i++) {
			ProblemSet[i] = sc.nextInt();
			SumOfP = SumOfP + ProblemSet[i];
		}
		System.out.print("Enter your 2 Midterm grade: ");
		for(int i = 0; i < Exam.length; i++) {
			Exam[i] = sc.nextInt();
			SumOfE = SumOfE + Exam[i];
		}
		System.out.print("Enter your Final exam grade: ");
			Final = sc.nextInt();
			double grade = Calculate(SumOfL,SumOfP,SumOfE,Final);
		System.out.println("Your grade is "+ grade);
		System.out.println("Your letter grade is " + letterGrade(grade));
	}
}
