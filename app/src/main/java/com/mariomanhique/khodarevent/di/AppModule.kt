package com.mariomanhique.khodarevent.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
// import com.mariomanhique.khodarevent.data.repository.userDataRepository.UserPreferencesSerializer
// import com.mariomanhique.khodarevent.data.repository.userDataRepository.UserDataRepository
// import com.mariomanhique.khodarevent.data.repository.userDataRepository.UserDataRepositoryImpl
import com.mariomanhique.khodarevent.model.UserPreferences
import com.mariomanhique.khodarevent.network.KhodarEventsApi
// import com.mariomanhique.khodarevent.util.ApplicationScope
import com.mariomanhique.khodarevent.util.Constants
// import com.mariomanhique.khodarevent.util.Dispatcher
// import com.mariomanhique.khodarevent.util.NiaDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(
//        tokenInterceptor: TokenInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
//            .addInterceptor(tokenInterceptor)
            .build()
    }


    @Singleton
    @Provides
    fun provideKhoEventsAPI(okHttpClient: OkHttpClient): KhodarEventsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(KhodarEventsApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun providesUserPreferencesDataStore(
//        @ApplicationContext context: Context,
//        @Dispatcher(NiaDispatchers.IO) ioDispatcher: CoroutineDispatcher,
//        @ApplicationScope scope: CoroutineScope,
//        userPreferencesSerializer: UserPreferencesSerializer,
//    ): DataStore<UserPreferences> =
//        DataStoreFactory.create(
//            serializer = userPreferencesSerializer,
//            scope = CoroutineScope(scope.coroutineContext + ioDispatcher),
////            migrations = listOf(
////                IntToStringIdsMigration,
////            ),
//        ) {
//            context.dataStoreFile("user_preferences.json")
//        }

//    @Singleton
//    @Provides
//    fun provideUerDataRepository(
//        userDataRepository: UserDataRepositoryImpl
//    ): UserDataRepository {
//        return userDataRepository
//    }

}


