package com.example.customdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButton: ImageButton = findViewById(R.id.imageBtn)
        imageButton.setOnClickListener {view ->
            Snackbar.make(view, "Image Button Pressed", Snackbar.LENGTH_LONG).show()
        }

        //Implementation of Alert Dialog
        val alertDialogBtn : Button = findViewById(R.id.alertDialogBtn)
        alertDialogBtn.setOnClickListener {
            showAlertDialog()
        }

        //Implementation of Custom alert Dialog
        val customDialogBtn : Button = findViewById(R.id.customDialogBtn)
        customDialogBtn.setOnClickListener {
            customAlertDialog()
        }

        //Implementation of custom progress bar
        val customProgressDialogBtn: Button = findViewById(R.id.customProgressDialogBtn)
        customProgressDialogBtn.setOnClickListener {
            showCustomProgressBarDialog()
        }
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Alert")
        builder.setMessage("This is an alert Dialog which is userd to show a alert Dialog")
        builder.setIcon(R.drawable.alert_ic)

        builder.setPositiveButton("Yes"){dialogInterface, which ->
            Toast.makeText(applicationContext, "Press Yes", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setNeutralButton("Cancel"){dialogInterface, which ->
            Toast.makeText(applicationContext, "Press Cancel", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No"){dialogInterface, which ->
            Toast.makeText(applicationContext, "Press No", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    //Function for custom dialog
    private fun customAlertDialog(){
        val customDialog = Dialog(this)

        customDialog.setContentView(R.layout.custom_dialog)

        customDialog.findViewById<TextView>(R.id.submitTV).setOnClickListener ( View.OnClickListener{
            Toast.makeText(applicationContext, "Submit Btn Pressed", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
            }
        )

        customDialog.findViewById<TextView>(R.id.cancelTV).setOnClickListener ( View.OnClickListener{
            Toast.makeText(applicationContext, "Cancel Btn Pressed", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
            }
        )

        customDialog.show()
    }

    //Function for custom progress bar
    private fun showCustomProgressBarDialog(){
        val progressBarDialog = Dialog(this)

        progressBarDialog.setContentView(R.layout.custom_progress_dialog)

        progressBarDialog.show()
    }
}