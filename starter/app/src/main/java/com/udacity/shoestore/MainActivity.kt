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
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_login.*

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
        //drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.myNavHostFragment)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment , R.id.shoeListFragment))
       //NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
       //appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        //NavigationUI.setupWithNavController(binding.toolbar, navController)


        //NavigationUI.setupActionBarWithNavController(this, navController)




        /* val shoe1 = Shoe("MC Boot1", 11.0, "HD", "boot 1")
        val shoe2 = Shoe("MC Boot2", 10.0, "HD", "boot 2")
        val shoe3 = Shoe("MC Boot3", 9.0, "HD", "boot 3")
        var myShoeModel : ShoeViewModel = ShoeViewModel()
        myShoeModel.addShoe(shoe1)
        myShoeModel.addShoe(shoe2)
        myShoeModel.addShoe(shoe3) */


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
