package com.biviones.shopmanager.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.biviones.shopmanager.R;

public class MenuActivity extends AppCompatActivity implements MenuViewCallbacks {

  private MenuAdapter mMenuAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.menu_recyclerView);
    MenuPresenter mMainPresenter = new MenuPresenter(this);
    mMenuAdapter = new MenuAdapter(mMainPresenter);

    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    mRecyclerView.setAdapter(mMenuAdapter);

    generateMenuItems();
  }

  private void generateMenuItems() {
    mMenuAdapter.addItem(getString(R.string.store));
    mMenuAdapter.addItem(getString(R.string.statistic));
  }

  @Override public void navigateToCategories() {
    //Intent intent = new Intent(this, )
  }
}
