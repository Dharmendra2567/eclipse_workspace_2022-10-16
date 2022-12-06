package com.testApp;

public class App {
	private int id;
	private String name;
	public App(int id, String name) {
		this.id=id;
		this.name=name;
		System.out.println(id+name);
	}
	

	public static void main(String[] args) {
		App app = new App(4,"dharmendra");
		
	}

}
