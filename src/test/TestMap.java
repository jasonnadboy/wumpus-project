package test;

import cave.DIR;
import maps.TestMap9;

public class TestMap {
	
	TestMap9 theMap;
	String from;
	String to;
	
	public TestMap() {
		theMap = new TestMap9();
	}
	
	public void setX(int x) {
		from = String.valueOf(x);
	}
	
	public void setY(int y) {
		to = String.valueOf(y);
	}
	
	public DIR direction() {
		return theMap.getConnection(from, to);
	}

}
