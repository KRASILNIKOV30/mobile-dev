package com.example.mobile_dev.db

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.DbFragmentEditorBinding
import kotlinx.coroutines.runBlocking
import java.time.LocalDate
import java.util.UUID

class DbEditorFragment : Fragment(R.layout.db_fragment_editor) {
    private lateinit var binding: DbFragmentEditorBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DbFragmentEditorBinding.bind(view)

        val id = arguments?.getString("ID")
        val title = arguments?.getString("TITLE")
        val text = arguments?.getString("TEXT")

        binding.titleInput.setText(title)
        binding.descriptionInput.setText(text)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.toolbar.setOnMenuItemClickListener {
            runBlocking {
                val dao = StorageApp.db.dbItemDao()
                val newTitle = binding.titleInput.getText().toString()
                val newText = binding.descriptionInput.getText().toString()

                if (!id.isNullOrEmpty()) {
                    val updatedDbItem = DbItem(
                        id,
                        title = newTitle,
                        text = newText,
                        date = LocalDate.now().toString(),
                    )
                    dao.updateAll(updatedDbItem)
                }
                else {
                    val newId = UUID.randomUUID().toString()
                    val newDbItem = DbItem(
                        newId,
                        title = newTitle,
                        text = newText,
                        date = LocalDate.now().toString(),
                    )
                    dao.insertAll(newDbItem)
                }
                findNavController().popBackStack()
            }
        }

    }
}