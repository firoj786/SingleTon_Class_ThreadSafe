package com.nt.solve.code;

/**
 * Write a java program to create a singleton class.s
 * 
 * @author Firoj
 * @since 2022-01-05
 */
// Singleton a class is a class that can have only one instance or object of your class at one time.
// Singleton patterns is used insure that the class will have only one instance and it provides a global
//access point to that instruction.
//Let me show you how to implement this Verity of code.
// This is a singleton class i am going to make as singleton class.
//Make this singleton class i need to insure that there will we a variable which will be a type of singleton class.
//there will be a constructor which will be a private constructor i don't want this class to be access from out side 
//of this class i am create object by using constructor that's reason i am going to make class as a private.
class SingletonClass {
	// I make the as private because should not be access out side this class.
	private static SingletonClass instance;

	// i am going to make constructor as a private show that the object this class
	// can not be created out side this class.
	private SingletonClass() {
	}

//Create a method and that method should return instance of this class(instance).
	public static SingletonClass getInstance() {
		// This method check instance already exists or not if does not exists then i
		// will return i will create a new instance i will return in the instance
		// already exists then i will return the instance which will already created.
		// Instance is not created.
		if (instance == null) {
			// I need to create instance then send the return it back to this.
			// here i going to check, i am going to insure that in multi Multithreading
			// environment there will be only one thread who will create or can create the
			// instance at a time.i am going to write syncronized this syncronized will have
			// singleton class and this block will check again if the instance is created or
			// not. if the instance is created then return the instance. If the instance is
			// not created then again it is going to create the instance sended to back.
			// this approach called as double check login pattern.
			synchronized (SingletonClass.class) {
				if (instance == null) {
					instance = new SingletonClass();
				}

			}
		}
		return instance;

	}
}

public class TestSingleTonClass {

	public static void main(String[] args) {
		// If all the instance are same or not.
		// If the instances are same then this is singleton class and singleton
		// instance.
		SingletonClass singleton1 = SingletonClass.getInstance();
		SingletonClass singleton2 = SingletonClass.getInstance();
		// SingletonClass single3=new SingletonClass(); Not created because constructor
		// as a private not access the out side class.
		if (singleton1 == singleton2) {
			System.out.println("Both Object are same ");
		} else {
			System.out.println("Both Object are different");
		}
	}
}
