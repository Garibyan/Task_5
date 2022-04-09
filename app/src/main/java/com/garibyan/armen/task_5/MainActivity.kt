package com.garibyan.armen.task_5

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.garibyan.armen.task_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: InfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(InfoViewModel::class.java)

        binding.btnSave.setOnClickListener {
            val runDistance = binding.edtRuningDistance.text.toString()
            val swimmDistance = binding.edtSwimmingDistance.text.toString()
            val takenColories = binding.edtTakenColories.text.toString()

            if (runDistance.isNotEmpty() && swimmDistance.isNotEmpty() && takenColories.isNotEmpty()) {
                var newInfo = InfoModel(
                    runDistance.toDouble(),
                    swimmDistance.toDouble(),
                    takenColories.toDouble()
                )
                viewModel.addInfo(newInfo)
                Toast.makeText(this, R.string.info_added, Toast.LENGTH_SHORT).show()
            }

            viewModel.getSumOfRunningDistance.observe(this, { q ->
                binding.tvRunningSum.text =
                    "Whole running distance = $q"
            })
            viewModel.getAverageRunningDistance.observe(this, { q ->
                binding.tvAvgRunDis.text =
                    ("Average running distance = ${String.format("%.1f", q).toDouble()}")
            })
            viewModel.getAverageSwimmingDistance.observe(this, { q ->
                binding.tvAvgSwimmDis.text =
                    ("Average swimming distance = ${String.format("%.1f", q).toDouble()}")
            })
            viewModel.getAverageTakenColoriesDistance.observe(this, { q ->
                binding.tvAvgTakenColories.text =
                    ("Average taken colories = ${String.format("%.1f", q).toDouble()}")
            })
        }
    }
}