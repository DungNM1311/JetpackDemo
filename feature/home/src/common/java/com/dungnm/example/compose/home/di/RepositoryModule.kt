package com.dungnm.example.compose.home.di

import com.dungnm.example.compose.home.network.GithubService
import com.dungnm.example.compose.home.repo.GithubRepo
import com.dungnm.example.compose.home.repo.IGithubRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideGithubRepo(
        githubService: GithubService
    ): IGithubRepo {
        return GithubRepo(githubService)
    }
}