package data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apptaxi.R
import data.DriverOption

class DriverOptionsAdapter(
    private val options: List<DriverOption>,
    private val onOptionSelected: (DriverOption) -> Unit
) : RecyclerView.Adapter<DriverOptionsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDriverName: TextView = view.findViewById(R.id.tv_driver_name)
        val tvVehicle: TextView = view.findViewById(R.id.tv_vehicle)
        val tvValue: TextView = view.findViewById(R.id.tv_value)
        val tvRating: TextView = view.findViewById(R.id.tv_rating)
        val btnChoose: Button = view.findViewById(R.id.btn_choose)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_driver_option, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val option = options[position]

        holder.tvDriverName.text = option.name
        holder.tvVehicle.text = option.vehicle
        holder.tvValue.text = "R$ ${option.value}"
        holder.tvRating.text = "Nota: ${option.review.rating}"

        holder.btnChoose.setOnClickListener {
            onOptionSelected(option)
        }
    }

    override fun getItemCount() = options.size
}
