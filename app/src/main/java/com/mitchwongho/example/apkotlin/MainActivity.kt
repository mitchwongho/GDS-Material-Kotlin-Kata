package com.mitchwongho.example.apkotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bmp: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.image)
        Palette.from(bmp).generate {
            val mutedColour = it.getMutedColor(R.attr.colorPrimary)
            collapsing_toolbar.setContentScrimColor(mutedColour)
            footer_toolbar.setBackgroundColor(mutedColour)
        }
        super.setSupportActionBar(header_toolbar)
        header_toolbar.setNavigationIcon(R.mipmap.ic_menu_24dp)
        // on nav item click
        header_toolbar.setNavigationOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }
        //
        // onItemSelected
        nav_drawer.setNavigationItemSelectedListener {
            it.setChecked(true)
            drawer.closeDrawers()
            true
        }

        footer_toolbar.inflateMenu(R.menu.menu_footer)

        val dow = resources.getStringArray(R.array.days_of_week)
        val adapter = SimpleAdapter(dow)
        main_recyclerview.setHasFixedSize(true)
        main_recyclerview.layoutManager = LinearLayoutManager(this)
        main_recyclerview.adapter = adapter

        // F.A.B
        fab.setOnClickListener {
            Snackbar.make(it, R.string.salutation, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onResume() {

        super.onResume()
    }
}
