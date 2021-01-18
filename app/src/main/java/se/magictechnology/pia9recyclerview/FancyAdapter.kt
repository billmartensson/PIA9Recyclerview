package se.magictechnology.pia9recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FancyAdapter() : RecyclerView.Adapter<FancyViewHolder>() {

    var people = mutableListOf<String>("A", "B", "C")
    var doneMarking = mutableListOf<Boolean>(false, true, false)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FancyViewHolder {

        Log.d("PIA9DEBUG", "onCreateViewHolder")

        val vh = FancyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fancy_item, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        //Log.d("PIA9DEBUG", "getItemCount")
        return people.size
    }

    override fun onBindViewHolder(holder: FancyViewHolder, position: Int) {
        Log.d("PIA9DEBUG", "onBindViewHolder " + position.toString())

        holder.theText.text = people[position]

        holder.rowNumbText.text = position.toString()

        if(doneMarking[position] == true)
        {
            holder.doneText.visibility = View.VISIBLE
            holder.fancyimageview.setImageResource(R.drawable.frog)
        } else {
            holder.doneText.visibility = View.INVISIBLE
            holder.fancyimageview.setImageResource(R.drawable.bird)
        }

        holder.itemView.setOnClickListener {
            Log.d("PIA9DEBUG", "klickat på rad nummer $position")

            //people.removeAt(position)

            if(doneMarking[position] == true)
            {
                doneMarking[position] = false
            } else {
                doneMarking[position] = true
            }


            notifyDataSetChanged()
        }

    }

}

class FancyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var theText = view.findViewById<TextView>(R.id.fancyTextView)

    var rowNumbText = view.findViewById<TextView>(R.id.rowNumberTextView)

    var doneText = view.findViewById<TextView>(R.id.doneTextView)

    var fancyimageview = view.findViewById<ImageView>(R.id.fancyImageView)
}