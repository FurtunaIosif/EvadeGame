package furtuna;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	HUD hud;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login frame = new Login();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Login(HUD hud) {
		this.hud = hud;
	}
	public void Save() {
		setTitle("Score");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 461, 261);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input your name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setBounds(142, 13, 142, 54);
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(31, 95, 357, 42);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(37, 66, 82, 16);
		contentPane.add(lblUsername);
		
		JButton btnLogin = new JButton("Save");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evade","root","1234");
					Statement stmt = con.createStatement();
					
					//String sql = "Select * from ranking where username ='"+user.getText()+"'";
					//ResultSet rs = stmt.executeQuery(sql);
					//if(rs.next()) {
					System.out.println(hud.getScore());
					int update = stmt.executeUpdate("insert into ranking values('"+user.getText()+"','"+hud.getScore()+"')");
					JOptionPane.showMessageDialog(null, "Score saved succesfully!");
					//else {
					con.close();
			    }catch(Exception e) {System.out.print(e);}
			}

		});
		btnLogin.setBounds(170, 149, 97, 25);
		contentPane.add(btnLogin);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(170, 176, 97, 25);
		contentPane.add(btnQuit);

	}
}
