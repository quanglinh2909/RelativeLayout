package test;

import java.awt.Color;

import com.quanglinh.layout.custom.Button;
import com.quanglinh.layout.custom.CardView;
import com.quanglinh.layout.custom.ImageButton;
import com.quanglinh.layout.custom.ItemRecyclerView;
import com.quanglinh.layout.custom.TextView;

public class ITem extends ItemRecyclerView {
	 public ITem(int height) {
		super(height);
		setBackground(Color.BLUE);
		imageButton = new ImageButton(this);
		imageButton.layout_width(50);
		imageButton.layout_height(50);
		imageButton.radius(100, 2, Color.BLACK);
		imageButton.layout_centerVertical();
		imageButton.layout_marginLeft(20);
		
		textView = new TextView(this);
		textView.layout_width(200);
		textView.layout_height(20);
		textView.setText("ok");
		textView.layout_toRightOf(imageButton);
		textView.layout_centerVertical();
		//textView.layout_marginLeft(20);
		textView.textColor(Color.WHITE);
		textView.textSize(18);
		
//		CardView cardView = new CardView(Color.black, 2, 200, 0);
//		this.setBorder(cardView);
	}

	ImageButton imageButton;
	 TextView textView;
	
	
}
