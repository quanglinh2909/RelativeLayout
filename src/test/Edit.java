package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.quanglinh.layout.custom.EditText;
import com.quanglinh.layout.custom.EditText.OnDataChange;

public class Edit extends JFrame {

	private JPanel contentPane;
	private JTextField txtOk;
	private JPanel panel_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit frame = new Edit();
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
	public Edit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		EditText editText  = new EditText(panel);
		editText.layout_width(300);
		editText.layout_height(30);
		editText.setTextHint("Email");
		editText.textColor(Color.red);
		editText.setICon(40,"src/linh.png",30,30);
		editText.setBackGroundIcon(Color.RED);
		editText.setBackGroundRelative(Color.yellow);
		editText.onDataChange(new OnDataChange() {
			
			@Override
			public void onDataChange(String s) {
				System.out.println(s);
				
			}
		});
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(editText.getText());
			}
		});
		btnNewButton.setBounds(138, 302, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		
	}
}
