package com.example.breukentrainer2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import java.util.concurrent.Executors

class TipOfTheDayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_of_the_day)

        // Declaring and initializing the ImageView
        val imageView = findViewById<ImageView>(R.id.imageTipView)

        // Declaring executor to parse the URL
        val executor = Executors.newSingleThreadExecutor()

        // Once the executor parses the URL
        // and receives the image, handler will load it
        // in the ImageView
        val handler = Handler(Looper.getMainLooper())

        // Initializing the image
        var image: Bitmap? = null

        // Only for Background process (can take time depending on the Internet speed)
        executor.execute {

            val imageURL = "https://www.slimleren.nl/files/300_300/Breuk(3).png"
            //val imageURL = "https://img.icons8.com/windows/512/corgi.png"
            //val imageURL = "https://ehb-my.sharepoint.com/:i:/g/personal/elias_joostens_student_ehb_be/ETNpMGrtT-5BrgpyZEFJr9QBdHWmenPmNqLpsDDz4-drlg?e=de0kBc"
            //val imageURL = "https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png"

            //https://ibb.co/wNFD67Q
            //https://ibb.co/myZrQfR
            //https://ibb.co/y6JDGg4

            // Tries to get the image and post it in the ImageView
            // with the help of Handler
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)

                // Only for making changes in UI
                handler.post {
                    imageView.setImageBitmap(image)
                }
            }

            // If the URL doesnot point to
            // image or any other kind of failure
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}