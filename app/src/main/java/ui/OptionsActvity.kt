import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptaxi.databinding.ActivityOptionsBinding
import data.DriverOption
import ui.HistoryActivity

class OptionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDriverOptions.layoutManager = LinearLayoutManager(this)
    }
    private fun confirmRide(selectionOption: DriverOption) {
        val intent = Intent(this, HistoryActivity::class.java)
        startActivity(intent)
        finish()
    }

}
