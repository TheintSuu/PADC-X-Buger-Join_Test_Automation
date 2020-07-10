package com.zg.burgerjoint.instrumentationtests


import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.zg.burgerjoint.data.vos.BurgerVO
import com.zg.burgerjoint.persistence.BurgerJointDatabase
import com.zg.burgerjoint.persistence.daos.BurgerDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class Database {
    private  lateinit var  burgerDao : BurgerDao
    private lateinit var  db : BurgerJointDatabase


    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, BurgerJointDatabase::class.java
        ).build()
        burgerDao = db.getBurgerDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest(){
        val burgerOne = BurgerVO()
        burgerOne.burgerName = "Theint Pizza"
        burgerOne.burgerDescription = "the hot chicken sandwich or simply hot chicken althought less featured in other areas of North AMerica , the sandwich is also found in samll diner the sandwich was a working class dish already common and "
        burgerOne.burgerImageUrl = "thins"
        burgerDao.insert(burgerOne)
        assert(burgerDao.findBurgerById(burgerOne.burgerId).value?.burgerId == burgerOne.burgerId)
    }

}