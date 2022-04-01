package com.example.sqlcomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlcomroom.adapter.UserAdapter
import com.example.sqlcomroom.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(
            layoutInflater, container, false
        )

        viewModel = MainViewModel(context)
        val adapter = UserAdapter()

        viewModel.lerTodosOsDados.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }


        binding.recyclerUser.layoutManager = LinearLayoutManager(context)
        binding.recyclerUser.adapter = adapter
        binding.recyclerUser.setHasFixedSize(true)

        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return binding.root
    }

}