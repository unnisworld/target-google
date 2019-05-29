import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
	private Map<K,Entry<K, V>> entries = null;
	private Entry<K, V> head, tail;
	private int maxSize;
	
	LRUCache(int maxSize) {
		entries = new HashMap<>(maxSize);
		this.maxSize = maxSize;
	}
	
	public void put(K key, V value) {
		if (entries.containsKey(key)) {
			Entry<K, V> e = entries.get(key);
			removeFromList(e);
			addToTopOfTheList(e);
		} else {
			
			if (entries.size() == maxSize) {
				entries.remove(tail.key);
				removeFromList(tail);
			}
			
			Entry<K, V> e = new Entry<K, V>(); e.key = key; e.value = value;
			addToTopOfTheList(e);
			entries.put(key, e);
		}
	}
	
	public V get(K key) {
		if (entries.containsKey(key)) {
			Entry<K, V> e = entries.get(key);
			removeFromList(e);
			addToTopOfTheList(e);
			
			return e.value; 
		}
		
		return null;
	}
	
	private void removeFromList(Entry<K, V> entry) {
		if (entry.previous == null) {
			head = entry.next;
		} else {
			entry.previous.next = entry.next;
		}
		
		if (entry.next == null) {
			tail = entry.previous;
		} else {
			entry.next.previous = entry.previous; 
		}
	}
	
	private void addToTopOfTheList(Entry<K, V> entry) {
		entry.next = head;
		if (head != null) {
			head.previous = entry;
		}
		head = entry;
		
		if (tail == null)
		{
			tail = head;
		}
	}
	
	public void printList() {
		Entry<K, V> e = head;
		while(e != null) {
			System.out.print(e.key + "->");
			e = e.next;
		}	
		
		System.out.println("");
	}
	
	private static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;
		Entry<K, V> previous;
	}
	
	public static void main(String[] args) {
		LRUCache<String, String> cache = new LRUCache<String, String>(2);
		
		cache.put("foo1", "bar1");
		cache.put("foo2", "bar2");
		cache.printList();
		cache.put("foo1", "bar1");
		cache.printList();
		cache.put("foo3", "bar3");
		cache.printList();
		
		System.out.println(cache.get("foo1"));
		System.out.println(cache.get("foo2"));
		System.out.println(cache.get("foo3"));
	}
}
