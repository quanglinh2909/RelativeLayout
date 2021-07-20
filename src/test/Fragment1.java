package test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.quanglinh.layout.custom.Bundle;
import com.quanglinh.layout.custom.Button;
import com.quanglinh.layout.custom.Fragment;

public class Fragment1 extends Fragment {
	Button button;
	FragmentDemo fragmentDemo = FragmentDemo.fragmentDemo;
    public static Fragment1 createFragment(String param1) {
    	Fragment1 fragment1 = new Fragment1();
    	Bundle bundle = new Bundle();
    	bundle.put("dulieu", param1);
    	fragment1.setArguments(bundle);
    	return fragment1;
    }
	
	@Override
	protected void createView() {
		//setBackground(Color.blue);
		button = new Button(this);
		button.layout_width(100);
		button.layout_height(60);
//		button.layout_marginTop(20);
//		button.layout_marginLeft(40);
		button.layout_centerHorizontal();
		button.layout_centerVertical();
		 String t = (String) getArguments("dulieu");

		button.setText(t);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fragmentDemo.setText(button.getText());
			}
		});
		
	}
	
}
