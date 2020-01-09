import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Traffic{
	JFrame f=new JFrame("Traffic");
	Road r=new Road();
	public Traffic() {
		f.setSize(800, 500);
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.add(r,BorderLayout.CENTER);
		Car c=new Car(10,20);
		r.addVehicle(c);
		Bus b=new Bus(10,170);
		r.addVehicle(b);
		Bike bike=new Bike(10,320);
		r.addVehicle(bike);
		f.repaint();
		
	}
	public static void main(String[]args) {
		Traffic t=new Traffic();
	}
}
