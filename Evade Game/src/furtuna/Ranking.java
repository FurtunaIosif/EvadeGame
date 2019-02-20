package furtuna;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Ranking extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				Ranking frame = new Ranking();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
//	}

	/**
	 * Create the frame.
	 */
	public Ranking() {
		setTitle("Ranking");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 526);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 62, 277, 385);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadRanking = new JButton("Load Ranking");
		btnLoadRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evade","root","1234");
						Statement stmt = con.createStatement();
						
						String query = "Select * from ranking order by score desc";
			            PreparedStatement pst = con.prepareStatement(query);
                        ResultSet rs = pst.executeQuery();

                        table.setModel(DbUtils.resultSetToTableModel(rs));
						con.close();
				    }catch(Exception e) {System.out.print(e);}
				

			
			}
		});
		btnLoadRanking.setBounds(95, 24, 115, 25);
		contentPane.add(btnLoadRanking);
	}
}
