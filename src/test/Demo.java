package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.quanglinh.layout.custom.RecyclerView;
import com.quanglinh.layout.custom.RecyclerView.AnimationDelete;
import com.quanglinh.layout.custom.RecyclerView.OnclickRecylerView;

public class Demo extends JFrame {

	private JPanel contentPane;
	JButton item[] = new JButton[20];
	int[] mangViTriY = new int[20];
	List<String> list = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Demo frame = new Demo();
				
		
		
	}

	/**
	 * Create the frame.
	 */
	public Demo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setVisible(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 11, 401, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		RecyclerView recyclerView = new RecyclerView(panel);
		recyclerView.layout_width(300);
		recyclerView.layout_height(300);
		recyclerView.setBackground(Color.white);
		recyclerView.layout_centerHorizontal();
		
		for (int i = 0; i < 5; i++) {
			list.add(""+i);
		}
		
		AdapterView adapterView = new AdapterView(list);
		recyclerView.setAdapterLiner(adapterView,1);
		
		//recyclerView.setAnimationScale();

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(136, 347, 116, 23);
		panel.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 9; i < 20; i++) {
					list.add(""+i);
				}

				adapterView.notifyDataSetChanged();

			}
		});
		 
//		ImageView imageView = new ImageView(panel);
//		imageView.layout_width(100);
//		imageView.layout_height(100);
//		imageView.scaleTypeURL("https://itcafe.vn/wp-content/uploads/2021/01/anh-gai-xinh-1.jpg");
		
		
//		recyclerView.setAnimationDelete(new AnimationDelete() {
//			
//			@Override
//			public void animationDelete(int position) {
//				list.remove(position);
//				adapterView.notifyDataSetChanged();
//				
//			}
//		});
//		
		recyclerView.setonclicklistener(new OnclickRecylerView() {
			
			@Override
			public void onclicklistener(int po) {
				System.out.println(po);
				
			}
		});
//		
		
		
		
//		for (int i = 0; i < 20; i++) {
//			 item[i] = new JButton();
//			item[i].setBounds(0, 20*i, panel.getBounds().width, 20);
//			if(i%2 == 0) {
//				item[i].setBackground(Color.BLUE);
//			}
//			item[i].setText("button "+ i);
//			panel.add(item[i]);
//			mangViTriY[i] = 20*i;
//		}
//		
//		panel.addMouseWheelListener(new MouseWheelListener() {
//			
//			@Override
//			public void mouseWheelMoved(MouseWheelEvent e) {
//				
//				//System.out.println(e.getWheelRotation());
//				if(e.getWheelRotation() == 1 && item[item.length-1].getBounds().y > 201 -20) {
//					for (int i = 0; i < item.length; i++) {
//						Rectangle rectangle = item[i].getBounds();
//						
//						item[i].setBounds(0, rectangle.y - 20, rectangle.width, rectangle.height);
//					}
//				}
//				if(e.getWheelRotation() == -1 && item[0].getBounds().y < 0) {
//					for (int i = 0; i < item.length; i++) {
//						Rectangle rectangle = item[i].getBounds();
//						
//						item[i].setBounds(0, rectangle.y +20, rectangle.width, rectangle.height);
//					}
//				}
//			}
//		});
	}
	 public byte[] recoverImageFromUrl(String urlText) throws Exception {
	        URL url = new URL(urlText);
	        ByteArrayOutputStream output = new ByteArrayOutputStream();
	          
	        try (InputStream inputStream = url.openStream()) {
	            int n = 0;
	            byte [] buffer = new byte[ 1024 ];
	            while (-1 != (n = inputStream.read(buffer))) {
	                output.write(buffer, 0, n);
	            }
	        }
	      
	        return output.toByteArray();
	    }
}
