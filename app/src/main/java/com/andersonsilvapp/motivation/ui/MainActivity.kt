package com.andersonsilvapp.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.andersonsilvapp.motivation.infra.MotivationConstants
import com.andersonsilvapp.motivation.R
import com.andersonsilvapp.motivation.data.Mock
import com.andersonsilvapp.motivation.infra.SecurityPreferences
import com.andersonsilvapp.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
  private lateinit var binding: ActivityMainBinding

  private var categoryId = MotivationConstants.FILTER.ALL

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.hide()

    handleUserName()
    handleNextPhrase()

    binding.buttonNewPhrase.setOnClickListener(this)
    binding.imageAll.setOnClickListener(this)
    binding.imageSmile.setOnClickListener(this)
    binding.imageSun.setOnClickListener(this)

    binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))

  }

  override fun onClick(view: View) {
    if (view.id == R.id.button_new_phrase) {
      handleNextPhrase()
    } else if (view.id in listOf(R.id.image_all, R.id.image_smile, R.id.image_sun)) {
      handleChange(view.id)
    }
  }

  private fun handleUserName() {
    val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

    binding.textUserName.text = "Olá, $name"
  }

  private fun handleChange(id: Int) {
    binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
    binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
    binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

    when (id) {
      R.id.image_all -> {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
        categoryId = MotivationConstants.FILTER.ALL
      }

      R.id.image_smile -> {
        binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.white))
        categoryId = MotivationConstants.FILTER.SMILE
      }

      R.id.image_sun -> {
        binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
        categoryId = MotivationConstants.FILTER.SUN
      }
    }
  }

  private fun handleNextPhrase() {
    var phrase = Mock().getPhrase(categoryId)

    binding.textPhrase.text = phrase
  }
}