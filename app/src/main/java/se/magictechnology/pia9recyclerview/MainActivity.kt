package se.magictechnology.pia9recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.text.set
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var fancyAdapter = FancyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var theRV = findViewById<RecyclerView>(R.id.theRecycler)

        //theRV.layoutManager = LinearLayoutManager(this)
        theRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        //theRV.layoutManager = GridLayoutManager(this, 8)
        //theRV.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, true)

        theRV.adapter = fancyAdapter



        var addbutton = findViewById<Button>(R.id.addpersonButton)
        addbutton.setOnClickListener {

            var personedittext = findViewById<EditText>(R.id.personEditText)

            var personname = personedittext.text.toString()

            personedittext.setText("")

            fancyAdapter.people.add(personname)
            fancyAdapter.doneMarking.add(false)

            fancyAdapter.notifyDataSetChanged()
        }

    }
}