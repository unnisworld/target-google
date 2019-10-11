package corejava;

import java.util.ArrayList;
import java.util.List;

public class Lambda {

	public static void main(String[] args) {
		MyLambda greet = () -> System.out.println("Hello World");
		ArrayList<String> a = new ArrayList<>();
		a.stream();
	}

}

interface MyLambda {
	void foo();
}
