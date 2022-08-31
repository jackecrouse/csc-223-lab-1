package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{

	@Test
	void testParallelArrayDictionary()
	{
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer, String>();

		dict.put(1, "a");
		dict.put(2, "b");

		assertTrue(dict.containsKey(1));
		assertTrue(dict.containsKey(2));
		
		assertEquals("a", dict.get(1));
		assertEquals("b", dict.get(2));

	}

	@Test
	void testGet()
	{
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer,String>();
		dict.put(1,"a");
		dict.put(2,"b");

		assertEquals(dict.get(1), "a");

		assertEquals(dict.get(6), null);
	}

	@Test
	void testPut()
	{
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer,String>();
		dict.put(1,"a");
		dict.put(2,"b");
		dict.put(3,"c");
		dict.put(4,"d");

		assertEquals(dict.put(1 , "z"), "a");

		assertEquals(dict.put(8, "z"), null);

		assertTrue(dict.containsValue("b"));

		assertTrue(dict.containsKey(4));
	}

	@Test
	void testRemove()
	{
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer,String>();
		dict.put(1,"a");
		dict.put(2,"b");
		dict.put(3,"c");
		dict.put(4,"d");

		assertEquals(dict.remove(1), "a");
		
		assertFalse(dict.containsKey(1));
		

		assertEquals(dict.remove(5), null);
	}

	@Test
	void testPutAll()
	{
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer,String>();
		ParallelArrayDictionary<Integer, String> testDict = new ParallelArrayDictionary<Integer,String>();

		dict.put(1,"a");
		dict.put(2,"b");
		testDict.put(1,"a");
		testDict.put(2,"b");
		testDict.put(3,"c");
		testDict.put(4,"d");

		dict.putAll(testDict);
		assertTrue(dict.containsKey(3));

		assertTrue(dict.containsValue("d"));

		assertTrue(dict.containsKey(1));

		assertTrue(dict.containsValue("b"));
	}

	@Test
	void testClear()
	{
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer,String>();

		dict.put(1,"a");
		dict.put(2,"b");

		dict.clear();

		assertFalse(dict.containsKey(1));

		assertFalse(dict.containsValue("a"));


	}
}
