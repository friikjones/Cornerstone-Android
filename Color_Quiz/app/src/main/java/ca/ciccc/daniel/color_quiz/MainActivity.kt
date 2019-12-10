package ca.ciccc.daniel.color_quiz

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val colors = Color.values()
    private var score = 0
    private lateinit var scoreLabel: TextView
    private lateinit var colorButtons: Array<Button>
    private lateinit var colorLabel: TextView
    private var correctColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreLabel = findViewById(R.id.score_label)
        colorButtons = arrayOf(findViewById(R.id.left_button), findViewById(R.id.right_button))
        colorLabel = findViewById(R.id.color_label)

        initQuestion()
    }

    private fun initQuestion() {
        var auxColor = colors[0]
        var color = colors[0]
        for (button in colorButtons) {
            color = colors[Random.nextInt(colors.size)]
            if(color == auxColor){
               color = colors[Random.nextInt(colors.size)]
            }
            button.setBackgroundColor(color.rgb)
            colorLabel.text = color.toString()
            correctColor = color.rgb
            auxColor = color
        }
        if(Random.nextBoolean()){
            var aux = (colorButtons[0].background as ColorDrawable).color
            colorButtons[0].setBackgroundColor((colorButtons[1].background as ColorDrawable).color)
            colorButtons[1].setBackgroundColor(aux)
        }
    }

    fun checkAnswer(view: View) {
        val answeredColor = (view.background as ColorDrawable).color
        if (answeredColor == correctColor){
            scoreLabel.text = "Score: ${(++score)}"
            Toast.makeText(applicationContext,"Point scored!",Toast.LENGTH_SHORT).show()
        }else{
            scoreLabel.text = "Score: ${(--score)}"
            Toast.makeText(applicationContext,"Point lost...",Toast.LENGTH_SHORT).show()
        }
        initQuestion()

    }

}
