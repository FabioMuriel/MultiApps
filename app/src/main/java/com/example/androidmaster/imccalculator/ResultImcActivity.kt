package com.example.androidmaster.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.androidmaster.R
import com.example.androidmaster.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultImcActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView;
    private lateinit var tvResultImc: TextView;
    private lateinit var tvDescription: TextView;
    private lateinit var  btnRecalculate: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0;
        initComponent();
        initListener();
        initiUi(result)
    }

    private fun initListener() {
        btnRecalculate.setOnClickListener {
            this.onBackPressed()
        }
    }

    private fun initiUi(result: Double) {

        tvResultImc.text = result.toString();

        when (result) {
            in 0.00..10.50 -> { //Bajo Peso
                tvResult.text = getString(R.string.title_peso_normal);
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso);
            }

            in 18.51..24.99 -> { //Peso Normal
                tvResult.text = getString(R.string.title_peso_normal);
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescription.text = getString(R.string.description_peso_normal);
            }

            in 25.00..29.99 -> { //Sobrepeso
                tvResult.text = getString(R.string.title_sobrepeso);
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                tvDescription.text = getString(R.string.description_sobrepeso);
            }

            in 30.00..99.00 -> { //Obesidad
                tvResult.text = getString(R.string.title_obesidad);
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescription.text = getString(R.string.description_obesida);
            }

            else -> { //Error
                tvResult.text = getString(R.string.error);
                tvResultImc.text = getString(R.string.error);
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescription.text = getString(R.string.error);
            }
        }
    }

    private fun initComponent() {
        tvResult = findViewById(R.id.tvResult);
        tvResultImc = findViewById(R.id.tvResultImc);
        tvDescription = findViewById(R.id.tvDescription);
        btnRecalculate = findViewById(R.id.btnRecalculate);
    }
}