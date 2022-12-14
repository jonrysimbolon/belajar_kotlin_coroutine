import kotlinx.coroutines.*


/*
fun main() = runBlocking {
    */
/*launch {
        delay(1000L)
        println("Coroutines 1!")
    }*//*


    // launch diatas, sama dengan yg ini

    launch(Dispatchers.Default) { // Secara default
        delay(1000L)
        println("Coroutines Default")
    }

    launch(Dispatchers.IO) { // IO = untuk membongkar pemblokiran operasi I/O
        delay(2000L)
        println("Coroutines IO")
    }

    print("Hello, ")
    delay(4000L)
}*/


/*fun main() = runBlocking<Unit> {
    launch(Dispatchers.Unconfined) {

        /* Unconfined = pemindahan thread yg satu ke yang lain ...
        * ... terjadi ketika thread pertama selesai di tangguhkan/suspend ...
        * ... dan case nya di thread pertama itu memanggil function di thread kedua ...
        * ... function di thread pertama dilanjutkan ke thread kedua
         */

        println("Starting in ${Thread.currentThread().name}")
        delay(1000L)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()

}*/


// === Builder - builder yang dapat digunakan untuk menentukan thread yang dibutuhkan ===

// 1. Single Thread Context
// Setiap saat coroutine akan dijalankan pada thread yang anda tentukan
/*
@DelicateCoroutinesApi
fun main() = runBlocking<Unit>{
    val dispatcher = newSingleThreadContext("myThread")
    launch(dispatcher) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000L)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()
}
*/

// 2.  Thread Pool
// Sebuah dispatcher yang memiliki kumpulan thread.
// Ia akan memulai dan melanjutkan coroutine disalah satu thread yang tersedia pada kumpulan tersebut.
// Runtime akan menentukan thread mana yang tersedia dan juga menentukan bagaimanan proses distribusi bebannya.
@DelicateCoroutinesApi
fun main() = runBlocking<Unit> {
    val dispatcher = newFixedThreadPoolContext(3, "myPool") // 3 thread pool
    launch(dispatcher){
        println("Starting in ${Thread.currentThread().name}")
        delay(1000L)
        println("resuming in ${Thread.currentThread().name}")
    }.start()
}