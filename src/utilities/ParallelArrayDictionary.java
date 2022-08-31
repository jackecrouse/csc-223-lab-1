package utilities;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
	protected ArraySet<Key> _keys;
	protected ArraySet<Value> _values;
	

	public ParallelArrayDictionary()
	{
		_keys = new ArraySet<Key>();
		_values = new ArraySet<Value>(); 
		
	}
	

	@Override
	public int size() {

		return _keys.size();
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return _keys.isEmpty(); 
	}


	@Override
	public boolean containsKey(Object key) {

		return _keys.contains(key);
	}


	@Override
	public boolean containsValue(Object value) {

		return _values.contains(value);
	}


	@Override
	public Value get(Object key) {
		// TODO Auto-generated method stub

		int index = _keys.indexOf(key);
		
		if(index == -1) {return null;}

		return _values.get(index);
	}
	
	

	@Override
	public Value put(Key key, Value value) {

		int index = _keys.indexOf(key);
		
		if(index == -1)
		{
			_keys.add(key);
			_values.add(value);
			
			return null; 
		}

		Value oldVal = _values.get(index);
		_values.set(index, value);
		return oldVal;
	}


	@Override
	public Value remove(Object key) {
		
		int index = _keys.indexOf(key);
		
		if(index == -1)
		{
			return null;
		}
		
		Value oldVal = _values.get(index);
		
		_keys.remove(index);
		_values.remove(index);
		
		return oldVal;
		
	}


	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		
		for(Key key : m.keySet())
		{
			this.put(key, m.get(key));
		}
	}


	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
	}


	@Override
	public Set<Key> keySet() {return _keys;}

	@Override
	public Collection<Value> values() {
		// TODO Auto-generated method stub
		return _values; 		//(Collection<Value>) _values;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Set<Entry<Key, Value>> entrySet() {
		// TODO Auto-generated method stub
		return (Set<Entry<Key, Value>>) this;
	}
	
	
	

}
