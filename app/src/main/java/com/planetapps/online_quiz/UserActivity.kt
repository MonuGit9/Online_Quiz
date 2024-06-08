package com.planetapps.online_quiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.planetapps.online_quiz.databinding.ActivityUserBinding


class UserActivity : AppCompatActivity() {

    lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.submitButton.setOnClickListener {

            val playerName = binding.nameEditText.text.toString()
            val playerAge = binding.ageEditText.text.toString().toInt()
            val playerGender = binding.genderEditText.text.toString()

            val player = Player(playerName, playerAge, playerGender)

            FirestoreHelper.addPlayer(player) { success ->
                if (success) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {

                }
            }




        }
    }
}