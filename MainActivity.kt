package com.test.newutils

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.metalab.asyncawait.async
import co.metalab.asyncawait.await
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val scope = CoroutineScope(Job() + Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        println("Start")

// Start a coroutine
        GlobalScope.launch {
//            delay(1000)
//            println("Hello")

            withContext(Dispatchers.IO) {              // Dispatchers.IO (main-safety block)
                /* perform network IO here */

                delay(2000)
                println("Hello 2")

                // Dispatchers.IO (main-safety block)
            }
            println("Stop 2")

        }



//        Thread.sleep(2000) // wait for 2 seconds
        println("Stop")

//        println("Start")


    }




    suspend fun get(url: String) =                 // Dispatchers.Main
        withContext(Dispatchers.IO) {              // Dispatchers.IO (main-safety block)
            /* perform network IO here */          // Dispatchers.IO (main-safety block)
        }

    fun exampleMethod() {
        // Starts a new coroutine within the scope
        scope.launch {
            // New coroutine that can call suspend functions
//            fetchDocs()
        }
    }

    fun cleanUp() {
        // Cancel the scope to cancel ongoing coroutines work
        scope.cancel()
    }// Dispatchers.Main

}