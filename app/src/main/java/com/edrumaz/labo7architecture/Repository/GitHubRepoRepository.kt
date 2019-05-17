package com.edrumaz.labo7architecture.Repository

import androidx.lifecycle.LiveData
import com.edrumaz.labo7architecture.Database.GithubDAO
import com.edrumaz.labo7architecture.Database.GithubRepo


class GitHubRepoRepository(private val repoDao: GithubDAO){

    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()
}