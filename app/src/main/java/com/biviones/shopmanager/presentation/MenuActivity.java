package com.biviones.shopmanager.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.biviones.shopmanager.R;

public class MenuActivity extends AppCompatActivity implements MenuViewCallbacks {

  private ListAdapter mMenuAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.menu_recyclerView);
    MenuPresenter mMainPresenter = new MenuPresenter(this);
    mMenuAdapter = new ListAdapter(mMainPresenter);

    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    mRecyclerView.setAdapter(mMenuAdapter);

    generateMenuItems();
  }

  private void generateMenuItems() {
    mMenuAdapter.addItem(getString(R.string.store));
    mMenuAdapter.addItem(getString(R.string.statistic));
  }

  @Override public void navigateToCategories() {
    Intent intent = new Intent(this, CategoryActivity.class);
    startActivity(intent);
  }

  @Override public void navigateToStatistic() {
    Intent intent = new Intent(this,StatisticActivity.class);
    startActivity(intent);
  }
}
