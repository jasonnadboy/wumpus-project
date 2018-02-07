package gridCave;

public class draw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cave c = new Cave();
		Cavern[][] ca = c.getCave();
		System.out.println(ca[1][2].getCavernNumber());
	}

}
