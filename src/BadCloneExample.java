import java.util.ArrayList;
import java.util.List;

public class BadCloneExample {

    List<Integer> seen = new ArrayList<>();
    int current = -1;

    public void add(int newCurrent) {
        seen.add(current);
        current = newCurrent;
    }

    public void clearHistory() {
        seen.clear();
    }

    public BadCloneExample clone() {
        BadCloneExample clone = new BadCloneExample();
        clone.current = current;
        clone.seen = seen;
        return clone;
    }
    
    public static void main(String[] args) {
    	BadCloneExample actual = new BadCloneExample();
    	actual.add(1);
    	actual.add(2);

    	System.out.println(actual.current);
    	System.out.println(actual.seen);
    	
    	BadCloneExample clonedInstance = actual.clone();
    	clonedInstance.add(3);
    	
    	System.out.println(actual.current);
    	System.out.println(actual.seen);
    	System.out.println(clonedInstance.current);
    }
}