package edu.pe.idat.appretrofittotalkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import edu.pe.idat.appretrofittotalkotlin.R
import edu.pe.idat.appretrofittotalkotlin.databinding.ActivityMainBinding
import edu.pe.idat.appretrofittotalkotlin.retrofit.RetrofitCliente
import edu.pe.idat.appretrofittotalkotlin.retrofit.response.Personaje
import edu.pe.idat.appretrofittotalkotlin.retrofit.response.ResultPersonaje
import edu.pe.idat.appretrofittotalkotlin.view.adapter.PersonajeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvpersonaje.layoutManager = LinearLayoutManager(this)
        obtenerPersonsajes()

    }

    private fun obtenerPersonsajes() {
        val call : Call<ResultPersonaje> = RetrofitCliente
            .retrofitServicio.obtenerPersonajes()
        call.enqueue(object : Callback<ResultPersonaje>{
            override fun onResponse(
                call: Call<ResultPersonaje>,
                response: Response<ResultPersonaje>
            ) {
                val listapersonajes = response.body()!!.results
                binding.rvpersonaje.adapter = PersonajeAdapter(listapersonajes)
            }

            override fun onFailure(call: Call<ResultPersonaje>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}