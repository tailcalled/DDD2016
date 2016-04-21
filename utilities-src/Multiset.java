import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public /*static*/ class Multiset<K> {
	
	private Map<K, Integer> underlying;
	
	public Multiset() {
		this(new HashMap<K, Integer>());
	}
	public Multiset(Map<K, Integer> underlying) {
		this.underlying = underlying;
	}
	public Multiset(Multiset<K> set) {
		this(new HashMap<>(set.underlying));
	}
	
	public void add(K key) {
		add(key);
	}
	public void add(K key, int amount) {
		underlying.put(key, count(key) + amount);
	}
	private void checkKey(K key) {
		if (!underlying.containsKey(key)) {
			underlying.put(key, 0);
		}
	}
	public int count(K key) {
		checkKey(key);
		return underlying.get(key);
	}
	public void remove(K key) {
		add(key, -1);
	}
	public void union(Multiset<K> other) {
		for (K key: other.underlying.keySet()) {
			add(key, other.count(key));
		}
	}
	public Set<K> keys() {
		Set<K> keySet = underlying.keySet();
		for (K key: keySet) {
			if (count(key) == 0) keySet.remove(key);
		}
		return keySet;
	}
	
}
