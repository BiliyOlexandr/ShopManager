package com.biviones.shopmanager.presentation;

public class MenuPresenter {

  private MenuViewCallbacks mViewCallbacks;

  MenuPresenter(MenuViewCallbacks menuViewCallbacks){
    mViewCallbacks = menuViewCallbacks;
  }
  void onMenuItemClicked() {
    mViewCallbacks.navigateToCategories();
  }
}
