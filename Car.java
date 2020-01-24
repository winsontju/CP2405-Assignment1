import java.awt.Color;
import java.awt.Graphics;

//Inherits parent class Vehicle
public class Car extends Vehicle{

	//Set car speed, width, and height
	public Car(int x, int y) {
		super(x, y);
		width=30;
		height=10;
		speed=15;
	}
	//Set display fill
	public void paintMe(Graphics car) {
		car.setColor(Color.BLUE);
		car.fillRect(x, y, width, height);
	}
	//Car Rate Getter
	public void setRate(int r) {
		this.speed=r;
	}
}
