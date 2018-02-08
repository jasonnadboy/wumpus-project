package test;

import gridCave.Cave;
import gridCave.Cavern;

public class TotalNumberOfCaverns {
	
	private Cave caverns = new Cave();
	
	public boolean totalNumberOfCavernsIs(int numberOfCaverns) {
		Cavern[][] cave = caverns.getCave();
		int length = cave.length;
		int width = cave[0].length;
		for(int x = 0; x < length; x++) {
			for(int y = 0; y < width; y++) {
				if(cave[x][y]==null) {
					return false;
				}
			}
		}
		if(length*width == numberOfCaverns) {
			return true;
		}
		else{
			return false;
		}
	}

}
