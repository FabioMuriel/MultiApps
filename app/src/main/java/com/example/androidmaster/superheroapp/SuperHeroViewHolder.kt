package com.example.androidmaster.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaster.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ItemSuperheroBinding.bind(view);

    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected: (id: String) -> Unit) {
        binding.tvSuperHeroName.text = superHeroItemResponse.superHeroName;

        Picasso.get().load(superHeroItemResponse.superHeroImage.url).into(binding.ivSuperHero);

        binding.root.setOnClickListener {
            onItemSelected(superHeroItemResponse.superHeroId);
        }

    }
}