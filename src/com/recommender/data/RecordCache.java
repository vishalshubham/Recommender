package com.recommender.data;

import java.util.ArrayList;
import java.util.HashMap;

public class RecordCache {

	private static HashMap<String, RecordBulk> recordMap = new HashMap<String, RecordBulk>();
	
	public static RecordBulk getRecordBulk(String key){
		RecordBulk cachedRecordBulk = recordMap.get(key);
		return (RecordBulk) cachedRecordBulk.clone();
	}
	
	public static boolean hasKey(String key){
		if(recordMap.containsKey(key))
			return true;
		return false;
	}
	
	public static void loadCache(String key, RecordBulk recordBulk){
		recordMap.put(key, recordBulk);
	}
}
