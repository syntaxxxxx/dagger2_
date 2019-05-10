package com.syntax.android.learn.ui.jokes.all

import com.syntax.android.learn.model.Joke

interface AllJokesView {

  fun showNoDataDescription()

  fun hideNoDataDescription()

  fun addJoke(joke: Joke)

  fun setFavoriteJokesIds(favoriteJokesIds : List<String>)
}