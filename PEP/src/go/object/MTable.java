package go.object;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("hiding")
public class MTable<String, T>  {

	private List<String> keys;
	private List<T> values;

	public MTable() {
		this.keys = new ArrayList<String>();
		this.values = new ArrayList<T>();
	}

	public void put(String key, T value) {
		this.keys.add(key);
		this.values.add(value);
	}

	public List<String> getKeys() {
		return this.keys;
	}

	public List<T> getValues() {
		return this.values;
	}

	public T getValue(String key) {
		Integer index = Integer.valueOf(this.keys.indexOf(key));
		if (index.intValue() != -1) {
			return this.values.get(index.intValue());
		}
		return null;
	}
}