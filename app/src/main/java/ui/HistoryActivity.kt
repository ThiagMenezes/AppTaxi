package ui

import HistoryAdapter
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptaxi.databinding.ActivityHistoryBinding
import data.network.RetrofitInstance
import data.network.RideHistoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuração da RecyclerView
        binding.rvHistory.layoutManager = LinearLayoutManager(this)

        binding.btnFilter.setOnClickListener {
            val customerId = binding.etCustomerId.text.toString()
            val selectedDriverId = binding.spDriverFilter.selectedItem?.toString()?.toIntOrNull()

            if (customerId.isNotEmpty()) {
                fetchRideHistory(customerId, selectedDriverId)
            } else {
                showErrorToast(this)
            }
        }
    }

    private fun fetchRideHistory(customerId: String, driverId: Int?) {
        RetrofitInstance.api.getRideHistory(customerId, driverId).enqueue(object : Callback<RideHistoryResponse> {
            override fun onResponse(call: Call<RideHistoryResponse>, response: Response<RideHistoryResponse>) {
                if (response.isSuccessful) {
                    val rideHistory = response.body()?.rides ?: emptyList()
                    binding.rvHistory.adapter = HistoryAdapter(rideHistory)
                } else {
                    Toast.makeText(this@HistoryActivity, "Erro ao buscar histórico", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RideHistoryResponse>, t: Throwable) {
                Toast.makeText(this@HistoryActivity, "Erro de rede: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showErrorToast(context: Context) {
        Toast.makeText(context, "ID do cliente inválido. Por favor, insira um número válido.", Toast.LENGTH_SHORT).show()
    }
}
