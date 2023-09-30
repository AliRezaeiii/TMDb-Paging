package com.sample.android.tmdb.repository

import com.sample.android.tmdb.data.network.PersonService
import com.sample.android.tmdb.data.response.asDomainModel
import com.sample.android.tmdb.domain.repository.PersonRepository
import com.sample.android.tmdb.domain.model.Person
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PersonRepositoryImpl @Inject constructor(
    private val personApi: PersonService
) : PersonRepository {

    override fun getPerson(personId: Any): Single<Person> =
        personApi.getPerson(personId).map { it.asDomainModel() }
}