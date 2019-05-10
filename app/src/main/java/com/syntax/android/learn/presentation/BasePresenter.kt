package com.syntax.android.learn.presentation

interface BasePresenter<in T> {

  fun setView(view: T)
}