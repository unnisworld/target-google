import java.util.*;

public class GenericsArray 
{
	public static void main(String[] args) {
		Dog[] dogs = { new Dog(), new Dog() };
		Cat[] cats = { new Cat(), new Cat(), new Cat() };
		Bird[] birds = { new Bird() };
		
		List<Dog> dogsList = Arrays.asList(dogs);
		List<Cat> catsList = Arrays.asList(cats);
		List<Bird> birdsList = Arrays.asList(birds);
		
		AnimalDoctor doc = new AnimalDoctor();
		doc.checkAnimals(dogs); 
		doc.checkAnimals(cats); 
		doc.checkAnimals(birds);
	}
	
	static abstract class Animal {
		public abstract void checkup();
	}

	static class Dog extends Animal {
		public void checkup() { 
			System.out.println("Dog checkup");
		}
	}

	static class Cat extends Animal {
		public void checkup() { 
			System.out.println("Cat checkup");
		}
	}

	static class Bird extends Animal {
		public void checkup() { 
			System.out.println("Bird checkup");
		}
	}

	static class AnimalDoctor {

		public void checkAnimals(Animal[] animals) {
			for (Animal a : animals) {
				a.checkup();
			}
		}
	}
}