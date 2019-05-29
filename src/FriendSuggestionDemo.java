import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

// Implement a getFriendSuggestion() method that returns a List of potential friends
// based on a persons current friends list.

// The person with max FoF count (FoF - friend of friend) has the highest probability of
// being a friend.

// eg: 
// A has friends B, C & D
// B has friends X, Y, Z
// C has friends Y, Z
// D has friends Z
// getFriendSuggestion(A) should return (Z,3) followed by (Y,2) and (X,1).
public class FriendSuggestionDemo {
  public static void main(String[] args) {
    Person A = new Person("A");
    Person B = new Person("B");
    Person C = new Person("C");
    Person D = new Person("D");

    Person X = new Person("X");
    Person Y = new Person("Y");
    Person Z = new Person("Z");
  
    A.friends = Arrays.asList(new Person[] {B, C, D});

    B.friends = Arrays.asList(new Person[] {X, Y, Z});
    C.friends = Arrays.asList(new Person[] {Y,Z});
    D.friends = Arrays.asList(new Person[] {Z});

    List<PotentialFriend> suggestions = getFriendSuggestion(A);
    for (PotentialFriend pf : suggestions) {
      System.out.println(pf.p.name + ", " + pf.count);
    }
  }

  static List<PotentialFriend> getFriendSuggestion(Person p) {
    Map<Person, Integer> fofCount = new HashMap<>();

    for (Person friend : p.friends) {
      for (Person fof : friend.friends) {
        Integer currentCount = fofCount.get(fof);
        if (currentCount == null) {
          fofCount.put(fof, 1);
        } else {
          fofCount.put(fof, currentCount+1);
        }
      }
    }

    List<PotentialFriend> suggestions = new ArrayList<>();
    for (Map.Entry<Person, Integer> entry : fofCount.entrySet()) {
      //System.out.println(entry.getKey() + ", " + entry.getValue());
      suggestions.add(new PotentialFriend(entry.getKey(), entry.getValue()));
    }

    Collections.sort(suggestions);

    return suggestions;
  }
}

class Person {
  String name;
  List<Person> friends;

  Person(String n) {
    this.name = n;
  }

  @Override
  public boolean equals(Object other) {
    if ( other == null || !(other instanceof Person) ) {
      return false;
    }

    Person otherPerson = (Person)other;

    return this.name.equals(otherPerson.name);
  }

  @Override
  public int hashCode() {
    return this.name.hashCode();
  }

  public String toString() {
    return name;
  }
}

class PotentialFriend implements Comparable<PotentialFriend> {
  Person p;
  int count;

  PotentialFriend(Person p, int count) {
    this.p = p;
    this.count = count;
  }

  public int compareTo(PotentialFriend other) {
    return other.count - this.count;
  }
}