package com.example.mobile_dev.db

import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobile_dev.R
import com.example.mobile_dev.databinding.DbMainBinding
import kotlinx.coroutines.runBlocking

@Database(
    entities = [
        DbItem::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dbItemDao(): DbItemDao
}

class DbListFragment : Fragment(R.layout.db_main) {
    private lateinit var binding: DbMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DbMainBinding.bind(view)

        val dao = StorageApp.db.dbItemDao()

        val adapter = DbItemAdapter(
            {item ->
                val arguments = Bundle().apply {
                    putString("ID", item.uid)
                    putString("TITLE", item.title)
                    putString("TEXT", item.text)
                }

                findNavController()
                    .navigate(R.id.action_dbListFragment_to_dbEditorFragment, arguments)
            },
            {item ->
                runBlocking {
                    dao.delete(item)
                }
            }
        )

        binding.listView.adapter = adapter
        binding.listView.layoutManager = LinearLayoutManager(this.context)

        runBlocking {
            val items = dao.getAll()
            adapter.dbItemList = items.toMutableList()
            binding.emptyState.root.isInvisible = items.isNotEmpty()
            binding.root.isInvisible = items.isEmpty()
            adapter.notifyDataSetChanged()
        }

        binding.addButton.setOnClickListener { onAddItem() }
        binding.emptyState.addFirst.setOnClickListener { onAddItem() }
    }

    private fun onAddItem() {
        findNavController()
            .navigate(R.id.action_dbListFragment_to_dbEditorFragment, arguments)
    }
}