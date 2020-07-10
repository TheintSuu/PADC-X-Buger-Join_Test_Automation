package com.zg.burgerjoint.mvp.impls.impls

import com.maex.shared.mvp.presenters.BasePresenter
import com.zg.burgerjoint.mvp.impls.AbstractBasePresenter
import com.zg.burgerjoint.mvp.views.BaseView

abstract class BaseAppPresenterImpl<V : BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>
