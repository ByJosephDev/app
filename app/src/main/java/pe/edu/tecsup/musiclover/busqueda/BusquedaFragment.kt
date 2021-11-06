package pe.edu.tecsup.musiclover.busqueda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pe.edu.tecsup.musiclover.databinding.FragmentBusquedaBinding

class BusquedaFragment : Fragment() {

    private val viewModel: BusquedaViewModel by lazy {
        ViewModelProvider(this).get(BusquedaViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBusquedaBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

}