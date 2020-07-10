package com.zg.burgerjoint.mvp.impls.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.zg.burgerjoint.data.model.impls.BurgerModelImpl
import com.zg.burgerjoint.mvp.impls.BurgerDetailsPresenter
import com.zg.burgerjoint.mvp.views.BurgerDetailsView

class BurgerDetailsPresenterImpl : BurgerDetailsPresenter,
    BaseAppPresenterImpl<BurgerDetailsView>() {

    private val mBurgerModel = BurgerModelImpl

    override fun onBurgerDetailsUiReady(lifecycleOwner: LifecycleOwner, burgerDetailsId: Int) {
        mBurgerModel.findBurgerById(burgerDetailsId)
            .observe(lifecycleOwner, Observer {
                mView.displayBurgerDetails(it)
            })
    }

    override fun onUIReady(owner: LifecycleOwner) {

    }
}