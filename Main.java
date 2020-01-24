import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Main extends JFrame implements Runnable,ActionListener {
	//INITIALIZE VARIABLE AND LIST
	private Vehicle vehicle[]=new Vehicle[30]; 
	private CreateCity ccity[]=new CreateCity[5];
	int city=0;

	//INITIALIZE CITY SIGNAL
	private City c=new City();
	private TrafficLight sig;
	private JPanel contentPane;
	private boolean running=false;
	boolean open =false;
	int index=0;
	int i=0;

	//CREATE BUTTON TO START AND STOP
	private JLabel label=new JLabel("");
	JButton btnStart = new JButton("Start\r\n");
	JButton btnStop = new JButton("Stop");
	private int total=0;
	int count=0;

	//MAIN FUNCTION
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//CREATE TRAFFIC
	public Main() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 629);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(c);
		addSignal(-10,0);

		btnStop.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStop.setBounds(40, 217, 89, 23);
		btnStop.addActionListener(this);
		contentPane.add(btnStop);

		btnStart.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStart.setBounds(40, 154, 89, 23);
		btnStart.addActionListener(this);
			
		contentPane.add(btnStart);


		//Create Button for Open
		JButton btnOpen = new JButton("Open\r\n");
		btnOpen.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpen.setBounds(40, 271, 89, 23);
		btnOpen.setVisible(false);
		contentPane.add(btnOpen);

		//Create Button for edit
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBounds(40, 217, 89, 23);
		btnEdit.setVisible(false);
		contentPane.add(btnEdit);

		//Button to create new city
		JButton btnCreateCity = new JButton("Create");
		btnCreateCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreateCity.setBounds(40, 154, 89, 23);
		contentPane.add(btnCreateCity);

		//Create Settings Label
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setBounds(30, 11, 150, 45);
		lblSettings.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblSettings.setForeground(Color.WHITE);
		contentPane.add(lblSettings);

		//City Button Mode
		JButton btnCityMode = new JButton("City\r\n");
		btnCityMode.setBounds(10, 81, 84, 23);
		btnCityMode.setFont(new Font("Century Gothic", Font.BOLD, 20));
		contentPane.add(btnCityMode);

		//Simulation Button Mode
		JButton btnSimMode = new JButton("Sim");
		btnSimMode.setBounds(104, 81, 75, 23);
		btnSimMode.setFont(new Font("Cambria", Font.BOLD, 20));
		contentPane.add(btnSimMode);

		//Label Mode
		JLabel lblMode = new JLabel("Mode: Simulation");
		lblMode.setForeground(Color.WHITE);
		lblMode.setFont(new Font("Cambria", Font.BOLD, 20));
		lblMode.setBounds(10, 388, 200, 23);
		contentPane.add(lblMode);

		//Label Status
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Cambria", Font.BOLD, 20));
		lblStatus.setBounds(10, 432, 119, 23);
		contentPane.add(lblStatus);

		//Default Status
		JLabel lblCityDefault = new JLabel("City: Default");
		lblCityDefault.setForeground(Color.WHITE);
		lblCityDefault.setFont(new Font("Cambria", Font.BOLD, 16));
		lblCityDefault.setBounds(31, 466, 108, 23);
		contentPane.add(lblCityDefault);

		//Vehicles label for counting number of vehicles
		JLabel lblVehicles = new JLabel("Vehicles:");
		lblVehicles.setForeground(Color.WHITE);
		lblVehicles.setFont(new Font("Cambria", Font.BOLD, 16));
		lblVehicles.setBounds(31, 500, 99, 23);
		contentPane.add(lblVehicles);
		//Input the total value of vehicles
		label.setText(String.valueOf(total));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Cambria", Font.BOLD, 16));
		label.setBounds(104, 500, 67, 23);
		contentPane.add(label);
		btnSimMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Boolean to set variables
				btnStart.setVisible(true);
				btnStop.setVisible(true);
				btnOpen.setVisible(false);
				btnEdit.setVisible(false);
				btnCreateCity.setVisible(false);
				lblMode.setText("Mode: Sim");
				lblCityDefault.setVisible(true);
				lblVehicles.setVisible(true);
				label.setVisible(true);
				c.setVisible(true);
				
			}
		});

		//Button city action when clicked
		btnCityMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Boolean to set variables
				btnStart.setVisible(false);
				btnStop.setVisible(false);
				btnOpen.setVisible(true);
				btnEdit.setVisible(true);
				btnCreateCity.setVisible(true);
				lblStatus.setVisible(false);
				lblMode.setText("Mode: City");
				lblCityDefault.setVisible(false);
				lblVehicles.setVisible(false);
				label.setVisible(false);
			}
		});
		//Set Create City Variable
		btnCreateCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Set the maximum number to create city
				if(city<5) {
					//Boolean to set variables in this function
					c.setVisible(true);
					btnOpen.setVisible(false);
					btnEdit.setVisible(false);
					btnCreateCity.setVisible(false);
					JOptionPane j=new JOptionPane();
					String name=j.showInputDialog("Enter new city name ");
					int roads=Integer.parseInt(j.showInputDialog("Enter number of Roads "));
					btnStart.setVisible(false);
					btnStop.setVisible(false);
					btnOpen.setVisible(true);
					btnEdit.setVisible(true);
					btnCreateCity.setVisible(true);
					lblStatus.setVisible(false);
					lblMode.setText("Mode: City");
					lblCityDefault.setVisible(false);
					lblVehicles.setVisible(false);
					label.setVisible(false);

					CreateCity create=new CreateCity(name,roads);
					ccity[city]=create;
					j.showMessageDialog(contentPane, "You have successfully created "+name+". You can open and run it.");
					c.setVisible(false);
					contentPane.add(ccity[city]);
					for(int i=0;i<city;i++) {
						ccity[i].setVisible(false);
					}
					addSignal(ccity[city].roads,city);
					ccity[city].setVisible(true);
					city++;
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "You can't create cities more than 5");
				}
			}
		});
		
		//Button edit action
		btnEdit.addActionListener(new ActionListener() {
			//Boolean for variables setup when action edit performed
			public void actionPerformed(ActionEvent e) {
				btnOpen.setVisible(false);
				btnEdit.setVisible(false);
				btnStart.setVisible(false);
				btnStop.setVisible(false);
				btnCreateCity.setVisible(false);
				JOptionPane j=new JOptionPane();

				//Condition if city button is pressed
				if(city!=0) {
				String name=j.showInputDialog("Enter city name"); //Dialog
				int i=0;
				while(i!=city) {
					if(ccity[i].name.equalsIgnoreCase(name)) {
						int roads=Integer.parseInt(j.showInputDialog("Enter number of Roads ")); //Dialog
						ccity[i].roads=roads;
						//Message to show successful city create
						JOptionPane.showMessageDialog(contentPane, ccity[i].name+" Edited successfully!"); //Dialog

						//Looping method
						for(int m=0;m<city;m++) {
							ccity[m].setVisible(false);
						}
						ccity[i].s.clear();
						addSignal(roads,i);	
						ccity[i].setVisible(true);
					}
					i++;
				}
				
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No Cities Found!");
					
				}
				btnOpen.setVisible(true);
				btnEdit.setVisible(true);
				btnCreateCity.setVisible(true);
			}
		});

		//Open Button onClick
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(city>0) {
					String name=JOptionPane.showInputDialog("Enter city name");
					//Set loop
					for(int i=0;i<city;i++) {
						 //Condition to ignore equal case
						if(ccity[i].name.equalsIgnoreCase(name)) {
							open=true;
							index=ccity[i].roads;
							i=i;
							//Boolean to set variables when action performed
							ccity[i].setVisible(true);
							btnStart.setVisible(true);
							btnStop.setVisible(true);
							btnOpen.setVisible(false);
							btnEdit.setVisible(false);
							btnCreateCity.setVisible(false);
							lblMode.setText("Mode: Simulation");
							lblCityDefault.setText("City:"+ccity[i].name);
							lblCityDefault.setVisible(true);
							lblVehicles.setVisible(true);
							label.setVisible(true);
							total=0;
							
											}
					}
					
				}
				//Open a strange city name
				else {
					JOptionPane.showMessageDialog(contentPane, "No Cities Found!");
				}
			}
		});
		
	}
	public void check() {
		for(int j=0;j<total;j++) {

			if(vehicle[j].check==true) {
				for(int k=j;k<total;k++) {
					vehicle[k]=vehicle[k+1];
				}
				total--;
			}
		}
	}

	//Trafficlight Signal
	public void addSignal(int index,int i) {
		if(index>0 & index<=2) {
		}
		else if(index>2 & index<=4) {
			ccity[i].addSignal(new TrafficLight(true,false,false,310, 117,true));
			ccity[i].addSignal(new TrafficLight(true,false,false,372, 60,false));
			ccity[i].addSignal(new TrafficLight(true,false,false,372, 150,false));
			ccity[i].addSignal(new TrafficLight(true,false,false,395, 117,true));
		}
		else if(index>4 & index<=6) {
			ccity[i].addSignal(new TrafficLight(true,false,false,310, 117,true));
			ccity[i].addSignal(new TrafficLight(true,false,false,372, 60,false));
			ccity[i].addSignal(new TrafficLight(true,false,false,372, 150,false));
			ccity[i].addSignal(new TrafficLight(true,false,false,395, 117,true));
			ccity[i].addSignal(new TrafficLight(true,false,false,372, 445,false));
		}
		else if(index>6 &  index<=8) {
			sig =new TrafficLight(true,false,false,310, 117,true);
			ccity[i].addSignal(sig);
			sig =new TrafficLight(true,false,false,372, 60,false);
			ccity[i].addSignal(sig);
			
			sig =new TrafficLight(true,false,false,372, 150,false);
			ccity[i].addSignal(sig);
			sig =new TrafficLight(true,false,false,395, 117,true);
			ccity[i].addSignal(sig);

			sig =new TrafficLight(true,false,false,170, 445,false);
			ccity[i].addSignal(sig);
			sig =new TrafficLight(true,false,false,372, 445,false);
			ccity[i].addSignal(sig);
			sig =new TrafficLight(true,false,false,672, 445,false);
			ccity[i].addSignal(sig);
		}
	else {
		c.addSignal(new TrafficLight(true,false,false,310, 117,true));
		c.addSignal(new TrafficLight(true,false,false,372, 60,false));

		c.addSignal(new TrafficLight(true,false,false,372, 150,false));
		c.addSignal(new TrafficLight(true,false,false,395, 117,true));

		c.addSignal(new TrafficLight(true,false,false,170, 445,false));
		c.addSignal(new TrafficLight(true,false,false,372, 445,false));
		c.addSignal(new TrafficLight(true,false,false,672, 445,false));}
	}

	//Spawn vehicles
	public void addVehicle(int index,int i) {
		//Condition for indexing the bus
		if(index>0 & index<=2) {
			vehicle[total]=new Bus(804, 135);
			vehicle[total].turnThree();
			ccity[i].addVehicle(vehicle[total]);
			total++;
		}
		else if(index>2 & index<=4) {
			int a=(int) (Math.random() * 3); 
			if(a==0) {
				vehicle[total]=new Bus(804, 135);
				vehicle[total].turnThree();
				ccity[i].addVehicle(vehicle[total]);
				total++;}

			//Condition for spawning the car
			else if(a==1) {
				vehicle[total]=new Car(354, 0);
				vehicle[total].turnOne();
				ccity[i].addVehicle(vehicle[total]);
				total++;}
		}

		else if(index>4 & index<=6) {
			int a=(int) (Math.random() * 5); 
			if(a==0) {
				//Condition for turning bus
				vehicle[total]=new Bus(804, 135);
				vehicle[total].turnThree();
				ccity[i].addVehicle(vehicle[total]);
				total++;}
		
			else if(a==1) {
				//turning car
				vehicle[total]=new Car(354, 0);
				vehicle[total].turnOne();
				ccity[i].addVehicle(vehicle[total]);
				total++;}

			//turning bicycle
			else if(a==2) {
			vehicle[total]=new Bike(385, 580);
			vehicle[total].turnTwo();
			ccity[i].addVehicle(vehicle[total]);
			total++;}
			else if(a==3) {
			
			vehicle[total]=new Car(0, 404);

			ccity[i].addVehicle(vehicle[total]);
			total++;}
		}

		//Indexing turning and count total vehicles
		else if(index>6 &  index<=8) {
			int a=(int) (Math.random() * 5); 
			if(a==0) {
				vehicle[total]=new Bus(804, 135);
				vehicle[total].turnThree();
				ccity[i].addVehicle(vehicle[total]);
				total++;}
		
			else if(a==1) {
				vehicle[total]=new Car(354, 0);
				vehicle[total].turnOne();
				ccity[i].addVehicle(vehicle[total]);
				total++;}
		
			else if(a==2) {
			vehicle[total]=new Bike(385, 580);
			vehicle[total].turnTwo();
			ccity[i].addVehicle(vehicle[total]);
			total++;}
			else if(a==3) {
			
			vehicle[total]=new Car(0, 404);

			ccity[i].addVehicle(vehicle[total]);
			total++;}
			else if(a==4) {
				vehicle[total]=new Bike(185, 580);
				vehicle[total].turnTwo();
				c.addVehicle(vehicle[total]);
				total++;}
			else if(a==5) {
				
				vehicle[total]=new Bike(685, 580);
				vehicle[total].turnTwo();
				c.addVehicle(vehicle[total]);
				total++;}
		}
		

		else {
			int a=(int) (Math.random() * 5); 
			if(a==0) {
		
			vehicle[total]=new Bike(185, 580);
			vehicle[total].turnTwo();
			c.addVehicle(vehicle[total]);
			total++;}
		
			else if(a==1) {
			vehicle[total]=new Car(385, 580);
			vehicle[total].turnTwo();
			c.addVehicle(vehicle[total]);
			total++;}
		
			else if(a==2) {
			vehicle[total]=new Bike(685, 580);
			vehicle[total].turnTwo();
			c.addVehicle(vehicle[total]);
			total++;}
			else if(a==3) {
			
			vehicle[total]=new Car(354, 0);
			vehicle[total].turnOne();
			c.addVehicle(vehicle[total]);
			total++;}
			
			else if(a==4) {
				
				vehicle[total]=new Bus(810, 135);
				vehicle[total].turnThree =true;
				c.addVehicle(vehicle[total]);
				
				total++;}
			
			else {
			
			vehicle[total]=new Bus(0, 404);
			c.addVehicle(vehicle[total]);
			total++;	}	
			
		}
	}

	//run function
	public void run() {
		while(running==true & open==false) {
			c.step();
			c.repaint();
			check();
			label.setText(String.valueOf(total));
			if(count==10 & total!=29) {
				addVehicle(-10,0);
				count=0;
				
			}

			count++;
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		while(running==true & open==true) {
			
			ccity[i].step();
			ccity[i].repaint();
			check();
			label.setText(String.valueOf(total));
			if(count==10 & total!=29) {
				addVehicle(index,i);
				count=0;
				
			}

			count++;
			
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				e.printStackTrace();
			}}
		}

	//Action performed to run start and stop button
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(btnStart)) {
			
			if(running==false) {
				running=true;
				Thread t=new Thread(this);
				t.start();
				
			}
			}
		if(event.getSource().equals(btnStop)) {
			running=false;
		}
	}
	
	
}

