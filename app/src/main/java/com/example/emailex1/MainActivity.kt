package com.example.emailex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var emails = email.text.trim().toString().split(",")

        send.setOnClickListener {

            var emails = email.text.trim().toString()
            var sub= subject.text.toString()
            var msg = message.text.toString()

            if(emails.isNotEmpty() && sub.isNotEmpty() && msg.isNotEmpty()){
                var i = Intent()
                i.action = Intent.ACTION_SEND
                i.putExtra(Intent.EXTRA_EMAIL, arrayOf(emails))
                i.putExtra(Intent.EXTRA_SUBJECT,sub)
                i.putExtra(Intent.EXTRA_TEXT,msg)

                i.type = "message/rfc822"

                startActivity(Intent.createChooser(i,"Select Email Client"))

            }else{
                Toast.makeText(this,"Enter All Details",Toast.LENGTH_LONG).show()
            }

            email.setText("")
            subject.setText("")
            message.setText("")


        }



    }
}
