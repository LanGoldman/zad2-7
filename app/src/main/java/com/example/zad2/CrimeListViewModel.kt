package com.example.zad2

import androidx.lifecycle.ViewModel

class CrimeListViewModel: ViewModel()
{
    fun addCrime(crime: Crime) {
        TODO("Not yet implemented")
    }

    val crimes = mutableListOf<Crime>()
    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
    init {
        for (i in 0.. 100) {
            val crime = Crime()
            crime.title = "Crime #$i"
            crime.date
            crime.bool = i % 2 == 0
        }
    }
}