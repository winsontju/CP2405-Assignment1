import java.awt.Color;
import java.awt.Graphics;

//Inherits parent class Vehicle
public class Bus extends Vehicle{

	//Set bus speed, width, and height
	public Bus(int x, int y) {
		super(x, y);
		width=45;
		height=10;
		speed=7;
	}
	//Bus display
	public void paintMe(Graphics bus) {
		bus.setColor(Color.GREEN);
		bus.fillRect(x, y, width, height);
	}

}
