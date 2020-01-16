import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Traffic extends JFrame implements Runnable {
	private City c=new City();
	private JPanel contentPane;
	private boolean running=false;
	JButton btnRun = new JButton("Run\r\n");
	JButton btnStop = new JButton("Stop");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traffic frame = new Traffic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Traffic() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 629);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(c);
		JButton btnSpawn = new JButton("Spawn");
		btnSpawn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSpawn.setBounds(40, 377, 89, 23);
		contentPane.add(btnSpawn);
		Vehicle v=new Bike(0, 104);
		c.addVehicle(v);
		
		btnStop.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStop.setBounds(40, 307, 89, 23);
		contentPane.add(btnStop);
		
		
		
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRun.setBounds(40, 242, 89, 23);
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource().equals(btnRun)) {
					if(running==false) {
						running=true;
						Thread t=new Thread();
						t.start();
					}
					}
				if(event.getSource().equals(btnStop)) {
					running=false;
				}
			}
		});
		contentPane.add(btnRun);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(40, 377, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnOpen = new JButton("Open\r\n");
		btnOpen.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpen.setBounds(40, 307, 89, 23);
		contentPane.add(btnOpen);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBounds(40, 242, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnRate = new JButton("Rate");
		btnRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRate.setBounds(40, 177, 89, 23);
		contentPane.add(btnRate);
		
		JButton btnNewButton_2 = new JButton("Create");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(40, 177, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(56, 11, 99, 35);
		lblMenu.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblMenu.setForeground(Color.WHITE);
		contentPane.add(lblMenu);
		
		JButton btnNewButton = new JButton("City\r\n");
		
		btnNewButton.setBounds(10, 81, 84, 23);
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sim");
		
		btnNewButton_1.setBounds(104, 81, 75, 23);
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 20));
		contentPane.add(btnNewButton_1);
		
		JLabel lblMode = new JLabel("Mode:");
		lblMode.setForeground(Color.WHITE);
		lblMode.setFont(new Font("Cambria", Font.BOLD, 20));
		lblMode.setBounds(10, 457, 119, 23);
		contentPane.add(lblMode);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRate.setVisible(true);
				btnRun.setVisible(true);
				btnStop.setVisible(true);
				btnSpawn.setVisible(true);
				btnOpen.setVisible(false);
				btnSave.setVisible(false);
				btnEdit.setVisible(false);
				btnNewButton_2.setVisible(false);
				lblMode.setText("Mode: Sim");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRate.setVisible(false);
				btnRun.setVisible(false);
				btnStop.setVisible(false);
				btnSpawn.setVisible(false);
				btnOpen.setVisible(true);
				btnSave.setVisible(true);
				btnEdit.setVisible(true);
				btnNewButton_2.setVisible(true);
				lblMode.setText("Mode: City");
			}
		});
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Cambria", Font.BOLD, 20));
		lblStatus.setBounds(10, 503, 119, 23);
		contentPane.add(lblStatus);

	}
	
	public void run() {
		while(running==true) {
			c.step();
			c.repaint();
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
	
