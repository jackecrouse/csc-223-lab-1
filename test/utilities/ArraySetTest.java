package utilities;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArraySetTest<E>
{
	
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
		ArrayList<Integer> arry = new ArrayList<Integer>(); 
		
		for(int i = 1; i <= 10; i++)
		{
			arry.add(i);
		}
		
		ArraySet<Integer> arrySet = new ArraySet<Integer>(arry); 
		
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", toString(arrySet));
		
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
		ArraySet<Integer> fullSet = populate(1, 5); 
		ArraySet<Integer> addSet = populate(3, 7);
		
		fullSet.addAll(addSet);
		
		assertEquals("[1, 2, 3, 4, 5, 6, 7]", toString(fullSet));
		
		fullSet.addAll(populate(8,10));
		
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", toString(fullSet));

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
		
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
		ArraySet<Integer> fullSet = populate(-1, 5); 
		ArraySet<Integer> subSet = populate(3, 7); 
		
		fullSet.addAll(5, subSet);
		
		assertEquals("[-1, 0, 1, 2, 3, 4, 5, 6, 7]", toString(fullSet));

		ArraySet<Integer> testSet = new ArraySet<Integer>();
		
		testSet.add(-5);
		testSet.add(1);
		testSet.add(3);
		testSet.add(5);
		
		testSet.addAll(2, populate(4, 9));
		assertEquals("[-5, 1, 3, 5, 4, 6, 7, 8, 9]", toString(testSet));
		
	}
}
