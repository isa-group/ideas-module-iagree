package es.us.isa.ideas.util;

public class KeyValueProp {
	
	public String key;
	public String value;
	public String assigValue;
	public String type;
	public String typeArg;
	
	
	public KeyValueProp() {}


	public KeyValueProp(String key, String value, String assigValue,
			String type, String typeArg) {
		super();
		this.key = key;
		this.value = value;
		this.assigValue = assigValue;
		this.type = type;
		this.typeArg = typeArg;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getAssigValue() {
		return assigValue;
	}


	public void setAssigValue(String assigValue) {
		this.assigValue = assigValue;
	}
	
	

}
