package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController:NavController

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.host)
                    as NavHostFragment
       navController = navHostFragment.navController
     //   NavigationUI.setupActionBarWithNavController(this,navController)
      //  appBarConfiguration = AppBarConfiguration(navController.graph)

     setSupportActionBar(toolbar)
    setupActionBarWithNavController(navController)
    // setupActionBarWithNavController(navController,appBarConfiguration)

    }

   override fun onSupportNavigateUp(): Boolean {
       val navController = this.findNavController(R.id.host)
       return navController.navigateUp()
   }
}
