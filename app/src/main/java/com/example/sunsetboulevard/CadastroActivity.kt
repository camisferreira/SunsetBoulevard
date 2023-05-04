package com.example.sunsetboulevard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import com.example.sunsetboulevard.ui.theme.SunsetBoulevardTheme
import kotlinx.android.synthetic.main.activity_cadastro.btnCadastrar
import kotlinx.android.synthetic.main.activity_cadastro.edtCadastroEmail
import kotlinx.android.synthetic.main.activity_cadastro.edtCadastroNome
import kotlinx.android.synthetic.main.activity_cadastro.edtCadastroSenha
import kotlinx.android.synthetic.main.activity_cadastro.edtCadastroSobrenome
import kotlinx.android.synthetic.main.activity_login.btnLoginCadastrar

class CadastroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

    btnCadastrar.setOnClickListener {

        val nome = edtCadastroNome.text.toString().trim()
        val sobrenome = edtCadastroSobrenome.text.toString().trim()
        val email = edtCadastroEmail.text.toString().trim().toLowerCase()
        val senha = edtCadastroSenha.text.toString().trim()

        if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preeencha todos os campos!", Toast.LENGTH_SHORT).show()

        } else {
            val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

            val editPrefs = sharedPrefs.edit()

            editPrefs.putString("NOME", nome)
            editPrefs.putString("SOBRENOME", sobrenome)
            editPrefs.putString("EMAIL", email)
            editPrefs.putString("SENHA", senha)

            editPrefs.apply()

            val mIntent = Intent(this, MainActivity::class.java)

            mIntent.putExtra("INTENT_EMAIL", email)
            startActivity(mIntent)

            finishAffinity()

        }
    }


        }
    }

