package com.syntax.android.learn.presentation.implementation

import com.syntax.android.learn.firebase.authentication.FirebaseAuthenticationInterface
import com.syntax.android.learn.firebase.database.FirebaseDatabaseInterface
import com.syntax.android.learn.model.Joke
import com.syntax.android.learn.presentation.FavoriteJokesPresenter
import com.syntax.android.learn.ui.jokes.favorite.FavoriteView
import javax.inject.Inject

class FavoriteJokesPresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : FavoriteJokesPresenter {

  private lateinit var view: FavoriteView

  override fun setView(view: FavoriteView) {
    this.view = view
  }

  override fun getFavoriteJokes() {
    val id = authenticationInterface.getUserId()

    databaseInterface.getFavoriteJokes(id) {
      it.forEach { it.isFavorite = true }

      displayItems(it)
    }
  }

  private fun displayItems(items: List<Joke>) {
    if (items.isEmpty()) {
      view.clearItems()
      view.showNoDataDescription()
    } else {
      view.hideNoDataDescription()
      view.showFavoriteJokes(items)
    }
  }

  override fun onFavoriteButtonTapped(joke: Joke) {
    databaseInterface.changeJokeFavoriteStatus(joke, authenticationInterface.getUserId())
  }
}