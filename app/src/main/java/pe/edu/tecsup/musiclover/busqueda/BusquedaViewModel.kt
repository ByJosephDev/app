package pe.edu.tecsup.musiclover.busqueda

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.tecsup.musiclover.network.BusquedaResponse
import pe.edu.tecsup.musiclover.network.NuevosLanzamientosResponse
import pe.edu.tecsup.musiclover.network.SpotifyApi
import java.lang.Exception

class BusquedaViewModel : ViewModel() {

    private val _busquedaResponse = MutableLiveData<BusquedaResponse>()
    private val _nuevoslanzamientosResponse = MutableLiveData<NuevosLanzamientosResponse>()
    val busquedaResponse: LiveData<BusquedaResponse>
        get() = _busquedaResponse

    init {
        //pruebaBusqueda("track", "pedro suarez")
        pruebaNuevosLanzamientos()
    }

    private fun pruebaBusqueda(tipo: String, q: String) {
        viewModelScope.launch {
            try {
                _busquedaResponse.value = SpotifyApi.retrofitService.buscar(tipo, q)
                Log.d("BusquedaViewModel", _busquedaResponse.value.toString())
            } catch (e: Exception) {
                Log.e("BusquedaViewModel", e.toString())
                _busquedaResponse.value = null
            }
        }
    }

    private fun pruebaNuevosLanzamientos() {
        viewModelScope.launch {
            try {
                _nuevoslanzamientosResponse.value = SpotifyApi.retrofitService.nuevosLanzamientos()
            } catch (e: Exception) {
                _nuevoslanzamientosResponse.value = null
            }
        }
    }

}