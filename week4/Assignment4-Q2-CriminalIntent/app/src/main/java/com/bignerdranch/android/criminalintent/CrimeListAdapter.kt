package com.bignerdranch.android.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding
import com.bignerdranch.android.criminalintent.databinding.ListItemSeriousCrimeBinding

class CrimeHolder(
    private val binding: ListItemCrimeBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
            binding.root.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "${crime.title} It's just a normal case!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
}

class SeriousCrimeHolder(
    private val bind:ListItemSeriousCrimeBinding
) : RecyclerView.ViewHolder(bind.root) {
    fun bind(crime: Crime) {
            bind.crimeTitle.text = crime.title
            bind.crimeDate.text = crime.date.toString()
            bind.root.setOnClickListener {
                Toast.makeText(
                    bind.root.context,
                    "${crime.title} Oh, it's a serious case! We need the police!",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }

class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<CrimeHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size

    override fun getItemViewType(position: Int): Int {
        val crime=crimes[position]
        if(crime.requiresPolice==0){
            return 1
        }else {
            return 2
        }
    }
}
class SeriousCrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<SeriousCrimeHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SeriousCrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemSeriousCrimeBinding.inflate(inflater, parent, false)
        return SeriousCrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: SeriousCrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size

    override fun getItemViewType(position: Int): Int {
        val crime=crimes[position]
        if(crime.requiresPolice==0){
            return 1
        }else {
            return 2
        }
    }
}

