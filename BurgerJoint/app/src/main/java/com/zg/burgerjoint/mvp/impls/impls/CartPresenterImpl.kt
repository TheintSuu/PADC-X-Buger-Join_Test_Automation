package com.zg.burgerjoint.mvp.impls.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.zg.burgerjoint.data.model.impls.BurgerModelImpl
import com.zg.burgerjoint.data.vos.BurgerVO
import com.zg.burgerjoint.mvp.impls.CartPresenter
import com.zg.burgerjoint.mvp.views.CartView

class CartPresenterImpl : CartPresenter, BaseAppPresenterImpl<CartView>() {


    private val mBurgerModel = BurgerModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
        mBurgerModel
            .getBurgersInCart()
            .observe(owner, Observer {
                mView.displayItemsInCart(it)
            })
    }

    override fun onTapRemoveFromCart(burger: BurgerVO, adapterPosition : Int) {
        mBurgerModel
            .removeItemFromCart(burger)
    }

    override fun onTapCheckout() {
        mView.displayThankYouMessage()
    }

    override fun onTapCancelThankYouMessage() {
        mView.hideThankYouMessage()
    }
}