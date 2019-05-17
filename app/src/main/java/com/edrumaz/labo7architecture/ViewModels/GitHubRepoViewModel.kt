package com.edrumaz.labo7architecture.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.edrumaz.labo7architecture.Database.GithubRepo
import com.edrumaz.labo7architecture.Database.RoomDB
import com.edrumaz.labo7architecture.Repository.GitHubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRepoViewModel(app: Application): AndroidViewModel(app){

    private val repository : GitHubRepoRepository

    init{
        val repoDao = RoomDB.getInstance(app).repoDao()
        repository = GitHubRepoRepository(repoDao)
    }

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()

}