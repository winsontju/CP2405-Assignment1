import java.awt.Color;
import java.awt.Graphics;

public class Bike extends Vehicle{

	public Bike(int x, int y) {
		super(x, y);
		width=30;
		height=10;
		speed=20;
	}
	public void paintMe(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}
