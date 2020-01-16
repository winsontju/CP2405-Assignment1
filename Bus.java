import java.awt.Color;
import java.awt.Graphics;

public class Bus extends Vehicle{

	public Bus(int x, int y) {
		super(x, y);
		width=120;
		height=40;
		speed=7;
	}
	public void paintMe(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}

}
