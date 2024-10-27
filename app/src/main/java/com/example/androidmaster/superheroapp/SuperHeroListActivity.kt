package com.example.androidmaster.superheroapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmaster.databinding.ActivitySuperHeroListBinding
import com.example.androidmaster.superheroapp.DetailSuperHeroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding;
    private lateinit var retrofit: Retrofit;
    private lateinit var adapter: SuperHeroAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater);
        setContentView(binding.root);
        retrofit = getRetrofit();
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty());
                return false;
            }

            override fun onQueryTextChange(newText: String?): Boolean = false;

        });

        adapter = SuperHeroAdapter{navigateToDetail(it)};
        binding.rvSuperHero.setHasFixedSize(true);
        binding.rvSuperHero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperHero.adapter = adapter;
    }

    private fun searchByName(query: String) {
        binding.progessBar.isVisible = true;
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperHeroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperheroes(query);

            if (myResponse.isSuccessful) {
                Log.i("FabioDev", "Funciona :)")
                val response: SuperHeroDataResponse? = myResponse.body()

                if (response != null) {
                    Log.i("FabioDev", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.superHeroe)
                        binding.progessBar.isVisible = false;
                    }
                }

            } else {
                Log.i("FabioDev", "No Funciona :(")
            }
        }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navigateToDetail(id: String){
        val intent = Intent(this, DetailSuperHeroActivity::class.java);
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }

}