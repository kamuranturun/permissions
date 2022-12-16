package com.kamuran.handler

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.os.postDelayed
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var islemTamamlandi=false
    var splashscreenDoldu=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kameraIzınKontrol()
        Handler().postDelayed(
            {
                if (islemTamamlandi) {
                    constraintLayoutsplash.visibility = View.GONE
                } else {
                    splashscreenDoldu = true
                }
            },
            2500
        )
        uzunIslemBaslat()





        //Handler
        //splashscreen

        Handler().post{
            //println("post içi")
           // Toast.makeText(this,"post içi",Toast.LENGTH_LONG).show()
        }

       Handler().postDelayed({
           Toast.makeText(this,"delayed içi",Toast.LENGTH_LONG).show()
           constraintLayoutsplash.visibility=View.GONE
       },50000)

        }
fun uzunIslemBaslat(){

    Handler().postDelayed({
        Toast.makeText(this,"delayed içi",Toast.LENGTH_LONG).show()
        constraintLayoutsplash.visibility=View.GONE
    },2000)
}


    fun kameraIzınKontrol(){
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED)
        {
            println("izin var")
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),1)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)==PackageManager.PERMISSION_DENIED){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA))
        {

            Toast.makeText(this,"kamera izni vermelisiniz",Toast.LENGTH_LONG).show()
        }else{
            println("ayarlara gidip izin verin")
        }
        return
    }

        Toast.makeText(this,"izin verildi",Toast.LENGTH_LONG).show()
    }

    }
