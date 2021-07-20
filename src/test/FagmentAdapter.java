package test;

import com.quanglinh.layout.custom.Fragment;
import com.quanglinh.layout.custom.FragmentStateAdapter;

public class FagmentAdapter extends FragmentStateAdapter {

	@Override
	public Fragment createFragment(int position) {
		switch (position) {
		case 0:
			return new Fragment1();
		case 1:
			return new Fragment2();
        case 2:
        	return new Fragment3();
        case 3:
        	return new Fragmment4();
        case 4:
        	return new Fragmnet5();
		}
		return null;
	}

	@Override
	public int getItemCount() {
		return 5;
	}

}
