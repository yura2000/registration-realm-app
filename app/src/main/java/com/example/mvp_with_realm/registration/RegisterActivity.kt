package com.example.mvp_with_realm.registration

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.mvp_with_realm.MainActivity
import com.example.mvp_with_realm.R
import com.example.mvp_with_realm.auth.AuthActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterView {

    private var presenter: RegisterPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)

        presenter = RegisterPresenter(this, RegisterService())
    }

    override val name: String
        get() = username_et.text.toString()

    override val password: String
        get() = password_et.text.toString()


    fun onRegisterClicked(view: View) {
        presenter!!.onRegisterClicked()
    }

    override fun showNameError(resId: Int) {
        username_et.error = getString(resId)
    }

    override fun showPasswordError(resId: Int) {
        password_et.error = getString(resId)
    }


    override fun showUserWithThisUsernameAlreadyExists(resId: Int) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show()
    }

    override fun startAuthActivity() {
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }
}
