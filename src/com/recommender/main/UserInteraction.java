package com.recommender.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.recommender.data.Record;

public class UserInteraction {
	
	

	public static void main(String[] args) {
		UserInteraction userInteraction = new UserInteraction();
		userInteraction.startInteraction();
		System.out.println("Thanks for using our Recommendation system");
	}
	
	public void startInteraction(){
		Scanner input = new Scanner(System.in);
		UIRequestHandler userRequestHandler = null;
		String userId = null;
		int option;
		
		do{
			System.out.println("Enter your choice: \n" +
					"1. Login\n" +
					"2. General recommendations\n" +
					"3. Category Recommendations\n" + 
					"4. Logout\n");
			option = input.nextInt();
			input.nextLine();
			
			if( userRequestHandler==null && option !=1){
				System.out.println("You first need to login. Please choose option 1 first!!!");
			}
			else{
				switch(option){
				case 1: System.out.println("Enter userId: ");
						userId = input.nextLine();
						userRequestHandler = new UIRequestHandler(userId);
						System.out.println("Result : User " + userId + " logged in!!!");
						break;
				case 2: System.out.println("Result : General recommendations for User " + userId + "!!!");
						printRecommendations(userRequestHandler.getGeneralRec());
						break;
				case 3: System.out.println("Result : Category recommendations for User " + userId + "!!!");
						printRecommendations(userRequestHandler.getCategoryRec());
						break;
				case 4: System.out.println("Result : User " + userId + " logged out!!!");
						userRequestHandler = null;
						userId = null;
						break;
				case 5: System.out.println("Result: Exiting the application!!!");
						userRequestHandler = null;
						userId = null;
						break;
				default: System.out.println("Please enter a valid value!!!");
				}
			}			
		}while(option!=5);
	}
	
	public void printRecommendations(ArrayList<Record> records){
		for(Record record: records){
			System.out.println("Name " + record.getItemName());
			System.out.println("Link " + record.getItemLink());
			System.out.println("Category " + record.getItemCategory());
			System.out.println("Date " + record.getClickedDate());
			System.out.println("User " + record.getUser());
			System.out.println(" ---------------------------------------- ");
		}
	}	
}
