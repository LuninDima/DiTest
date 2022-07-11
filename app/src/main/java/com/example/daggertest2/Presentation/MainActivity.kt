package  com.example.daggertest2.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.daggertest2.R
import com.example.daggertest2.app.App
import com.example.domain.usecase.GetUserNameUseCase
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
  lateinit var vmFactory:MainViewModelFactory
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       (applicationContext as App).appComponent.inject(this)
        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

        Log.e("AAA", "Activity created")

        val dataTextView =  findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)


        vm.resultLive.observe(this, {text ->
            dataTextView.text = text
        })

        sendButton.setOnClickListener(){
            val text = dataEditText.text.toString()
            vm.save(text)

        }

        receiveButton.setOnClickListener(){
            vm.load()
        }
    }
}