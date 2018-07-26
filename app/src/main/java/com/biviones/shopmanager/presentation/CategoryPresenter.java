package com.biviones.shopmanager.presentation;

import com.biviones.shopmanager.StoreUtil;

public class CategoryPresenter {

  private CategoryViewCallbacks mCategoryViewCallbacks;

  CategoryPresenter(CategoryViewCallbacks categoryViewCallbacks) {
    mCategoryViewCallbacks = categoryViewCallbacks;
  }

  // TODO add comments
  void onCategoryItemClicked(String name) {
    switch (name) {
      case StoreUtil.SHOP:
        mCategoryViewCallbacks.navigateToItem();
        break;
    }
  }
}
