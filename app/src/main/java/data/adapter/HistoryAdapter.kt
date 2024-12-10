import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apptaxi.R
import data.network.Ride


class HistoryAdapter(private val rides: List<Ride>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tv_date)
        val tvOrigin: TextView = view.findViewById(R.id.tv_origin)
        val tvDestination: TextView = view.findViewById(R.id.tv_destination)
        val tvValue: TextView = view.findViewById(R.id.tv_value)
        val tvRating: TextView = view.findViewById(R.id.tv_rating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ride = rides[position]
        holder.tvDate.text = ride.date
        holder.tvOrigin.text = "Origem: ${ride.origin}"
        holder.tvDestination.text = "Destino: ${ride.destination}"
        holder.tvValue.text = "Valor: R$ ${ride.value}"
    }

    override fun getItemCount() = rides.size
}
