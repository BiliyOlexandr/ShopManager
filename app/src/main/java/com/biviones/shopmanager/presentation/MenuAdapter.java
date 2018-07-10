package com.biviones.shopmanager.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.biviones.shopmanager.R;
import java.util.ArrayList;
import java.util.List;

class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

  private List<String> mMenuList;
  private MenuPresenter mMainPresenter;

  MenuAdapter(MenuPresenter mainPresenter) {
    mMenuList = new ArrayList<>();
    mMainPresenter = mainPresenter;
  }

  @Override
  public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    String currentMenuItem = mMenuList.get(position);

    holder.nameMenu.setText(currentMenuItem);

    holder.nameMenu.setOnClickListener(view -> {
      if (mMainPresenter != null) {
        mMainPresenter.onMenuItemClicked(currentMenuItem);
      }
    });
  }

  void addItem(String menuItem) {
    mMenuList.add(menuItem);
  }

  @Override public int getItemCount() {
    return mMenuList.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView nameMenu;

    ViewHolder(View itemView) {
      super(itemView);
      nameMenu = (TextView) itemView.findViewById(R.id.menu_name);
    }
  }
}
