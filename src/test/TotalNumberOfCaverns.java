package test;

import gridCave.Cave;
import gridCave.Cavern;

public class TotalNumberOfCaverns {
	
	private Cave caverns = new Cave();
	
	public int totalNumberOfCavernsIs() {
		Cavern[][] cave = caverns.getCave();
		int length = cave.length;
		int width = cave[0].length;
		return (length*width);
	}

}
