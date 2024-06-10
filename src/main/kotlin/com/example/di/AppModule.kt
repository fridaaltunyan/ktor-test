package com.example.di

import com.example.data.repositories.FootballerRepository
import com.example.data.repositories.FootballerRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<FootballerRepository> {
        FootballerRepositoryImpl()
    }
}