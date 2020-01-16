import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class City extends JPanel {
	final int laneHeight=300;
	final int bound1=50;
	final int bound2=650;
	ArrayList<Vehicle> v=new ArrayList<Vehicle>();
	/**
	 * Create the panel.
	 */
	public City() {
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		setBounds(187, 0, 855, 590);
		setLayout(null);
		setVisible(true);
	}
	public void addVehicle(Vehicle vehicle) {
		v.add(vehicle);
	}
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		
		
		g.setColor(Color.GRAY);
		g.fillRect(350, 0, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getHeight();b+=40) {
				g.fillRect(375, b, 5, 30);
			}
		}
	
		g.setColor(Color.GRAY);
		g.fillRect(0, 100, 870, 50);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getWidth();b+=40) {
				g.fillRect(b, 120, 30, 5);
			}
		}
		
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 400, 870, 50);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getWidth();b+=40) {
				g.fillRect(b, 420, 30, 5);
			}
		}
		
		g.setColor(Color.GRAY);
		g.fillRect(150, 400, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=430;b<getHeight();b+=40) {
				g.fillRect(173, b, 5, 30);
			}
		}
		
		
		g.setColor(Color.GRAY);
		g.fillRect(650, 400, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=430;b<getHeight();b+=40) {
				g.fillRect(673, b, 5, 30);
			}
		}
		for(int a=0;a<v.size();a++) {
			v.get(a).paintMe(g);
		}
		
	}
	public void step() {
		for(int i=0;i<v.size();i++) {
			Vehicle vehicle=v.get(i);
			vehicle.setX(vehicle.getX()+vehicle.getSpeed());
		}
	}
	

}
