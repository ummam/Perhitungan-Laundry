package org.d3if4020.laundryassesment.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.d3if4020.laundryassesment.R
import org.d3if4020.laundryassesment.data.HitungLaundry
import org.d3if4020.laundryassesment.databinding.ItemHistoriBinding
import org.d3if4020.laundryassesment.db.LaundryEntity
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter  : RecyclerView.Adapter<HistoriAdapter.ViewHolder>() {
    private val data = mutableListOf<LaundryEntity>()
    fun updateData(newData: List<LaundryEntity>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
    override fun getItemCount(): Int {
        return data.size
    }
    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID")
        )
        fun bind(item: LaundryEntity) = with(binding) {
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            val hasilLaundry = HitungLaundry.hitung(item)
            hasilTextView.text = root.context.getString(
                R.string.totalHarga)
            laundryTextView.text = root.context.getString(
                R.string.total, hasilLaundry.hasil)
            bulananTextView.text = root.context.getString(R.string.bulanan_x,
                item.bulanan)
        }
    }
}