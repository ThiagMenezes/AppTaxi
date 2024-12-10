package ui

import OptionsActivity
import RideViewModelFactory
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apptaxi.R
import data.EstimativeRideRequest
import data.network.RetrofitInstance
import data.repository.RideRepository
import viewModel.RideViewModel
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {

    private lateinit var customer_id: EditText
    private lateinit var origin: EditText
    private lateinit var destination: EditText
    private lateinit var btnEstimate: Button
    private lateinit var loadingIndicator: ProgressBar

    private val viewModel: RideViewModel by viewModels {
        RideViewModelFactory(RideRepository(RetrofitInstance.api))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customer_id = findViewById(R.id.customer_id)
        origin = findViewById(R.id.origin)
        destination = findViewById(R.id.destination)
        btnEstimate = findViewById(R.id.btn_estimate)
        loadingIndicator = findViewById(R.id.loadingIndicator)

        btnEstimate.setOnClickListener {
            val request = EstimativeRideRequest(
                customer_id = customer_id.text.toString(),
                origin = origin.text.toString(),
                destination = destination.text.toString()

            )
            viewModel.estimateRide(request)
        }

        viewModel.estimateResponse.observe(this) { response ->
            val Intent = Intent(this, OptionsActivity::class.java)
            startActivity(Intent)

        }

        viewModel.errorMessage.observe(this) { error ->
            showErrorToast(this)
        }


    }

    private fun showErrorToast(context: Context) {
        Toast.makeText(context, "Voce precisa preencher todos os campos.", Toast.LENGTH_SHORT)
            .show()
    }
}
