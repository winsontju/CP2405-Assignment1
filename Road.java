import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Road extends JPanel {

	/**
	 * Create the panel.
	 */
	final int laneHeight=120;
	ArrayList<Vehicle> v=new ArrayList<Vehicle>();
	public Road() {
		super();
	}
	public void addVehicle(Vehicle vehicle) {
		v.add(vehicle);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getWidth();b+=40) {
				g.fillRect(b, a, 30, 5);
			}
		}
		for(int a=0;a<v.size();a++) {
			v.get(a).paintMe(g);
		}
	}

}
