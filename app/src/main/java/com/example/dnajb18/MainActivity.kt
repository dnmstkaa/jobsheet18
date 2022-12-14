package com.example.dnajb18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawer: DrawerLayout
    lateinit var navView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)
        drawer = findViewById(R.id.drawer_layout)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Navigation Drawer"

        toggle = ActionBarDrawerToggle(this@MainActivity, drawer,
            0, 0)

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_pplg -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content, pplg())
                fragmentTransaction.commit()
                drawer.close()
            }
            R.id.nav_tpfl ->  {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content, tpfl())
                fragmentTransaction.commit()
                drawer.close()
            }
            R.id.nav_to -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content, to())
                fragmentTransaction.commit()
                drawer.close()
            }
            R.id.nav_busana ->  {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content, busana())
                fragmentTransaction.commit()
                drawer.close()
            }
            R.id.nav_kuliner ->  {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content, kuliner())
                fragmentTransaction.commit()
                drawer.close()
            }
        }
        return true
    }
}