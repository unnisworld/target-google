package corejava;

public class TypeInferenceJava5 {
	
	// Type inference - mechanism used be a compiler to identify a type that has not been
	// specified. Type inference has been there in the Java compiler since Java 5.
	
	// eg: of Type inference from Java 5 - Parametric method or Generic Method.
	public static void main(String[] args) {
		int[] intArr = {1,2,3,4};
		
		Integer[] integerArr = {Integer.valueOf(1), Integer.valueOf(2)};
		String[] strArr = {"foo", "bar"};
		Student[] studentArr = {new Student("Alex"), new Student("Maya")}; 
		
		// Won't work for primitive type.
		// System.out.println(getFirst(intArr));
		
		// Compiler infers the type as Integer as we are passing an array of Integer.
		// and validates that the method can be invoked with this parameter.
		System.out.println(getFirst(integerArr));
		
		// Compiler infers the parameter type as String as we are passing an array of Strings
		// and validates that the method can be invoked with this parameter.
		System.out.println(getFirst(strArr));
		
		// Compiler infers the parameter type as Student as we are passing an array of Students
		// and finds that this invocation cannot be performed because Student does not implement
		// comparable.
		// System.out.println(getFirst(studentArr));
	}
	
	// Because of type erasure the compiler compiles this code into : 
	// private static Comparable getFirst(Comparable[] arr) {
	// 		return arr.length == 0 ? null : arr[0];
	// }
	// Read more about type erasure at - https://www.baeldung.com/java-type-erasure
	private static <T extends Comparable> T getFirst(T[] arr) {
		return arr.length == 0 ? null : arr[0];
	}
	
	static class Student {
		private String name;
		Student(String name) {
			this.name = name;
		}
	}

}
