package corejava;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TypeInferencingSample2 {

	public static void main(String[] args) {
		ArrayList<String> t1 = 
				pick(new ArrayList<String>(), new ArrayList<String>());

	}
 
	static <T> T pick(T a1, T a2) { return a2; } 
}
