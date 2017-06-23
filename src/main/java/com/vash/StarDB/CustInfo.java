package com.vash.StarDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustInfo extends JFrame{
	private final int width = 480;
	private final int height = 360;
	private JTextField textField = null;
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private JTextField name, street, city, state, zip;
	JLabel error = new JLabel();
	
	public CustInfo(Connection conn){
		this.conn = conn;
		createGUI();
	}
	
	private void createGUI(){
		setTitle("Customer Information");
		setSize(width, height);
		setBackground(Color.BLACK);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPanels();
		setVisible(true);
	}
	
	private void createPanels(){
		JPanel pHeader = createHeader();
		
		JPanel pMain = createMain();
		
		JPanel pTail = createTail();

		Container pane = getContentPane();
		pane.add(pHeader, BorderLayout.NORTH);
		pane.add(pMain, BorderLayout.CENTER);
		pane.add(pTail, BorderLayout.SOUTH);
	}
	
	private JPanel createMain(){
		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(6, 1);
		panel.setLayout(gridLayout);
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel lName = new JLabel("Name: ");
		JPanel pName = new JPanel();
		name = new JTextField(15);
		lName.setForeground(Color.WHITE);
		pName.setBackground(Color.DARK_GRAY);
		pName.add(lName);
		pName.add(name);
		
		JLabel lStreet = new JLabel("Street: ");
		JPanel pStreet = new JPanel();
		street = new JTextField(15);
		lStreet.setForeground(Color.WHITE);
		pStreet.setBackground(Color.DARK_GRAY);
		pStreet.add(lStreet);
		pStreet.add(street);

		JLabel lCity = new JLabel("City: ");
		JPanel pCity = new JPanel();
		city = new JTextField(15);
		lCity.setForeground(Color.WHITE);
		pCity.setBackground(Color.DARK_GRAY);
		pCity.add(lCity);
		pCity.add(city);
		
		JLabel lState = new JLabel("State: ");
		JPanel pState = new JPanel();
		state = new JTextField(15);
		lState.setForeground(Color.WHITE);
		pState.setBackground(Color.DARK_GRAY);
		pState.add(lState);
		pState.add(state);

		JLabel lZip = new JLabel("ZIP: ");
		JPanel pZip = new JPanel();
		zip = new JTextField(15);
		lZip.setForeground(Color.WHITE);
		pZip.setBackground(Color.DARK_GRAY);
		pZip.add(lZip);
		pZip.add(zip);
		
		error.setForeground(Color.RED);
		error.setFont(new Font(App.FONT, Font.ITALIC, 12));
		
		KeyListener enter = new KeyListener(){
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER){
					Submit();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		name.addKeyListener(enter);
		street.addKeyListener(enter);
		city.addKeyListener(enter);
		state.addKeyListener(enter);
		zip.addKeyListener(enter);
		
		panel.add(pName);
		panel.add(pStreet);
		panel.add(pCity);
		panel.add(pState);
		panel.add(pZip);
		panel.add(error);
		
		return panel;
	}
	
	private JPanel createHeader(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension((int) (width*.1), (int) (height*.1)));
		
		JLabel title = new JLabel("Customer Information");
		title.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		title.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
		title.setFont(new Font(App.FONT, Font.BOLD, 18));
		title.setForeground(Color.WHITE);
		
		panel.add(title);
		
		return panel;
	}
	
	private JPanel createTail(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension((int) (width*.1), (int) (height*.1)));
		
		JButton bSubmit = new JButton("Submit");
		ActionListener aSubmit = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Submit();
			}
		};
		bSubmit.addActionListener(aSubmit);
		bSubmit.setPreferredSize(new Dimension(100, 25));
		
		JButton bCancel = new JButton("Cancel");
		ActionListener aCancel = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustMenu custMenu= new CustMenu(conn);
				dispose();
			}
		};
		bCancel.addActionListener(aCancel);
		bCancel.setPreferredSize(new Dimension(100, 25));
		
		panel.add(bSubmit);
		panel.add(bCancel);
		return panel;
	}
	
	private void Submit(){
		if (name.getText() == null || name.getText().isEmpty()){
			name.requestFocus();
			error.setText("*Please enter name");
		}
		else if (street.getText() == null || street.getText().isEmpty()){
			street.requestFocus();
			error.setText("*Please enter street address");
		}
		else if (city.getText() == null || city.getText().isEmpty()){
			city.requestFocus();
			error.setText("*Please enter City");
		}
		else if (state.getText() == null || state.getText().isEmpty()){
			state.requestFocus();
			error.setText("*Please enter State");
		}
		else if (zip.getText() == null || zip.getText().isEmpty()){
			zip.requestFocus();
			error.setText("*Please enter area code");
		}
		else {
			Insert(name.getText(), street.getText(), city.getText(), state.getText(), zip.getText());
			CustMenu custMenu= new CustMenu(conn);
			dispose();
		}
	}
	
	private void Insert(String name, String street, String city, String state, String zip){
		try {
			stmt = conn.createStatement();
			String query = "INSERT INTO dim_cust(Name, Address) VALUES ('" + 
					name + "', '" + street + "');";
			System.out.println(query);
			int q = stmt.executeUpdate(query);
		}
		catch (SQLException e){
			// handle any errors
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}

	private void Exit(){
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}