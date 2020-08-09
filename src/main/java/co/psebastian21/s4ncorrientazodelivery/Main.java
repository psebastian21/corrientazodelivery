package co.psebastian21.s4ncorrientazodelivery;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to S4N's Corrientazo Delivery app 1.0!");
		System.out.println("Proceeding with default values");
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		try {
			DeliverySystem.setMaxDrones(3);
			DeliverySystem system = new DeliverySystem();
			system.work();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
