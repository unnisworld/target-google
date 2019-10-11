package corejava;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapSample {

	public static void main(String[] args) 
	{
		String[][] data = new String[][] { {"a", "b"}, {"c", "d"}};
	
		//Stream of String[]
		Stream<String[]> nestedStream = Arrays.stream(data);
	
		//Stream of String
		Stream<String> flattenedStream = nestedStream.flatMap(x -> Arrays.stream(x));
		
		flattenedStream.filter(x -> "a".equals(x.toString())).forEach(System.out::println);
	}

}
