package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.quanglinh.layout.custom.ItemRecyclerView;
import com.quanglinh.layout.custom.RecyclerView;

public class AdapterView extends RecyclerView.Adapter<ItemRecyclerView> {

	List<String> list;
	int VIEW_TUYPE_1 = 0;
	int VIEW_TUYPE_2 = 1;

	public AdapterView(List<String> list) {
		this.list = list;
	}

	

	
	@Override
	public int getItemViewType(int position) {
		if(position % 2 == 0) {
			return VIEW_TUYPE_1;
		}else {

			return VIEW_TUYPE_2;
		}
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	@Override
	public void onBindViewHolder(ItemRecyclerView holder, int position) {
		if(position%2 == 0) {
			ITem iTem = (ITem) holder;
			iTem.textView.setText(list.get(position));
			iTem.imageButton.scaleTypeURL("https://itcafe.vn/wp-content/uploads/2021/01/anh-gai-xinh-1.jpg");
		}else {
			ITem iTem = (ITem) holder;
			iTem.textView.setText(list.get(position));
			iTem.imageButton.scaleTypeURL("https://itcafe.vn/wp-content/uploads/2021/01/anh-gai-xinh-1.jpg");
		
		}
		
	}




	@Override
	public ItemRecyclerView onCreateViewHolder(int viewType) {
		if(viewType == VIEW_TUYPE_1) {
			return new ITem(77);

		}else {
			return new ITem(77);

		}
	}

}
