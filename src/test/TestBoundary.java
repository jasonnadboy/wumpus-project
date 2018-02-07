package test;

import gridCave.Cave;

public class TestBoundary {
	
	Cave cave = new Cave();
	
	public TestBoundary() {
		
	}
	
	public String cavernDirectionGeneratesErrorMessage(int cavernNumber, String direction) {
		
		boolean boundaryExists = cave.boundaryExists(cavernNumber, direction);
		
		if(boundaryExists) {
			return "You can't go " + direction + " from here";
		}
		return "";
	}
}
