package com.syntax.android.learn.presentation

import com.syntax.android.learn.ui.addJoke.AddJokeView

interface AddJokePresenter : BasePresenter<AddJokeView> {

  fun addJokeTapped()

  fun onJokeTextChanged(jokeText: String)
}