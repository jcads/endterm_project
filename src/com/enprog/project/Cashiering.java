package com.enprog.project;

import java.util.*;

public class Cashiering {
	Scanner in = new Scanner(System.in);
	int choice;
	int quantity;
	int itemCount = 0; 
	int order;
	double totalPrice, payment;
	ArrayList<String> receiptItems = new ArrayList<String>();
	ArrayList<Integer> receiptQuantityList = new ArrayList<Integer>();
	ArrayList<Double> receiptPriceList = new ArrayList<Double>();
	
	//creates drug objects
	Drug drug1 = new Drug("Neozep", 5.5);
	Drug drug2 = new Drug("Biogesic", 4.75);
	Drug drug3 = new Drug("Bioflu", 7.5);
	Drug drug4 = new Drug("Centrum adv", 10.5);
	Drug drug5 = new Drug("Enervon tab", 6.8);
	
	String drug[] = {drug1.name, drug2.name, drug3.name, drug4.name, drug5.name};
	Double drugPrice[] = {drug1.price, drug2.price, drug3.price, drug4.price, drug5.price};

	ArrayList<String> drugList = new ArrayList<String>(Arrays.asList(drug));
	ArrayList<Double> drugPriceList = new ArrayList<Double>(Arrays.asList(drugPrice));
	
	
	public void showMenu() {
		String[] menu = {"Place order", "Add product", "Close"};
		System.out.println();
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("[%d] %s\n", i + 1, menu[i]);
		}
		System.out.println();
		System.out.print("What would you like to do? ");
		choice = in.nextInt();
		
		switch(choice) {
			case 1: this.placeOrder(); 
					break;
			case 2: this.addProduct();
					break;
			case 3: System.out.println("\nHave a good day!");
					break;
			default: System.out.println("Error");
		}
	}
	
	public void placeOrder() {
		
		System.out.println();
		System.out.println("\tProduct name \t\tPrice");
		//prints the products and product price
		for (int i = 0; i < drugList.size(); i++) {
			System.out.printf("[%d]\t %s \t\t%5.2f\n", i+1, drugList.get(i), drugPriceList.get(i));
		}
		System.out.printf("\n[%d]\t CHECKOUT\n", drugList.size() + 1);
		System.out.printf("[%d]\t QUIT\n", drugList.size() + 2);
		
		//order process
		do {
			System.out.println();
			System.out.print("Enter order: ");
			order = in.nextInt();
			if (order == drugList.size() + 1)
				break;
			if (order == drugList.size() + 2) {
				//clears the items on the receipt when users quits
				System.out.println("------------------------------------------");
				receiptItems.clear();
				receiptQuantityList.clear();
				receiptPriceList.clear();
				this.showMenu();
				return;
			}
		
			System.out.println(drugList.get(order - 1));
			System.out.print("Quantity: ");
			quantity = in.nextInt();
			
			//adds item, quantity, and price to the list for receipt
			receiptItems.add(drugList.get(order - 1));
			receiptQuantityList.add(quantity);
			receiptPriceList.add(drugPriceList.get(order - 1));
			
			double tempPrice = drugPriceList.get(order - 1) * quantity;
			totalPrice += tempPrice;
					
			itemCount++;
		} while(choice != 6);
		
		System.out.printf("Amount Due: %.2f\n", totalPrice);
		System.out.print("Enter payment: ");
		payment = in.nextDouble();
		
		this.receipt();
		//System.out.println(items);
		
	}
	
	public void receipt() {
		System.out.println("--------------------------------------------");
		System.out.println("R E C E I P T");
		System.out.println("\tItem\tQuantity\tUnit Price\tAmount");
		for (int k = 0; k < itemCount; k++) {
			System.out.printf("%15s\t%5d \t %12.2f %16.2f\n", receiptItems.get(k),receiptQuantityList.get(k), receiptPriceList.get(k), receiptPriceList.get(k) * receiptQuantityList.get(k));
		}
		
		System.out.printf("\nAmount due: %.2f\n", totalPrice);
		System.out.printf("Change: %.2f", payment - totalPrice);
	}
	
	public void addProduct() {
		System.out.print("How many products would you like to add? ");
		int counter = in.nextInt();
		in.nextLine();
		
		for (int i = 0; i < counter; i++) {
			System.out.print("Product name: ");
			drug[drug.length - 1] = in.nextLine();
			drugList.add(drug[drug.length - 1]);
			System.out.print("Price: ");
			drugPrice[drugPrice.length - 1] = in.nextDouble(); 
			drugPriceList.add(drugPrice[drugPrice.length - 1]);
			System.out.println();
			in.nextLine();
		}
		
		this.showMenu();
		return;
	}
	//get the length of the list and use it as index to add product
	//limit the length of the string to be read
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
