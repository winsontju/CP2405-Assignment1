import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class City extends JPanel {
	final int laneHeight=300;
	final int bound1=50;
	final int bound2=650;
//	boolean r1,r2,r3,r4,r5,r6,r7=false;
	ArrayList<Vehicle> v=new ArrayList<Vehicle>();
	ArrayList<TrafficLight> s=new ArrayList<TrafficLight>();
//	int bry1=60,brx2=310,bry3=150,brx4=395,bry5=445,bry6=445,bry7=445;
	/**
	 * Create the panel.
	 */
	public City() {
		setBackground(Color.GREEN);
		setForeground(Color.GREEN);
		setBounds(187, 0, 855, 590);
		setLayout(null);
		setVisible(true);
	}
	public void addVehicle(Vehicle vehicle) {
		v.add(vehicle);
	}
	public void addSignal(TrafficLight signal) {
		s.add(signal);

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
//		signal(372, 60,g,false,false,true,false);
//		signal(310, 117,g,false,false,true,true);
//		signal(372, 150,g,false,true,true,false);
//		signal(372, 360,g,false,true,true,false);
//		signal(395, 117,g,false,false,true,true);
//		signal(170, 445,g,true,false,true,false);
//		signal(372, 445,g,true,false,true,false);
//		signal(670, 445,g,true,false,true,false);	
		
//		s=new Signal(true,false,false,372, 60,false);
//		s.setSignal(false, true, false);

//		signal(310, 117,g,true,false,false,true);
//		signal(372, 150,g,true,false,false,false);
//		signal(372, 360,g,true,false,false,false);
//		signal(395, 117,g,true,false,false,true);
//		signal(170, 445,g,true,false,false,false);
//		signal(372, 445,g,true,false,false,false);
//		signal(670, 445,g,true,false,false,false);	
		
		
		
		for(int a=0;a<v.size();a++) {
			v.get(a).paintMe(g);
		}
		for(int a=0;a<s.size();a++) {
			s.get(a).paintMe(g);
		}
		
	}
	
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
					
					if(count==0) {
						s.get(count).setSignal(false, false, true);
						
					}
					else {
						s.get(count-1).setSignal(true, false, false);
						s.get(count).setSignal(false, false, true);
					}
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
	public void setSignal(int i,boolean r,boolean y,boolean g) {
		s.get(i).setSignal(r, y, g);
	}
	
	
	
	}

	


