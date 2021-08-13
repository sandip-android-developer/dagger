package com.example.daggerdemo.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerdemo.MyApplication
import com.example.daggerdemo.R
import com.example.daggerdemo.login.LoginActivity
import com.example.daggerdemo.registration.RegistrationActivity
import com.example.daggerdemo.setting.SettingsActivity
import com.example.daggerdemo.user.UserManager
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    /*@Inject
    lateinit var userManager: UserManager*/

    /**
     * If the User is not registered, RegistrationActivity will be launched,
     * If the User is not logged in, LoginActivity will be launched,
     * else carry on with MainActivity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val userManager=(application as MyApplication).appComponent.userManager()
        if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        } else {
            setContentView(R.layout.activity_main)

          //  mainViewModel = MainViewModel(userManager.userDataRepository!!)
            setupViews()
        }
    }

    /**
     * Updating unread notifications onResume because they can get updated on SettingsActivity
     */
    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.notifications).text = mainViewModel.notificationsText
    }

    private fun setupViews() {
        findViewById<TextView>(R.id.hello).text = mainViewModel.welcomeText
        findViewById<Button>(R.id.settings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}