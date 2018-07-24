package com.biviones.shopmanager.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.biviones.shopmanager.R;

public class CategoryActivity extends AppCompatActivity implements CategoryViewCallbacks {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_category);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setHomeButtonEnabled(true);
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.categories);
    }

    FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
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
                  "Category name confirm: " + categoryName, Toast.LENGTH_SHORT).show();
              // TODO mCategoryAdapter.addItem(categoryName);
            } else {
              Toast.makeText(getApplicationContext(),
                  "Category name is empty", Toast.LENGTH_SHORT).show();
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

  @Override public void navigateToItem() {

  }
}
