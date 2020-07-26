package com.oliva.verde.android.androidtestingsample

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.assertj.core.api.Assertions.assertThat
import org.junit.After

import org.junit.Before
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@Config(sdk = [27])
@RunWith(RobolectricTestRunner::class)
class RepositoryLocalDataSourceTest {
    lateinit var repositoryLocalDataSource: RepositoryLocalDataSource

    @Before
    fun setUp() {
        // Contextの取得
        val context = InstrumentationRegistry.getInstrumentation().context
        val db = Room
            .databaseBuilder(context, AppDataBase::class.java, "DB")
            .allowMainThreadQueries() // クエリをメインスレッドで実行できるように設定
            .build()
        repositoryLocalDataSource = RepositoryLocalDataSource(db)
    }

    @Test
    fun insertAll_finishesSuccessfully() {
        val owner = "laOlivaEsVerde"

        repositoryLocalDataSource.insertAll(
            Repository(1, "hello", "hello", owner),
            Repository(2, "world", "world", owner)
        )

        val list = repositoryLocalDataSource.findByOwner("laOlivaEsVerde")
        assertThat(list).hasSize(2)
    }

    @Test
    fun findByOwner_expectEmpty() {
        val list = repositoryLocalDataSource.findByOwner("laOlivaEsVerde")
        assertThat(list).isEmpty()
    }
}

@Config(sdk = [27])
@RunWith(Enclosed::class)
class EnclosedTest {
    abstract class DBTest {
        lateinit var repositoryLocalDataSource: RepositoryLocalDataSource

        @Before
        fun setUpParent() {
            val context = InstrumentationRegistry.getInstrumentation().context
            val db = Room
                .databaseBuilder(context, AppDataBase::class.java, "DB")
                .allowMainThreadQueries()
                .build()
            repositoryLocalDataSource = RepositoryLocalDataSource(db)
        }

        @After
        fun tearDownParent() { }
    }

    @Config(sdk = [27])
    @RunWith(RobolectricTestRunner::class)
    class BlankRecord : DBTest() {
        @Test
        fun insertAll_successfully_persist_record() {
            repositoryLocalDataSource.insertAll(
                Repository(0, "hello", "hello", "laOlivaEsVerde")
            )
            val repository = repositoryLocalDataSource.findByOwner("laOlivaEsVerde")
            assertThat(repository).hasSize(1)
        }
    }

    @Config(sdk = [27])
    @RunWith(RobolectricTestRunner::class)
    class RecordPrepared : DBTest() {
        @Before
        fun setUp() {
            repositoryLocalDataSource.insertAll(
                Repository(1, "hello", "hello", "laOlivaEsVerde"),
                Repository(2, "world", "world", "laOlivaEsVerde"),
                Repository(3, "yay!", "yay!", "hoge")
            )
        }

        @Test
        fun findByOwner_givenLaOlivaEsVerde_returnsSizeCount2() {
            val repository = repositoryLocalDataSource.findByOwner("laOlivaEsVerde")
            assertThat(repository).hasSize(2)

        }

        @Test
        fun findByOwner_givenHoge_returnsSizeCount1() {
            val hogeRepository = repositoryLocalDataSource.findByOwner("hoge")
            assertThat(hogeRepository).hasSize(1)
        }
    }
}