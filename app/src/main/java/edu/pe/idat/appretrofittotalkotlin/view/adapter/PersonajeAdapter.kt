package edu.pe.idat.appretrofittotalkotlin.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.pe.idat.appretrofittotalkotlin.databinding.ItemPersonajeBinding
import edu.pe.idat.appretrofittotalkotlin.retrofit.response.Personaje

class PersonajeAdapter(private var listPersonaje: List<Personaje>)
    : RecyclerView.Adapter<PersonajeAdapter.ViewHolder>()
{
    inner class ViewHolder(val binding: ItemPersonajeBinding)
        :RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeAdapter.ViewHolder {
        val binding = ItemPersonajeBinding.inflate(
            LayoutInflater
            .from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: PersonajeAdapter.ViewHolder, position: Int) {
        with(holder){
            with(listPersonaje[position]){
                binding.tvnombre.text = name
                binding.tvgenero.text = gender
                Glide.with(itemView.context)
                    .load(image)
                    .into(binding.ivpersonaje)
            }
        }
    }
    override fun getItemCount() = listPersonaje.size
}