package com.example.mobile_dev

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_dev.databinding.FragmentDateBinding
import java.util.Calendar

class DateFragment : Fragment(R.layout.fragment_date) {
    private lateinit var binding: FragmentDateBinding

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDateBinding.bind(view)

        binding.pickDateButton.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            context?.let {
                DatePickerDialog(
                    it,
                    { _, year, monthOfYear, dayOfMonth ->
                        binding.dateInput.text =
                            (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    },
                    year,
                    month,
                    day
                )
            }?.show()
        }

        binding.openOutputButton.setOnClickListener {
            val name = arguments?.getString("NAME")
            val surname = arguments?.getString("SURNAME")

            val arguments = Bundle().apply {
                putString("DATE", binding.dateInput.text.toString())
                putString("NAME", name)
                putString("SURNAME", surname)
            }

            findNavController()
                .navigate(R.id.action_dateFragment_to_outputFragment, arguments)
        }
    }
}