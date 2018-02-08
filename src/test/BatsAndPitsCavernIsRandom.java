package test;

import java.util.ArrayList;

import gridCave.Cave;
import gridCave.Cavern;
import gridCave.Game;

public class BatsAndPitsCavernIsRandom {
	private int[] count = new int[25];
	
	public BatsAndPitsCavernIsRandom() {
		
	}
	
	public void TestPitsRandomPlacement() {
		for (int i = 0; i < 10000; i++) {
			Cave newCave = new Cave();
			ArrayList<Cavern> pitCaverns = newCave.getCavernWithPits();
			for(Cavern c : pitCaverns) {
				int cavernNumber = c.getCavernNumber();
				count[cavernNumber-1]++;
			}
		}
		
	}
	
	public void TestBatsRandomPlacement() {
		for (int i = 0; i < 10000; i++) {
			Cave newCave = new Cave();
			ArrayList<Cavern> batCaverns = newCave.getCavernsWithBats();
			for(Cavern c : batCaverns) {
				int cavernNumber = c.getCavernNumber();
				count[cavernNumber-1]++;
			}
		}
		
	}
	
	public boolean evenDistributionAfter10000Games() {
		for (int c = 0; c < count.length; c++) {
			System.out.println(String.valueOf(c));
			if(c != 24) {
				if (count[c] < 250) {
					return false;
				}
			}
		}
		return true;
	}
}
