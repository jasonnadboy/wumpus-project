package test;

import maps.TestMap9;

public class TestMap {
	
	TestMap9 theMap;
	String from;
	String to;
	
	public TestMap() {
		theMap = new TestMap9();
	}
	
	public void setX(String x) {
		from = x;
	}
	
	public void setY(String y) {
		to = y;
	}
	
	public String direction() {
		return theMap.getConnection(from, to).toString();
	}

}
