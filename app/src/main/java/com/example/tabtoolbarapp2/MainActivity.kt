package com.example.tabtoolbarapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var tlVistaTabla:TabLayout
    private lateinit var vpVistaPager:ViewPager2

    private val adaptador by lazy{
        vpAdaptador(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tlVistaTabla = findViewById(R.id.tl_VistaTablero)
        vpVistaPager = findViewById(R.id.vp_VistaPager)

        vpVistaPager.adapter = adaptador


        val mediadorTabla:TabLayoutMediator = TabLayoutMediator(tlVistaTabla,vpVistaPager,
            TabLayoutMediator.TabConfigurationStrategy{
            tab, position ->
                when(position){
                    0->{
                        tab.text = "Opcion 1"
                        tab.setIcon(R.drawable.ic_img1)
                        val badge:BadgeDrawable = tab.orCreateBadge
                        badge.backgroundColor = ContextCompat.getColor(applicationContext,R.color.miColor)
                        badge.isVisible = true

                    }
                    1->{
                        tab.text = "Opcion 2"
                        tab.setIcon(R.drawable.ic_img2)
                        val badge:BadgeDrawable = tab.orCreateBadge
                        badge.backgroundColor = ContextCompat.getColor(applicationContext,R.color.miColor)
                        badge.number = 10
                        badge.isVisible = true
                    }
                    2->{
                        tab.text = "Opcion 3"
                        tab.setIcon(R.drawable.ic_img3)
                        val badge:BadgeDrawable = tab.orCreateBadge
                        badge.backgroundColor = ContextCompat.getColor(applicationContext,R.color.miColor)
                        badge.number = 100
                        badge.maxCharacterCount = 3
                        badge.isVisible = true
                    }
                    3->{
                        tab.text = "Opcion 4"
                        tab.setIcon(R.drawable.ic_img4)
                    }
                }
        })
        mediadorTabla.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.miConfiguracion->
                Toast.makeText(this,"Has seleccionado configuracion",Toast.LENGTH_SHORT).show()
            R.id.miContactos->
                Toast.makeText(this,"Has seleccionado Contactos",Toast.LENGTH_SHORT).show()
            R.id.miNActivity->
                Toast.makeText(this,"Has seleccionado una nueva activity",Toast.LENGTH_SHORT).show()
            R.id.miClose->
                finish()
        }

        return true
    }



}