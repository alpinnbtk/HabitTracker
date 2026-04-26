package com.example.project1_weare.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.project1_weare.databinding.FragmentNewHabitBinding
import com.example.project1_weare.model.Habit
import com.example.project1_weare.viewmodel.HabitViewModel

class NewHabitFragment : Fragment() {

    private lateinit var binding: FragmentNewHabitBinding
    private lateinit var viewModel: HabitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewHabitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ini pake requireActivity boleh kah?
        viewModel = ViewModelProvider(requireActivity())[HabitViewModel::class.java]


        binding.btnCreate.setOnClickListener {

            val name = binding.txtName.text.toString()
            val desc = binding.txtDesc.text.toString()
            val goal = binding.txtGoal.text.toString()
            val unit = binding.txtUnit.text.toString()

            if (name.isEmpty() || desc.isEmpty() || goal.isEmpty()) {
                binding.txtName.error = "Tidak boleh kosong"
                return@setOnClickListener
            }

            val habit = Habit(
                name,
                desc,
                goal.toInt(),
                unit,
                0,
                android.R.drawable.ic_menu_compass,

            )

            viewModel.addHabit(habit)

            findNavController().popBackStack()
        }
    }
}