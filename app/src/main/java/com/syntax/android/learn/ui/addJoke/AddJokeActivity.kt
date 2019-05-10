package com.syntax.android.learn.ui.addJoke

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syntax.android.learn.R
import com.syntax.android.learn.addJokePresenter
import com.syntax.android.learn.common.onClick
import com.syntax.android.learn.common.onTextChanged
import com.syntax.android.learn.common.showGeneralError
import kotlinx.android.synthetic.main.activity_add_joke.*

class AddJokeActivity : AppCompatActivity(), AddJokeView {

  private val presenter by lazy { addJokePresenter() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_joke)
    presenter.setView(this)

    initUi()
  }

  private fun initUi() {
    jokeDescription.onTextChanged { presenter.onJokeTextChanged(it) }
    addJoke.onClick { presenter.addJokeTapped() }
  }

  override fun showJokeError() {
    jokeDescription.error = getString(R.string.joke_error)
  }

  override fun removeJokeError() {
    jokeDescription.error = null
  }

  override fun onJokeAdded() = finish()

  override fun showAddJokeError() = showGeneralError(this)
}