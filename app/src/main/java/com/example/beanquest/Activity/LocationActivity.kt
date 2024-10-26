package com.example.beanquest.Activity

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.example.beanquest.R
import com.example.beanquest.databinding.ActivityLocalBinding

class LocationActivity : AppCompatActivity() {
    lateinit var binding: ActivityLocalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryList = arrayOf("Астана", "Караганда", "Сарань", "Абай", "Темиртау")
        val adapter =
            ArrayAdapter(this@LocationActivity, android.R.layout.simple_list_item_1, countryList)
        binding.locationList.setAdapter(adapter)

        binding.locationList.setOnItemClickListener { parent, view, position,l ->

            val selectedLocation = parent.getItemAtPosition(position) as String
            showDialogAtPosition(selectedLocation)

        }

    }



    fun showDialogAtPosition(location:String){
        val dialogView = layoutInflater.inflate(R.layout.aler_dialog, null)

        val dialogBuilder = AlertDialog.Builder(this@LocationActivity)
        dialogBuilder.setView(dialogView)

        val dialog = dialogBuilder.create()

        dialogView.findViewById<AppCompatButton>(R.id.btn_yes).setOnClickListener{
            startActivityWithLovation(location)
            dialog.dismiss()
        }
        dialogView.findViewById<AppCompatButton>(R.id.btn_cansel)?.setOnClickListener {
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    private fun startActivityWithLovation(location: String) {
        val intent = Intent(this@LocationActivity, MainActivity::class.java)
        intent.putExtra("location",location)
        startActivity(intent)
        finish()
    }
}