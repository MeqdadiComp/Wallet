package com.saja.mytask.di

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.saja.mytask.R
import com.saja.mytask.ui.dialogs.BaseProgressDialog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

@InstallIn(ActivityComponent::class)
@Module
object ProgressViewModule {
    @ActivityScoped
    @Provides
    fun provideProgressView(): BaseProgressDialog {
        return BaseProgressDialog()
    }
}