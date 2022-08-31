package utilities;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class ArraySetTest<E>
{
	
	@SuppressWarnings("unchecked")
	ArraySet<Integer> populate(int low, int high)
	{
		ArraySet<Integer> arrySet = new ArraySet<Integer>();
		
		for(Integer i = low; i <= high; i++)
		{
			arrySet.add(i);
		}
		
		return arrySet;
	}
	
	String toString(ArraySet<Integer> arry)
	{
		String res = "[";
		
		for(Integer item: arry)
		{
			res += item + ", ";
		}
		
		res = res.substring(0, res.length() -2);
		return res += "]";
		
	}
	
	
	@Test
	void testArraySetCollectionOfE()
	{
		
		
	}

	@Test
	void testAddE()
	{
		ArraySet<Integer> emptySet = new ArraySet<Integer>();
		ArraySet<Integer> fullSet = populate(1, 10); 
		
		assertFalse(fullSet.add(10));
		assertTrue(fullSet.add(11));
		assertTrue(emptySet.add(1));
		
		emptySet.add(1);
		emptySet.add(2);
		emptySet.add(3);
		emptySet.add(3);
		emptySet.add(null);
		emptySet.add(null);
			
		assertEquals("[1, 2, 3, null]", toString(emptySet));
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
	}

	@Test
	void testRetainAll()
	{
		ArraySet<Integer> fullSet = populate(3, 7); 
		ArraySet<Integer> subSet = populate(4, 6); 
		
		fullSet.retainAll(subSet);
		
		assertEquals(toString(fullSet), "[4, 5, 6]");
		
		subSet = populate(1,4);
		
		fullSet.retainAll(subSet);
		
		assertEquals(toString(fullSet), "[4]");
		

	}

	@Test
	void testRemoveAll()
	{
		ArraySet<Integer> fullSet = populate(3, 7); 
		ArraySet<Integer> testSet = populate(5, 7);
		ArraySet<Integer> testSet2 = populate(8, 9);
	
		assertTrue(fullSet.removeAll(testSet));
		
		assertTrue(fullSet.contains(3));
		
		assertFalse(fullSet.contains(6));
		
		assertFalse(fullSet.removeAll(testSet2));
		
		
		//test comment
		
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
	}
}
