package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.models.Shoe

private lateinit var binding: ActivityMainBinding

/* class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Timber.plant(Timber.DebugTree())
    }
} */
class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.myNavHostFragment)
       NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
       appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)


        val allShoes = mutableListOf<Shoe>(

            Shoe("MC Boot1", 11.0, "HD", "boot 1"),
            Shoe("MC Boot1", 11.0, "HD", "boot 2"),
            Shoe("MC Boot1", 11.0, "HD", "boot 3")
        )
        var myShoeModel : ShoeViewModel = ShoeViewModel()
        myShoeModel.addShoe()


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.logout_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logoutButton -> {
                val navController = this.findNavController(R.id.myNavHostFragment)
                navController.navigate(R.id.loginFragment)

            }

        }
        return super.onOptionsItemSelected(item)
    }

}
