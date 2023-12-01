package java_lab;

import java.util.Scanner;

class printTable{
	public synchronized void printMultiplicationTable(int Number) {
		System.out.println("\nthe multiplication table of "+Number+" is \n");
		
		for(int i=1;i<=10;i++) {
			System.out.println(Number+"x"+i+"="+i*Number);
		}
		
	}
}

class Thread1 extends Thread{
	printTable print ;
	int number1;
	Thread1(printTable m,int number1){
		this.print=m;
		this.number1=number1;
		
		
	}
	public void run() {
		print.printMultiplicationTable(number1);
	}
	
	
}
class Thread2 extends Thread{
	printTable print ;
	int number2;
	Thread2(printTable n,int number2){
		this.print=n;
		this.number2=number2;
	
}
	public void run() {
		print.printMultiplicationTable(number2);
	}
	
}
class Thread3 extends Thread{
	printTable print ;
	int number3;
	Thread3(printTable n,int number3){
		this.print=n;
		this.number3=number3;
	
}
	public void run() {
		print.printMultiplicationTable(number3);
	}
	
}	

public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter first number");
		int firstNumber=sc.nextInt();
		System.out.println("enter number second number");
		int secondNumber=sc.nextInt();
		System.out.println("enter number third number");
		int thirdNumber=sc.nextInt();


		printTable table=new printTable();
		Thread1 thread1=new Thread1(table,firstNumber);
		Thread2 thread2=new Thread2(table,secondNumber);
		Thread3 thread3=new Thread3(table,thirdNumber);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
	

}