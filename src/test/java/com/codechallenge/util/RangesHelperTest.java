package com.codechallenge.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class RangesHelperTest {

	/**
	 */

	@Test
	public void processRangesEmptyList(){    	
		RangesHelper ranges = new RangesHelper();
		List<String> dataList = new ArrayList<String>();
		List<String> resultList = ranges.processRanges(dataList);
		assertNotNull(resultList);
		assertEquals(0,resultList.size());
	}

	@Test
	public void processRangesWithOneRangeAndSameBounds(){    	
		RangesHelper ranges = new RangesHelper();
		List<String> dataList = new ArrayList<String>();
		dataList.add("94133,94133");
		List<String> resultList = ranges.processRanges(dataList);
		assertNotNull(resultList);
		assertEquals(2,resultList.size());
		assertEquals("94133",resultList.get(0));
		assertEquals("94133",resultList.get(1));
	}
	
	@Test
	public void processRangesWithInValidRange(){    	
		RangesHelper ranges = new RangesHelper();
		List<String> dataList = new ArrayList<String>();
		dataList.add("94133,94033");
		List<String> resultList = ranges.processRanges(dataList);
		assertNotNull(resultList);
		assertEquals(1,resultList.size());
		assertEquals("94133",resultList.get(0));
	}

	@Test
	public void processRangesWithValidRange(){    	
		RangesHelper ranges = new RangesHelper();
		List<String> dataList = new ArrayList<String>();
		dataList.add("94200,94299");
		List<String> resultList = ranges.processRanges(dataList);
		assertNotNull(resultList);
		assertEquals(2,resultList.size());
		assertEquals("94200",resultList.get(0));
		assertEquals("94299",resultList.get(1));
	}

	@Test
	public void processRangesFullListWithTwoRangesAndDifferentBounds(){    	
		RangesHelper ranges = new RangesHelper();
		List<String> dataList = new ArrayList<String>();
		dataList.add("94133,94133");
		dataList.add("94200,94299");
		List<String> resultList = ranges.processRanges(dataList);
		assertNotNull(resultList);
		assertEquals(4,resultList.size());
		assertEquals("94133",resultList.get(0));
		assertEquals("94133",resultList.get(1));
		assertEquals("94200",resultList.get(2));
		assertEquals("94299",resultList.get(3));
	}

	@Test
	public void processRangesFullListWithThreeRangesAndDifferentBounds(){    	
		RangesHelper ranges = new RangesHelper();
		List<String> dataList = new ArrayList<String>();
		dataList.add("94133,94133");
		dataList.add("94200,94299");
		dataList.add("94226,94399");
		List<String> resultList = ranges.processRanges(dataList);
		assertNotNull(resultList);
		assertEquals(4,resultList.size());
		assertEquals("94133",resultList.get(0));
		assertEquals("94133",resultList.get(1));
		assertEquals("94200",resultList.get(2));
		assertEquals("94399",resultList.get(3));
	}


	@Test
	public void processRangesFullListWithMultipleRangesAndDifferentBounds(){    	
		RangesHelper ranges = new RangesHelper();
		List<String> dataList = new ArrayList<String>();
		dataList.add("94226,94399");
		dataList.add("94523,94523");
		dataList.add("94633,94670");
		dataList.add("94650,94700");
		dataList.add("94750,94750");
		dataList.add("94800,94950");
		dataList.add("94900,94999");
		List<String> resultList = ranges.processRanges(dataList);
		assertNotNull(resultList);
		assertEquals(10,resultList.size());
		assertEquals("94226",resultList.get(0));
		assertEquals("94399",resultList.get(1));
		assertEquals("94523",resultList.get(2));
		assertEquals("94523",resultList.get(3));
		assertEquals("94633",resultList.get(4));
		assertEquals("94700",resultList.get(5));
		assertEquals("94750",resultList.get(6));
		assertEquals("94750",resultList.get(7));
		assertEquals("94800",resultList.get(8));
		assertEquals("94999",resultList.get(9));
	}
	
	@Test
	public void processRangesFullListWithMultipleRangesNotInOrder(){    	
		RangesHelper ranges = new RangesHelper();
		List<String> dataList = new ArrayList<String>();

		dataList.add("94226,94399");
		dataList.add("94523,94523");
		dataList.add("94633,94670");
		dataList.add("94650,94700");
		dataList.add("94800,94950");
		dataList.add("94900,94999");
		dataList.add("94750,94750");
		dataList.add("94133,94133");
		List<String> resultList = ranges.processRanges(dataList);
		assertNotNull(resultList);
		assertEquals(12,resultList.size());
		assertEquals("94133",resultList.get(0));
		assertEquals("94133",resultList.get(1));
		assertEquals("94226",resultList.get(2));
		assertEquals("94399",resultList.get(3));
		assertEquals("94523",resultList.get(4));
		assertEquals("94523",resultList.get(5));
		assertEquals("94633",resultList.get(6));
		assertEquals("94700",resultList.get(7));
		assertEquals("94750",resultList.get(8));
		assertEquals("94750",resultList.get(9));
		assertEquals("94800",resultList.get(10));
		assertEquals("94999",resultList.get(11));
	}



}
