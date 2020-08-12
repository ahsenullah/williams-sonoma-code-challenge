package com.codechallenge.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * This class provides the ranges computing functionality 
 */
public class RangesHelper {
	

	/**
	 * Assumption: the input list will have 2 sets of ranges like { [222,333] , [4444,5555]}
	 * and it will return a list of ranges with the first 2 paired as starting and ending range.
	 * @param List of <String> ranges
	 * @return minimum ranges List
	 */
	public List<String> processRanges(List<String> list){
		
		List<String> dataList = new ArrayList<>();

		if(list == null || list.isEmpty()){
			return dataList;	//return empty list if no ranges found
		}
		
		//sort the input list in sequence
		List<Range> rangesList = sortRangesInSequence(list);
		
		int [][] doubleDataArray = new int [rangesList.size()][2];
		int [] dataArray = new int [rangesList.size()*2];
		int count=0;
		
		//iterate through the list and store in single and double dimension array
		//single dimension array will be sorted
		for(int i=0;i<rangesList.size();i++){
			Range range = rangesList.get(i);
			doubleDataArray[i][0]=range.first;
			doubleDataArray[i][1]=range.second;
			dataArray[count++]=range.first;
			dataArray[count++]=range.second;	
		}
		
		Arrays.sort(dataArray); // sort the data array


		int counter=0;
		boolean isFirst=true;
		for(int i=0;i<rangesList.size();i++){
			int first = counter++;
			int second = counter++;
			if(doubleDataArray[i][0] == dataArray[first] && 
					doubleDataArray[i][1] == dataArray[second]){
				dataList.add(String.valueOf(doubleDataArray[i][0]));
				dataList.add(String.valueOf(doubleDataArray[i][1]));
				isFirst=true;
			}
			else{
				if(isFirst){
					dataList.add(String.valueOf(doubleDataArray[i][0]));
					isFirst=false;
				}
				else{
					dataList.add(String.valueOf(doubleDataArray[i][1]));
				}
			}
		}
		
		return dataList;
	}

	private List<Range> sortRangesInSequence(List<String> list) {		
		List<Range> returnList = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			String dataStr = list.get(i);
			String [] dataVal = dataStr.split(",");
			Range range = new Range();
			range.first=Integer.parseInt(dataVal[0]);
			range.second=Integer.parseInt(dataVal[1]);
			returnList.add(range);			
		}		
		Collections.sort(returnList);
		
		return returnList;
	}
	
	class Range implements Comparable<Range> {
		int first;
		int second;
		
		@Override
		public int compareTo(Range range) {
			if( this.first < range.first)
					return -1;
			else if ( this.first > range.first)
				return 1;
			return 0;
		}
		
	}


}
