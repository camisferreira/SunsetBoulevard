package com.example.sunsetboulevard


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import kotlinx.android.synthetic.main.activity_cadastro.btnCadastrar
import kotlinx.android.synthetic.main.activity_login.btnLoginCadastrar
import kotlinx.android.synthetic.main.activity_login.btnLoginEntrar
import kotlinx.android.synthetic.main.activity_login.edtLoginEmail
import kotlinx.android.synthetic.main.activity_login.edtLoginSenha


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnLoginEntrar.setOnClickListener {

            val email = edtLoginEmail.text.toString().trim().toLowerCase()
            val senha = edtLoginSenha.text.toString().trim()

            if (email.isEmpty()) {
                edtLoginEmail.error = "Campo Obrigatório!"
                edtLoginEmail.requestFocus()
            } else if (senha.isEmpty()) {
                edtLoginSenha.error = "Campo Obrigatório!"
                edtLoginSenha.requestFocus()
            } else {
                val sharedPrefs = getSharedPreferences("Cadastro_$email", Context.MODE_PRIVATE)


                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")

                if (email == emailPrefs && senha == senhaPrefs) {
                    Toast.makeText(this, "Usuário logado com sucesso!", Toast.LENGTH_LONG).show()

                    val mIntent = Intent(this, MainActivity::class.java)

                    mIntent.putExtra("INTENT_EMAIL", email)
                    startActivity(mIntent)
                    finish()

                } else {
                    Toast.makeText(this, "Email ou senha inválido!", Toast.LENGTH_LONG).show()

                }
            }


            btnLoginCadastrar.setOnClickListener {
                val mIntent = Intent(this, CadastroActivity::class.java)
                startActivity(mIntent)

            }


        }


    }
}










