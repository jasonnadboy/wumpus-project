package test;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TestBats t = new TestBats();
		TestWumpusRandomStartingLocation t = new TestWumpusRandomStartingLocation();
		System.out.println(t.wumpusStartingPointIsRandomlyDistributed());
		
		TestWumpusRandomMovement t2 = new TestWumpusRandomMovement();
		System.out.println(t2.eventDistributionOfWumpusLocationAfter1000Moves());
		
	}

}
