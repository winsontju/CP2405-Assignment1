import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class CreateCity extends JPanel {
	//Create Panel 
	int roads=0;
	String name="";
	int streetHeight =300;
	ArrayList<Vehicle> v=new ArrayList<Vehicle>();
	ArrayList<TrafficLight> s=new ArrayList<TrafficLight>();
	public CreateCity(String n,int roads) {
		setBackground(Color.GREEN);
		setForeground(Color.GREEN);
		setBounds(187, 0, 855, 590);
		setLayout(null);
		setVisible(true);
		this.name=n;
		this.roads=roads;
	}
	public void addVehicle(Vehicle vehicle) {
		v.add(vehicle);
	}
	public void addSignal(TrafficLight signal) {
		s.add(signal);

	}

	//Paint road with condition
	public void paint(Graphics road) {

		super.paintComponent(road);

		//If road is set to 2
		if(roads<=2) {

			road.setColor(Color.GRAY);
			road.fillRect(0, 100, 870, 50);
			
			road.setColor(Color.WHITE);
			for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
				for(int b=0;b<getWidth();b+=40) {
					road.fillRect(b, 120, 30, 5);
				}
			}
		}

		//If road is set to 4
		else if(roads<=4) {
			road.setColor(Color.GRAY);
			road.fillRect(0, 100, 870, 50);

			road.setColor(Color.WHITE);
			for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
				for(int b=0;b<getWidth();b+=40) {
					road.fillRect(b, 120, 30, 5);
				}
			}
		road.setColor(Color.GRAY);
		road.fillRect(350, 0, 50, 600);
		
		road.setColor(Color.WHITE);
		for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
			for(int b=0;b<getHeight();b+=40) {
				road.fillRect(375, b, 5, 30);
			}
		}}

		//If road is set to 6
		else if(roads<=6) {
			road.setColor(Color.GRAY);
			road.fillRect(0, 100, 870, 50);
			
			road.setColor(Color.WHITE);
			//Loop to call the fillRect
			for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
				for(int b=0;b<getWidth();b+=40) {
					road.fillRect(b, 120, 30, 5);
				}
			}
		road.setColor(Color.GRAY);
		road.fillRect(350, 0, 50, 600);
		road.setColor(Color.WHITE);
		for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
			for(int b=0;b<getHeight();b+=40) {
				road.fillRect(375, b, 5, 30);
			}
		}
		road.setColor(Color.GRAY);
		road.fillRect(0, 400, 870, 50);
		
		road.setColor(Color.WHITE);
		for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
			for(int b=0;b<getWidth();b+=40) {
				road.fillRect(b, 420, 30, 5);
			}
		}
		}
		
		else if(roads<=10) {
			road.setColor(Color.GRAY);
			road.fillRect(0, 100, 870, 50);
			
			road.setColor(Color.WHITE);
			for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
				for(int b=0;b<getWidth();b+=40) {
					road.fillRect(b, 120, 30, 5);
				}
			}
		road.setColor(Color.GRAY);
		road.fillRect(350, 0, 50, 600);
		
		road.setColor(Color.WHITE);
		for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
			for(int b=0;b<getHeight();b+=40) {
				road.fillRect(375, b, 5, 30);
			}
		}
		road.setColor(Color.GRAY);
		road.fillRect(0, 400, 870, 50);
		
		road.setColor(Color.WHITE);
		for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
			for(int b=0;b<getWidth();b+=40) {
				road.fillRect(b, 420, 30, 5);
			}
		}
		road.setColor(Color.GRAY);
		road.fillRect(150, 400, 50, 600);
		
		road.setColor(Color.WHITE);
		for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
			for(int b=430;b<getHeight();b+=40) {
				road.fillRect(173, b, 5, 30);
			}
		}
		road.setColor(Color.GRAY);
		road.fillRect(650, 400, 50, 600);
		
		road.setColor(Color.WHITE);
		for(int a = streetHeight; a< streetHeight *4; a=a+ streetHeight) {
			for(int b=430;b<getHeight();b+=40) {
				road.fillRect(673, b, 5, 30);
			}
		}}

		for(int a=0;a<s.size();a++) {
			s.get(a).paintMe(road);
		}

		for(int a=0;a<v.size();a++) {
			v.get(a).paintMe(road);
		}
	}

	//function to set vehicle speed and turning condition
	public void step() {
		for(int i=0;i<v.size();i++) {
			Vehicle vehicle=v.get(i);
			
			
			if(vehicle.turnOne ==true & !vehicle.road.equals("in") ) {
				vehicle.setY(vehicle.getY()+vehicle.getSpeed() );
				vehicle.setPosition(vehicle.getY()+vehicle.getSpeed());
				vehicle.setCondition(vehicle.getX(), vehicle.getY());
			}
			else if(vehicle.turnTwo ==true & !vehicle.road.equals("in")){
				vehicle.setY(vehicle.getY()-vehicle.getSpeed());
				vehicle.setPosition(vehicle.getY()-vehicle.getSpeed());
				vehicle.setCondition(vehicle.getX(), vehicle.getY());
			}
			else if(vehicle.turnThree ==true & !vehicle.road.equals("in")){
				vehicle.setX(vehicle.getX()-vehicle.getSpeed());
				vehicle.setPosition(vehicle.getX()-vehicle.getSpeed());
				vehicle.setCondition(vehicle.getX(), vehicle.getY());
			}
			else if(vehicle.turnThree ==false & vehicle.turnThree ==false & vehicle.turnThree ==false & !vehicle.road.equals("in")) {
				vehicle.setX(vehicle.getX()+vehicle.getSpeed());
				vehicle.setPosition(vehicle.getX()+vehicle.getSpeed());
				vehicle.setCondition(vehicle.getX(), vehicle.getY());
			}
			else {
				if(vehicle.current==true) {
					int count=0;
					if(vehicle.signal.equals("s1")) {count=0;}
					else if(vehicle.signal.equals("s2")) {count=1;}
					else if(vehicle.signal.equals("s3")) {count=2;}
					else if(vehicle.signal.equals("s4")) {count=3;}
					else if(vehicle.signal.equals("s5")) {count=4;}
					else if(vehicle.signal.equals("s6")) {count=5;}
					else if(vehicle.signal.equals("s7")) {count=6;}
					else if(vehicle.signal.equals("s8")) {count=7;}
					if(s.size()!=0) {
					if(count==0) {
						s.get(count).setSignal(false, false, true);
					}
					else {
						if(s.size()==5 & count==5) {s.get(count-2).setSignal(true, false, false);
						s.get(count-1).setSignal(false, false, true);}
						else {
							s.get(count-1).setSignal(true, false, false);
							s.get(count).setSignal(false, false, true);
						}
						
					}}
					if(vehicle.turnOne ==true) {
						vehicle.setY(vehicle.getY()+vehicle.getSpeed() );
						vehicle.setCondition(vehicle.getX(), vehicle.getY());
					}
					else if(vehicle.turnTwo ==true){
						vehicle.setY(vehicle.getY()-vehicle.getSpeed());
						
						vehicle.setCondition(vehicle.getX(), vehicle.getY());
						}
					else if(vehicle.turnThree ==true ){
						vehicle.setX(vehicle.getX()-vehicle.getSpeed());
						vehicle.setCondition(vehicle.getX(), vehicle.getY());
					}
					else if(vehicle.turnThree ==false & vehicle.turnThree ==false & vehicle.turnThree ==false ) {
						vehicle.setX(vehicle.getX()+vehicle.getSpeed());
						vehicle.setCondition(vehicle.getX(), vehicle.getY());
					}
				}
				else {
					vehicle.setCondition(vehicle.getX(), vehicle.getY());
				}
			}	
		}
		}

		//setSignal getter function
	public void setSignal(int i,boolean r,boolean y,boolean g) {
		s.get(i).setSignal(r, y, g);
	}
}
