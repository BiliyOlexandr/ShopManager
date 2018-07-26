package com.biviones.shopmanager.presentation;

public class CategoryPresenter {

  private CategoryViewCallbacks mCategoryViewCallbacks;

  CategoryPresenter(CategoryViewCallbacks categoryViewCallbacks) {
    mCategoryViewCallbacks = categoryViewCallbacks;
  }

  // TODO add comments
  void onCategoryItemClicked(String name) {
        mCategoryViewCallbacks.navigateToItems();
  }
}
