package com.example.androidmaster.imccalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.androidmaster.R
import com.example.androidmaster.firstapp.ResultActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true;
    private var isFemaleSelected: Boolean = false;
    private var currentWeight: Int = 70;
    private var currentAge: Int = 19;
    private var currentHeight: Int = 120;

    private lateinit var viewMale:CardView;
    private lateinit var viewFemale:CardView;
    private lateinit var tvHeight: TextView;
    private lateinit var rsHeight: RangeSlider;
    private lateinit var btnSubrtracWeight: FloatingActionButton;
    private lateinit var btnPlusWeight: FloatingActionButton;
    private lateinit var tvWeight: TextView;
    private lateinit var btnSubrtracAge: FloatingActionButton;
    private lateinit var btnPlusAge: FloatingActionButton;
    private lateinit var tvAge: TextView;
    private lateinit var btnCalculate: Button;

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponent();
        initListener();
        initUI();
    }

    private fun initComponent() {
        viewMale = findViewById(R.id.viewMale);
        viewFemale = findViewById(R.id.viewFemale);
        tvHeight = findViewById(R.id.tvHeight);
        rsHeight = findViewById(R.id.rsHeight);
        btnSubrtracWeight = findViewById(R.id.btnSubrtracWeight);
        btnPlusWeight = findViewById(R.id.btnPlusWeight);
        tvWeight = findViewById(R.id.tvWeight);
        btnSubrtracAge = findViewById(R.id.btnSubrtracAge);
        btnPlusAge = findViewById(R.id.btnPlusAge);
        tvAge = findViewById(R.id.tvAge);
        btnCalculate = findViewById(R.id.btnCalculate);
    }

    private fun initListener() {

        viewMale.setOnClickListener {
            changeGender();
            setGenderColor()
        }

        viewFemale.setOnClickListener {
            changeGender();
            setGenderColor()
        }
        
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##");
            currentHeight = df.format(value).toInt();
            "$currentHeight Cm".also { tvHeight.text = it };
        };

        btnSubrtracWeight.setOnClickListener {
            currentWeight++;
            setWeight()
        }

        btnPlusWeight.setOnClickListener {
            currentWeight--;
            setWeight()
        }

        btnPlusAge.setOnClickListener {
            currentAge++;
            setAge();
        }

        btnSubrtracAge.setOnClickListener {
            currentAge--;
            setAge();
        }

        btnCalculate.setOnClickListener {
            val result = calculateIMC();
            navigateToResult(result)
        }

    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultImcActivity::class.java);
        intent.putExtra(IMC_KEY, result);
        startActivity(intent);
    }

    private fun calculateIMC() : Double {
        var df = DecimalFormat("#.##");
        val imc = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100);
        return df.format(imc).toDouble();
    }

    private fun setAge() {
        tvAge.text = currentAge.toString();
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString();
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected;
        isFemaleSelected = !isFemaleSelected;
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected));
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected));
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean) : Int{

        val colorReference = if(isSelectedComponent){
            R.color.background_component_selected
        }
        else{
            R.color.background_component
        };

        return ContextCompat.getColor(this, colorReference);

    }

    private fun initUI() {
        setGenderColor();
        setWeight();
        setAge();
    }

}
