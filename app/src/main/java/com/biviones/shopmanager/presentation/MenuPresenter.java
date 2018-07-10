package com.biviones.shopmanager.presentation;

import com.biviones.shopmanager.StoreUtil;

public class MenuPresenter {

  private MenuViewCallbacks mViewCallbacks;

  MenuPresenter(MenuViewCallbacks menuViewCallbacks) {
    mViewCallbacks = menuViewCallbacks;
  }

  // TODO add comments
  void onMenuItemClicked(String name) {
    switch (name) {
      case StoreUtil.SHOP:
        mViewCallbacks.navigateToCategories();
        break;
      case StoreUtil.STATISTIC:
        // TODO mViewCallbacks.navigateToStatistic();
        break;
    }
  }
}
