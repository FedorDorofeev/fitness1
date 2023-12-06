package com.example.fitness1
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {

    //Создаем массив разделов:
    private val titles = arrayOf(
        "Начало",
        "Упражнения на руки для новичка",
        "Упражнения на руки для продвинуого",
        "Упражнения для груди для новичка",
        "Упражнения для груди для продвинутого",
        "Упражнения для ног для новичка",
        "Упражнения для ног для продвинутого",
        "Упражнения на кадио для новичка",
        "Упражнения на кардио для продвинутого",



        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_about)

        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, titles)
        listView.isTextFilterEnabled = true

        listView.onItemClickListener =
            OnItemClickListener { a, v, position, id ->
                val intent = Intent()
                intent.setClass(this@AboutActivity, DetailActivity::class.java)
                intent.putExtra("title", position)

                startActivity(intent)
            }
    }
}