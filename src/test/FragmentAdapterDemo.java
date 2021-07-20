package test;

import java.util.ArrayList;

import com.quanglinh.layout.custom.Fragment;
import com.quanglinh.layout.custom.FragmentStateAdapter;

public class FragmentAdapterDemo extends FragmentStateAdapter{
   ArrayList<Fragment1> arraylist;
   
	public FragmentAdapterDemo(ArrayList<Fragment1> arraylist) {
	this.arraylist = arraylist;
}

	@Override
	public Fragment createFragment(int position) {
		return arraylist.get(position);
	}

	@Override
	public int getItemCount() {
		return arraylist.size();
	}

}
