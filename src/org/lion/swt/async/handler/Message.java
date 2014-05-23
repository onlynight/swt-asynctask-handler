package org.lion.swt.async.handler;

import java.util.HashMap;
import java.util.Map;

public class Message {

	public int id;
	public Object content;
	public Object control;
	
	private Map<String, Object> extras = new HashMap<String,Object>();
	
	public Map<String, Object> getExtras(){
		return extras;
	}
	
	public void putExtra( String key , Object value ){
		this.extras.put(key, value);
	}
	
	public void putExtras( Map<String, Object> extras ){
		this.extras.putAll(extras);
	}
	
	public Object getExtra( String key ){
		return this.extras.get(key);
	}
}
