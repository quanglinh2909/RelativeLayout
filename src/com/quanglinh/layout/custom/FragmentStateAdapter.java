package com.quanglinh.layout.custom;

public abstract class FragmentStateAdapter {
	public abstract Fragment createFragment(int position);
	public abstract int getItemCount();
}
