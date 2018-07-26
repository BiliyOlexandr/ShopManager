package com.biviones.shopmanager.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.biviones.shopmanager.R;

public class CategoryActivity extends AppCompatActivity implements CategoryViewCallbacks {

  private ListAdapter mCategoryAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_category);

    RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.category_recyclerView);
    CategoryPresenter mCategoryPresenter = new CategoryPresenter(this);
    mCategoryAdapter = new ListAdapter(mCategoryPresenter);

    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    mRecyclerView.setAdapter(mCategoryAdapter);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setHomeButtonEnabled(true);
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.categories);
    }

    FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.category_fab);
    floatingActionButton.setOnClickListener(view -> {
      AlertDialog.Builder alertDialog = new AlertDialog.Builder(CategoryActivity.this);
      alertDialog.setTitle(R.string.categories);
      alertDialog.setMessage(R.string.enter_category_name);

      final EditText inputText = new EditText(this);
      alertDialog.setView(inputText);

      alertDialog.setPositiveButton("YES",
          (dialog, which) -> {
            String categoryName = inputText.getText().toString();
            if (!categoryName.isEmpty()) {
              Toast.makeText(getApplicationContext(),
                  getString(R.string.confirm_category) + categoryName, Toast.LENGTH_SHORT).show();
              mCategoryAdapter.addItem(categoryName);
            } else {
              Toast.makeText(getApplicationContext(),
                  R.string.empty_category, Toast.LENGTH_SHORT).show();
            }
          });

      alertDialog.setNegativeButton("NO",
          (dialog, which) -> dialog.cancel());
      alertDialog.show();
    });
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        finish();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override public void navigateToItems() {
    Intent intent = new Intent(this, ItemActivity.class);
    startActivity(intent);
  }
}
