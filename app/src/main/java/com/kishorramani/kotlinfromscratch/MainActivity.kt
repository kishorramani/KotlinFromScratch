package com.kishorramani.kotlinfromscratch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("-----------------------------------Coroutines---------------------------------------")
        //Coroutines - Example 1 by Philip

        //GlobalScope means coroutine live until app is alive
        GlobalScope.launch {
//            delay(5000)
            Log.e(TAG, "Coroutine says hello from: ${Thread.currentThread().name}")

            val networkCallResponse1 = doNetworkCall1()
            val networkCallResponse2 = doNetworkCall2()
            Log.e(TAG, networkCallResponse1)
            Log.e(TAG, networkCallResponse2)
            //Both are in the same coroutine so network time is added
        }

        Log.e(TAG, "Hello from thread: ${Thread.currentThread().name}")

        //---------------------------------------------------------------------------------------------------------------------------------------

        /*println("--------------------------------------------------------------------------")
        //Coroutines - Example 2 by Philip
        // Coroutine Context

//        GlobalScope.launch(newSingleThreadContext("My Thread")) {
        GlobalScope.launch(Dispatchers.IO) {
            Log.e(TAG, "Starting coroutine in thread: ${Thread.currentThread().name}")

            val networkCallResponse1 = doNetworkCall1()

            //With withContext, you can switch between any thread using coroutine
            withContext(Dispatchers.Main) {
                Log.e(TAG, "Setting text in thread: ${Thread.currentThread().name}")
                binding.txtDummy.text = networkCallResponse1
            }
        }*/

        //---------------------------------------------------------------------------------------------------------------------------------------

        /*println("--------------------------------------------------------------------------")
        //Coroutines - Example 3 by Philip
        //runBlocking

        Log.e(TAG, "Before runBlocking")
        runBlocking {
            Log.e(TAG, "runBlocking start")
            delay(1000)      // It's block our UI Update

            //Launch new coroutine
            launch(Dispatchers.IO) {
                Log.e(TAG, doNetworkCall1())
            }

            //Launch new coroutine      //It's won't affect main thread
            launch(Dispatchers.IO) {
                Log.e(TAG, doNetworkCall2())
            }
            Log.e(TAG, "runBlocking end")
        }
        Log.e(TAG, "After runBlocking")*/

        //---------------------------------------------------------------------------------------------------------------------------------------

        /*println("--------------------------------------------------------------------------")
        //Coroutines - Example 4 by Philip
        //Jobs, Waiting, cancellation

        Log.e(TAG, "start")

        val job = GlobalScope.launch(Dispatchers.Default) {
            //part 1
            repeat(5) {
                Log.d(TAG, "Coroutine is still running...")
                delay(1000)
            }

            //part 2        // Here, coroutine is so busy that don't cancel their job
//            for (n in 30..40) {
//                if (isActive) {     // Use active to check coroutine is running or not
//                    Log.e(TAG, "find fib of $n is: ${findFib(n)}")
//                }
//            }

            //part 3 - cancel by checking coroutine is active or not
//            for (n in 30..40) {
//                if (isActive) {     // Use active to check coroutine is running or not
//                    Log.e(TAG, "find fib of $n is: ${findFib(n)}")
//                }
//            }

            //part 4 - WithTimeout      //Comment runBlocking code
//            withTimeout(3000) {
//                for (n in 30..45) {
//                    if (isActive) {     // Use active to check coroutine is running or not
//                        Log.e(TAG, "find fib of $n is: ${findFib(n)}")
//                    }
//                }
//            }

            Log.e(TAG, "Ending long running calculation...")
        }

        runBlocking {
//            job.join()        // This join function will waiting for finish the job of coroutines
//            Log.e(TAG, "Main thread is continuing...")

            delay(2000L)
            job.cancel()
            Log.e(TAG, "Main thread is canceled")
        }

        Log.e(TAG, "end")*/

        //---------------------------------------------------------------------------------------------------------------------------------------

        /*println("--------------------------------------------------------------------------")
        //Coroutines - Example 5 by Philip
        //Async and await

        Log.e(TAG, "start")

        GlobalScope.launch(Dispatchers.IO) {
            //part 1    //It's take around 4 sec to complete it's task
//            val time = measureTimeMillis {
//                val response1 = doNetworkCall1()
//                val response2= doNetworkCall2()
//                Log.e(TAG, response1)
//                Log.e(TAG, response2)
//            }
//
//            Log.e(TAG, "Request time is: $time")

            //part 2    // Let's create 2 separated coroutine to work parallel
//            val time = measureTimeMillis {
//                var response1: String? = null
//                var response2: String? = null
//
//                val job1 = launch {
//                    Log.e(TAG, "Coroutine 1 launch")
//                    response1 = doNetworkCall1()
//                }
//
//                val job2 = launch {
//                    Log.e(TAG, "Coroutine 2 launch")
//                    response2 = doNetworkCall2()
//                }
//
//                job1.join()     // This join function will waiting for finish the job of coroutines
//                job2.join()
//
//                Log.e(TAG, "Response 1: $response1")
//                Log.e(TAG, "Response 2: $response2")
//
//                Log.e(TAG, "GlobalScope end")
//
//            }
//
//            Log.e(TAG, "Request time is: $time second")

            //part 3    // Above method is bad practice, You have to use async and await
//            val time = measureTimeMillis {
//                //Use Async instead of launch
//                //It's a very similar to launch, It also started new coroutine, It won't return a job instead it's return Deferred
//                // Deferred can be use to calculate the result of network call
//
//                val response1 = async {
//                    Log.e(TAG, "Coroutine 1 launch")
//                    doNetworkCall1()
//                }
//
//                val response2 = async {
//                    Log.e(TAG, "Coroutine 2 launch")
//                    doNetworkCall2()
//                }
//
//                Log.e(TAG, "Response 1: ${response1.await()}")  //It's block our current coroutine until response1 is available
//                Log.e(TAG, "Response 2: ${response2.await()}")  //It's block our current coroutine until response2 is available
//
//                Log.e(TAG, "GlobalScope end")
//                //If network call return anything then we have to use async
//                //We can also use our globalScope with async but here our GlobalScope return nothing
//            }
//
//            Log.e(TAG, "Request time is: $time second")
        }

        Log.e(TAG, "end")*/

        //---------------------------------------------------------------------------------------------------------------------------------------

        /*println("--------------------------------------------------------------------------")
        //Coroutines - Example 6 by Philip
        //LifeCycleScope and viewModelScope

        Log.e(TAG, "start")

        //Part 1
        binding.btnStartActivity.setOnClickListener {
//            lifecycleScope.launch {
            GlobalScope.launch {
                //This is always running
                while (true) {
                    delay(1000)
                    Log.e(TAG, "Still Running")
                }
            }

            GlobalScope.launch {
                delay(5000)
                Intent(this@MainActivity, SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        Log.e(TAG, "end")*/

        //---------------------------------------------------------------------------------------------------------------------------------------

        /*println("--------------------------------------------------------------------------")
        //Coroutines - Example 6 by Philip
        //Firebase FireStore

        Log.e(TAG, "start")



        Log.e(TAG, "end")*/

        //---------------------------------------------------------------------------------------------------------------------------------------

        /*println("--------------------------------------------------------------------------")
        //Coroutines - Example 6 by Philip
        //Coroutine with Retrofit
        Log.e(TAG, "start")

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)

//        api.getComments().enqueue(object : Callback<List<Comment>> {
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        for (comment in it) {
//                            Log.d(TAG, "onResponse: ${comment.name}")
//                        }
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                Log.e(TAG, "onFailure: ")
//            }
//        })

        //Part 1
//        GlobalScope.launch(Dispatchers.IO) {
//            val comments = api.getComments().await()
//
//            for (comment in comments) {
//                Log.d(TAG, "name: ${comment.name}")
//            }
//        }

        //Part 2    //Check response is success or not
//        GlobalScope.launch(Dispatchers.IO) {
//            val response = api.getComments().awaitResponse()
//
//            if (response.isSuccessful) {
//                for (comment in response.body()!!) {
//                    Log.d(TAG, "name: ${comment.name}")
//                }
//            }
//        }

        //Part 3    //Make getComments function to suspend function
//        GlobalScope.launch(Dispatchers.IO) {
//            val response = api.getComments1()
//
//            if (response.isSuccessful) {
//                for (comment in response.body()!!) {
//                    Log.d(TAG, "name: ${comment.name}")
//                }
//            }
//        }

        Log.e(TAG, "end")*/

        //---------------------------------------------------------------------------------------------------------------------------------------

        /*println("--------------------------------------------------------------------------")
        //Coroutines - Example 7 by Philip
        //Flow - Basically
        Log.e(TAG, "start")

//        val flow2 = flow<String> {
//            for (i in 1..10){
//                emit("Hello from flow $i")
//                delay(1000L)
//            }
//        }
//
//        GlobalScope.launch {
//            flow2.collect {
//                Log.e(TAG, it)
//                delay(2000)
//            }
//        }

//        //Producer
//        val myFlow = flow<Int> {
//            for (i in 1..10) {
//                emit(i)
//                delay(1000)
//            }
//        }
//
//        //consumer
//        GlobalScope.launch {
//            //This consumer run in the different coroutine
//            myFlow.buffer().filter {
//                it % 2 == 0
//            }.map {
//                it * it
//            }.collect {
//                Log.e(TAG, "$it")
//                delay(2000)
//            }
//        }

        Log.e(TAG, "end")*/

        //---------------------------------------------------------------------------------------------------------------------------------------
    }

}

private fun findFib(n: Int): Long {
    return when (n) {
        0 -> 0
        1 -> 1
        else -> findFib(n - 1) + findFib(n - 2)
    }
}

private suspend fun doNetworkCall1(): String {
    delay(2000)
    return "This is response1 from network"
}

private suspend fun doNetworkCall2(): String {
    delay(2000)
    return "This is response2 from network"
}