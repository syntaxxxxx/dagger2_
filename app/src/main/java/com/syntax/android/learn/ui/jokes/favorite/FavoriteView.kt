package com.syntax.android.learn.ui.jokes.favorite

import com.syntax.android.learn.model.Joke

interface FavoriteView {

  fun showFavoriteJokes(jokes: List<Joke>)

  fun showNoDataDescription()

  fun hideNoDataDescription()

  fun clearItems()
}