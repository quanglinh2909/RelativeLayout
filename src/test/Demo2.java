package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;

public class Demo2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	 public static CardLayout card = new CardLayout(40, 30);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo2 frame = new Demo2();
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
	public Demo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(card);
		
		JButton btnNewButton_3 = new JButton("New button 1");
		contentPane.add(btnNewButton_3, "name_1802073289208400");
		btnNewButton_3.setPreferredSize(new Dimension(10,10));
		
		JButton btnNewButton_2 = new JButton("New button 2");
		contentPane.add(btnNewButton_2, "name_1802070146921000");
		
		JButton btnNewButton_1 = new JButton("New button 3");
		contentPane.add(btnNewButton_1, "name_1802062142924500");
		
		JButton btnNewButton = new JButton("New button 4");
		contentPane.add(btnNewButton, "name_1802037783274700");
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);
		btnNewButton_3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		card.next(contentPane);
		
	}

}
