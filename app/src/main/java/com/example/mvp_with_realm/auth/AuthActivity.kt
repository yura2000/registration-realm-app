package com.example.mvp_with_realm.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.mvp_with_realm.MainActivity
import com.example.mvp_with_realm.R
import com.example.mvp_with_realm.new_question.AddQuestionActivity
import com.example.mvp_with_realm.new_question.Question
import com.example.mvp_with_realm.registration.RegisterActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_register.*

class AuthActivity : AppCompatActivity(), AuthView {

    private var presenter: AuthPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)

        presenter = AuthPresenter(this, AuthService())
    }

    override val name: String
        get() = username_et.text.toString()

    override fun startAddQuestionActivity() {
        val intent = Intent(this, AddQuestionActivity::class.java)
        startActivity(intent)
    }

    override val password: String
        get() = password_et.text.toString()

    fun onLoginClicked(view: View) {
        presenter!!.onLoginClicked()
    }

    fun onRegisterInAuthClicked(view: View) {
        presenter!!.onRegisterInAuthClicked()
    }

    override fun showNameError(resId: Int) {
        username_et.error = getString(resId)
    }

    override fun showPasswordError(resId: Int) {
        password_et.error = getString(resId)
    }

    override fun startRegisterActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    override fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun showLoginIncorrectError(resId: Int) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show()
    }
}
