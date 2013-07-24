package org.ananth.learning.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.hadoop.io.Text;

public class KeySortBuilder {

	private List<String> keyList = new ArrayList<String>();

	public KeySortBuilder() {  
		super();
	}  

	public KeySortBuilder(String first, String second) {
		super();
		this.setFirst(first);
		this.setSecond(second);
	}

	public KeySortBuilder setFirst(final String first) {
		this.keyList.add(first);
		return this;
	}
	
	public KeySortBuilder setSecond(final String second) {
		this.keyList.add(second);
		return this;
	}   
	
	
	
	public Text build() {		
		Collections.sort(keyList);
		String key = "";  
		for(String s : keyList) {
			key += s + "-";
		}		
		return new Text(key.substring(0, key.length() - 1));
	}

}
