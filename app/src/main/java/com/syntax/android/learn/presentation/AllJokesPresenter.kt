package com.syntax.android.learn.presentation

import com.syntax.android.learn.model.Joke
import com.syntax.android.learn.ui.jokes.all.AllJokesView

interface AllJokesPresenter : BasePresenter<AllJokesView> {

  fun viewReady()

  fun getAllJokes()

  fun onFavoriteButtonTapped(joke: Joke)
}