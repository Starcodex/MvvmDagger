package com.starcodex.mvvmdagger.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.graphics.Movie
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.util.Log
import org.junit.Test
import org.mockito.Mockito.mock
import org.junit.Assert.*
import org.mockito.Mock
import com.android.dx.dex.code.StdCatchBuilder.build
import com.google.gson.Gson
import com.starcodex.mvvmdagger.BaseApp
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.app
import com.starcodex.mvvmdagger.component.AppComponentTest
import com.starcodex.mvvmdagger.component.DaggerAppComponentTest
import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.data.source.local.MovieItem
import com.starcodex.mvvmdagger.data.source.remote.ApiInterface
import com.starcodex.mvvmdagger.data.source.remote.response.MoviesResponse
import com.starcodex.mvvmdagger.di.component.DaggerAppComponent
import com.starcodex.mvvmdagger.di.module.AppModule
import com.starcodex.mvvmdagger.di.module.network.NetModule
import com.starcodex.mvvmdagger.espressoDaggerMockRule
import com.starcodex.mvvmdagger.module.AppModuleTest
import com.starcodex.mvvmdagger.module.NetModuleTest
import com.starcodex.mvvmdagger.ui.list.MovieRowViewModel
import com.starcodex.mvvmdagger.ui.list.MoviesAdapter
import com.starcodex.mvvmdagger.util.SchedulerProvider
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import org.junit.Before
import org.junit.Rule
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by Bonestack on 24/09/2018.
 */
class MainTestExample {
/*

    var TAG : String = javaClass.simpleName

   @get:Rule
    val testRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java, false, true)

    private lateinit var testAppComponent: AppComponentTest

    // Mock Response
    var moviesResponse : MoviesResponse = Gson().fromJson("{'results':[" +
            "{'id': 1, 'title': 'first title', 'overview': 'first overview' , 'poster_path': '' }," +
            "{'id': 2, 'title': 'second title', 'overview': 'second overview' , 'poster_path': '' }," +
            "{'id': 3, 'title': 'three', 'overview': 'three' , 'poster_path': '' }," +
            "{'id': 4, 'title': 'four', 'overview': 'four' , 'poster_path': '' }," +
            "{'id': 5, 'title': 'five', 'overview': 'five' , 'poster_path': '' }," +
            "]}", MoviesResponse::class.java)

    @Mock lateinit var context : Context
    @Mock lateinit var apiInterface : ApiInterface
    @Mock lateinit var realm : Realm
    @Mock lateinit var itemViewRow : MovieItem
    @Inject lateinit var movieRowViewModel : MovieRowViewModel
    @Inject lateinit var moviesAdapter : MoviesAdapter
    @InjectMocks lateinit var movieRepository : MovieRepository
    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())
    lateinit var mainViewModel : MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val app = InstrumentationRegistry.getTargetContext().applicationContext as BaseApp
        testAppComponent = DaggerAppComponentTest.builder()
                .appModuleTest(AppModuleTest(app))
                .netModuleTest(NetModuleTest(app.getString(R.string.base_url)))
                .build()

        app.appComponent = testAppComponent
        testAppComponent.inject(this)

        Log.d(TAG,"==== TestAppComponent injected")
        mainViewModel = MainViewModel(movieRepository,realm,moviesAdapter,schedulerProvider)

    }


    @Test
    fun getMoviesList() {

    Mockito.`when`(movieRepository.getMoviesFromApi(35, app.getString(R.string.api_key))).thenReturn(Observable.just(moviesResponse))

        val testObserver = TestObserver<MoviesResponse>()

        mainViewModel.getMoviesList(35,app.getString(R.string.api_key)).subscribe(testObserver)

        testObserver.assertNoErrors()
                .awaitDone(5, TimeUnit.SECONDS)
                //.assertResult(moviesResponse)
        testObserver.assertValue { response -> response.results[0].title.equals("another test") }
    }

*/

}