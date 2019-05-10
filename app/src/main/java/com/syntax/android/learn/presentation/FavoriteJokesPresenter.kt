package com.syntax.android.learn.presentation

import com.syntax.android.learn.model.Joke
import com.syntax.android.learn.ui.jokes.favorite.FavoriteView

interface FavoriteJokesPresenter : BasePresenter<FavoriteView> {

  fun getFavoriteJokes()

  fun onFavoriteButtonTapped(joke: Joke)
}