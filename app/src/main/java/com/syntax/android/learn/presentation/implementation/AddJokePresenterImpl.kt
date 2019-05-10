package com.syntax.android.learn.presentation.implementation

import com.syntax.android.learn.common.isValidJoke
import com.syntax.android.learn.firebase.authentication.FirebaseAuthenticationInterface
import com.syntax.android.learn.firebase.database.FirebaseDatabaseInterface
import com.syntax.android.learn.model.Joke
import com.syntax.android.learn.presentation.AddJokePresenter
import com.syntax.android.learn.ui.addJoke.AddJokeView
import javax.inject.Inject

class AddJokePresenterImpl @Inject constructor(
        private val authenticationInterface: FirebaseAuthenticationInterface,
        private val databaseInterface: FirebaseDatabaseInterface
) : AddJokePresenter {

  private lateinit var view: AddJokeView

  private var jokeText = ""

  override fun setView(view: AddJokeView) {
    this.view = view
  }

  override fun addJokeTapped() {
    if (isValidJoke(jokeText)) {
      val joke = Joke("", authenticationInterface.getUserName(), authenticationInterface.getUserId(), jokeText)

      databaseInterface.addNewJoke(joke) { onAddJokeResult(it) }
    }
  }

  override fun onJokeTextChanged(jokeText: String) {
    this.jokeText = jokeText

    if (!isValidJoke(jokeText)) {
      view.showJokeError()
    } else {
      view.removeJokeError()
    }
  }

  private fun onAddJokeResult(isSuccessful: Boolean) {
    if (isSuccessful) {
      view.onJokeAdded()
    } else {
      view.showAddJokeError()
    }
  }
}