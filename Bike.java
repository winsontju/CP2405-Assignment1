import java.awt.Color;
import java.awt.Graphics;

//Inherits parent class Vehicle
public class Bike extends Vehicle{

	//Set Bike dimension and speed
	public Bike(int x, int y) {
		super(x, y);
		width=15;
		height=10;
		speed=20;
	}

	//Paint Bike
	public void paintMe(Graphics bike) {
		bike.setColor(Color.RED);
		bike.fillRect(x, y, width, height);
	}
	

}
