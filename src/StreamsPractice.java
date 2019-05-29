import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamsPractice {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		
		int sum = Arrays.stream(arr).sum();
		
		System.out.println(sum);
	}

}
