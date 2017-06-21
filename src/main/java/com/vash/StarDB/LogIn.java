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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LogIn extends JFrame{
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private JLabel lError = null;
	private JTextField userField = null;
	private JPasswordField passwordField = null;
	private JTextField serverName = null;
	private JTextField databaseName = null;
	private boolean connected = false;

	public LogIn(){
		loadDriver();
		createGUI();
	}

	private void loadDriver(){
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void createGUI(){
		setTitle("Log In");
		setSize(480, 360);
		setMinimumSize(new Dimension(480, 360));
		setMaximumSize(new Dimension(480, 360));
		setResizable(false);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	private JPanel createHeader(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 30));
		panel.setBackground(Color.BLACK);
		return panel;
	}

	private JPanel createMain(){
		JPanel panel = new JPanel();
		GridLayout layoutPanel = new GridLayout(5, 1);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(layoutPanel);
		
		lError = new JLabel();
		JLabel lServer = new JLabel("Server Name: ");
		JLabel lDatabase = new JLabel("Database Name: ");
		JLabel lUser = new JLabel("User Name: ");
		JLabel lPassword = new JLabel("Password: ");
		
		userField = new JTextField(15);
		passwordField = new JPasswordField(15);
		serverName = new JTextField(15);
		databaseName = new JTextField(15);
		databaseName.setText("star");
		
		KeyListener enter = new KeyListener(){
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER){
					Login();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		userField.addKeyListener(enter);
		passwordField.addKeyListener(enter);
		serverName.addKeyListener(enter);
		databaseName.addKeyListener(enter);
		
		JPanel pServer = new JPanel();
		JPanel pDatabase = new JPanel();
		JPanel pUser = new JPanel();
		JPanel pPassword = new JPanel();
		
		lError.setForeground(Color.RED);
		lError.setFont(new Font(App.FONT, Font.ITALIC, 12));
		
		lServer.setForeground(Color.WHITE);
		pServer.setBackground(Color.DARK_GRAY);
		lDatabase.setForeground(Color.WHITE);
		pDatabase.setBackground(Color.DARK_GRAY);
		lUser.setForeground(Color.WHITE);
		pUser.setBackground(Color.DARK_GRAY);
		lPassword.setForeground(Color.WHITE);
		pPassword.setBackground(Color.DARK_GRAY);
		
		pServer.add(lServer);
		pServer.add(serverName);
		pDatabase.add(lDatabase);
		pDatabase.add(databaseName);
		pUser.add(lUser);
		pUser.add(userField);
		pPassword.add(lPassword);
		pPassword.add(passwordField);
		
		panel.add(lError);
		panel.add(pServer);
		panel.add(pDatabase);
		panel.add(pUser);
		panel.add(pPassword);
		return panel;
	}

	private JPanel createTail(){
		JPanel panel = new JPanel();
		JButton bLogin = new JButton("Log In");
		ActionListener login = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		};
		JButton bExit = new JButton("Exit");
		ActionListener exit = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		};
		bLogin.addActionListener(login);
		bExit.addActionListener(exit);
		bLogin.setPreferredSize(new Dimension(100, 25));
		bExit.setPreferredSize(new Dimension(100, 25));
		panel.add(bLogin);
		panel.add(bExit);
		panel.setBackground(Color.BLACK);
		return panel;
	}
	
	private void Login(){
		if (serverName.getText() == null || serverName.getText().isEmpty()){
			serverName.requestFocus();
			lError.setText("Enter server name");
		}
		else if (databaseName.getText() == null || databaseName.getText().isEmpty()){
			databaseName.requestFocus();
			lError.setText("Enter database name");
		}
		else if (userField.getText() == null || userField.getText().isEmpty()){
			userField.requestFocus();
			lError.setText("Enter user name");
		}
		else if (passwordField.getText() == null || passwordField.getText().isEmpty()){
			passwordField.requestFocus();
			lError.setText("Enter password");
		}
		else {
			Connect(serverName.getText(), databaseName.getText(), userField.getText(), passwordField.getText());
		}
	}
	
	private void Connect(String server, String databaseName, String user, String password){
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://" + server + ":3306/" + databaseName + "?" +
							"user=" + user + "&password=" + password);
			// Do something with the Connection
			connected = testConnection();
			if (connected){
				MainMenu menu = new MainMenu(conn);
				dispose();
			}
		} catch (SQLException ex) {
			// handle any errors
			lError.setText("SQLException: " + ex.getMessage());
		}
	}

	private boolean testConnection(){
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT 'CONNECTED'");
			System.out.println("");
			while(rs.next()){
				System.out.print(" | ");
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
					System.out.print(rs.getString(i) + " | ");
				}
				System.out.println("");
			}
			System.out.println("");
			return true;
		}
		catch (SQLException e){
			// handle any errors
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return false;
	}

	public boolean isConnected(){
		return connected;
	}

	public Connection getConnection(){
		return conn;
	}
}
