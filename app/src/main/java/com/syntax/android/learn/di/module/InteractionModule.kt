package com.syntax.android.learn.di.module

import com.syntax.android.learn.firebase.authentication.FirebaseAuthenticationInterface
import com.syntax.android.learn.firebase.authentication.FirebaseAuthenticationManager
import com.syntax.android.learn.firebase.database.FirebaseDatabaseInterface
import com.syntax.android.learn.firebase.database.FirebaseDatabaseManager
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [FirebaseModule::class])
@Singleton
abstract class InteractionModule {

  @Binds
  abstract fun authentication(authentication: FirebaseAuthenticationManager): FirebaseAuthenticationInterface

  @Binds
  abstract fun database(database: FirebaseDatabaseManager): FirebaseDatabaseInterface
}