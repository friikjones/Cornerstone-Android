package ca.ciccc.daniel.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var simple_dice_label_1: TextView
    lateinit var simple_dice_label_2: TextView
    lateinit var simple_dice_image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        simple_dice_label_1 = findViewById(R.id.simple_dice_label_1)
        simple_dice_label_1.text = "Roll!"
        simple_dice_label_2 = findViewById(R.id.simple_dice_label_2)
        simple_dice_label_2.text = "Roll!"
        simple_dice_image = findViewById(R.id.dice_image)

    }

    fun simpleRoll(view: View) {
        val randomInt1 = Random().nextInt(6)+1
        val randomInt2 = Random().nextInt(6)+1
        //text
        simple_dice_label_1.text = randomInt1.toString()
        simple_dice_label_2.text = randomInt2.toString()
        //image
        val img = when (randomInt1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
    }


}
